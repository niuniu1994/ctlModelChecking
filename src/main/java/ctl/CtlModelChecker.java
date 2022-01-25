package ctl;

import com.google.common.collect.Sets;
import ctl.atoms.Atom;
import ctl.atoms.CalculableFormula;
import ctl.atoms.False;
import ctl.atoms.True;
import ctl.logicOperators.AND;
import ctl.logicOperators.NOT;
import ctl.logicOperators.OR;
import ctl.operators.AF;
import ctl.operators.EU;
import ctl.operators.EX;
import kripke.Kripke;
import kripke.State;
import kripke.Transition;
import lombok.extern.log4j.Log4j2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ctl.atoms.False.False;
import static ctl.atoms.True.True;


@Log4j2
public class CtlModelChecker {

    private Kripke kripke;

    public CtlModelChecker(Kripke kripke) {
        this.kripke = kripke;
    }

    /**
     * Atom checked
     *
     * @param atomToCheck
     * @return
     */
    public boolean atomChecker(Atom atomToCheck) {
        for (Atom atom : atomToCheck.getAtomList()) {
            if (kripke.getStates().stream().anyMatch(state -> state.getAtoms().stream()
                    .flatMap(atom1 -> atom1.getValueSet().stream()).collect(Collectors.toSet()).containsAll(atom.getValueSet()))) {
                return true;
            }
        }
        return false;
    }


    public boolean checkCtlFormula(Formula formulaToCheck) {
        Formula formula = formulaToCheck.convert();
        log.info("{} => {}", formulaToCheck, formula);
        formula = ctlFormulaChecker(formula);
        if (formula instanceof True) {
            return true;
        } else if (formula instanceof False) {
            return false;
        } else {
            return atomChecker((Atom) formula);
        }
    }

    /**
     * Not formula
     *
     * @param formula
     * @return
     */
    public Formula notChecker(Formula formula) {

        if (formula instanceof Atom) {
            List<Set<String>> combinations = new ArrayList<>(kripke.getCombinations());
            List<Atom> atomList = new ArrayList<>();
            //remove all vals in atom
            ((Atom) formula).getAtomList().forEach(atom -> {
                combinations.remove(atom.getValueSet());
            });

            //add the rest in the atomlist
            combinations.forEach(comb -> atomList.add(new Atom(comb)));

            Atom atom = atomList.get(0);
            atom.setAtomList(atomList);
            log.info("not( {} )=>  {}", formula, atom);
            return atom;
        } else if (formula instanceof True t) {
            return t;
        } else if (formula instanceof False f) {
            return f;
        } else {
            return notChecker(ctlFormulaChecker(formula));
        }


    }


    /**
     * And checker
     *
     * @param left
     * @param right
     * @return
     */
    public Formula andChecker(Formula left, Formula right) {

        if (left instanceof False || right instanceof False) {
            return False();
        } else if (left instanceof True && right instanceof True) {
            return True();
        } else if (left instanceof CalculableFormula && !(right instanceof CalculableFormula)) {
            return andChecker(left, ctlFormulaChecker(right));
        } else if (!(left instanceof CalculableFormula) && right instanceof CalculableFormula) {
            return andChecker(ctlFormulaChecker(left), right);
        } else if (left instanceof Atom && right instanceof Atom) {
            // (a or b) and ( c or d or e) => (ac or ad or ae or bc or bd or be)
            Set<Set<String>> valsSetSet = new HashSet<>();

            //generate new states
            ((Atom) left).getAtomList().forEach(atomLeft -> {
                ((Atom) right).getAtomList().forEach(atomRight -> {
                    Set<String> res = Stream.concat(atomLeft.getValueSet().stream(), atomRight.getValueSet().stream()).collect(Collectors.toSet());
                    //no duplicate exist than add in list
                    valsSetSet.add(res);
                });
            });

            List<Atom> atomList = valsSetSet.stream().map(Atom::new).collect(Collectors.toList());
            Atom atom = atomList.get(0);
            atom.setAtomList(atomList);
            log.info("{} and {} => {}", left, right, atom);
            return atom;
        } else {
            return andChecker(ctlFormulaChecker(left), ctlFormulaChecker(right));
        }


    }

    /**
     * @param left
     * @param right
     * @return
     */
    public Formula orChecker(Formula left, Formula right) {
        if (left instanceof True || right instanceof True) {
            return True();
        } else if (left instanceof False && right instanceof False) {
            return False();
        } else if (left instanceof CalculableFormula && !(right instanceof CalculableFormula)) {
            return orChecker(left, ctlFormulaChecker(right));
        } else if (!(left instanceof CalculableFormula) && right instanceof CalculableFormula) {
            return orChecker(ctlFormulaChecker(left), right);
        } else if (left instanceof Atom && right instanceof Atom) {
            Set<Set<String>> valsSetSet = Stream.concat(((Atom) left).getAtomList().stream(), ((Atom) right).getAtomList().stream()).map(Atom::getValueSet).collect(Collectors.toSet());
            List<Atom> atomList = valsSetSet.stream().map(Atom::new).collect(Collectors.toList());
            Atom atom = atomList.get(0);
            atom.setAtomList(atomList);
            log.info("{} or {} => {}", left, right, atom);
            return atom;
        } else {
            return orChecker(ctlFormulaChecker(left), ctlFormulaChecker(right));
        }
    }

    /**
     * @param formula
     * @return
     */
    public Formula exChecker(Formula formula) {
        if (formula instanceof Atom) {
            for (Atom atom : ((Atom) formula).getAtomList()) {
                if (kripke.getTransitions().stream().anyMatch(transition -> transition.getEnd().getAtoms()
                        .stream().flatMap(atom1 -> atom1.getValueSet().stream()).collect(Collectors.toSet()).containsAll(atom.getValueSet()))) {
                    log.info("{} => {}", EX.ex(formula), True());
                    return True();
                }
            }
            log.info("{} => {}", EX.ex(formula), False());
            return False();
        } else if (formula instanceof True) {
            return True();
        } else if (formula instanceof False) {
            return False();
        } else {
            return exChecker(ctlFormulaChecker(formula));
        }
    }


    public Formula afChecker(Formula formula) {
            if (formula instanceof Atom) {
                Atom atom = (Atom) formula;
                //1.Mark all states satisfying atom  to v
                Set<State> markedStates = markStates(atom);
                Set<State> unmarkedStates;

                //atom not exist
                if (markedStates.isEmpty()) {
                    return False();
                }
                //marked states are all init states so all true
                if (markedStates.stream().allMatch(State::isInit)) {
                    return True();
                }

                unmarkedStates = kripke.getStates().stream().filter(state -> !markedStates.contains(state)).collect(Collectors.toSet());
                Set<State> start;
                do {
                    start = Sets.newHashSet(unmarkedStates);
                    Iterator<State> it = unmarkedStates.iterator();
                    while (it.hasNext()) {
                        State state = it.next();
                        //2.if there is a state in that has all successor states marked then mark it also
                        Set<State> endStates = kripke.getTransitions().stream().filter(transition -> transition.getStart().equals(state)).map(Transition::getEnd).collect(Collectors.toSet());
                        if (markedStates.containsAll(endStates)) {
                            markedStates.add(state);
                            it.remove();
                        }
                    }

                } while (!start.equals(unmarkedStates));

                return unmarkedStates.isEmpty() ? True() : False();
            } else if (formula instanceof True) {
                return True();
            } else if (formula instanceof False) {
                return False();
            } else {
                return afChecker(ctlFormulaChecker(formula));
            }
    }

    public Formula euChecker(Formula left, Formula right) {
        if (right instanceof True) {
            return True();
        } else if (right instanceof False) {
            return False();
        } else if (left instanceof CalculableFormula && !(right instanceof CalculableFormula)) {
            return euChecker(left, ctlFormulaChecker(right));
        } else if (!(left instanceof CalculableFormula) && right instanceof CalculableFormula) {
            return euChecker(ctlFormulaChecker(left), right);
        } else if (!(left instanceof CalculableFormula) && !(right instanceof CalculableFormula)) {
            return euChecker(ctlFormulaChecker(left), ctlFormulaChecker(right));
        } else if (left instanceof True && right instanceof Atom) {
            return right;
        } else if (left instanceof False && right instanceof Atom) {
            Set<Set<String>> startStatesVals = new HashSet<>();
            kripke.getInitStates().forEach(state -> {
                startStatesVals.add(state.getAtoms().stream().flatMap(atom -> atom.getValueSet().stream()).collect(Collectors.toSet()));
            });

            Set<Set<String>> atomStatesVals = ((Atom) right).getAtomList().stream().map(Atom::getValueSet).collect(Collectors.toSet());

            if (startStatesVals.containsAll(atomStatesVals)) {
                return True();
            }
            return False();
        } else if (left instanceof Atom && right instanceof Atom) {
            Atom leftAtom = (Atom) left;
            Atom rightAtom = (Atom) right;
            //1.Mark all states satisfying rightAtom to v
            Set<State> rightMarkedStates = markStates(rightAtom);
            Set<State> leftUnmarkedStates = markStates(leftAtom);

            //atom not exist
            if (rightMarkedStates.isEmpty()) {
                return False();
            }
            //marked states are all init states so all true
            if (rightMarkedStates.stream().allMatch(State::isInit)) {
                return True();
            }

            //2 if there is a state in leftAtom that has some successor state marked then mark it also
            Set<State> start;
            do {
                start = Sets.newHashSet(leftUnmarkedStates);
                Iterator<State> it = leftUnmarkedStates.iterator();
                while (it.hasNext()) {
                    State state = it.next();
                    Set<State> endStates = kripke.getTransitions().stream().filter(transition -> transition.getStart().equals(state)).map(Transition::getEnd).collect(Collectors.toSet());
                    for (State endState : endStates) {
                        if (rightMarkedStates.contains(endState)) {
                            rightMarkedStates.add(state);
                            it.remove();
                            break;
                        }
                    }
                }
                if (rightMarkedStates.stream().anyMatch(State::isInit)) {
                    return True();
                }
            } while (!start.equals(leftUnmarkedStates));

            if (rightMarkedStates.stream().anyMatch(State::isInit)) {
                return True();
            }
            return False();
        }

        log.error("shouldn't not reached");
        return null;

    }

    private Formula ctlFormulaChecker(Formula formulaToCheck) {
        if (formulaToCheck instanceof CalculableFormula) {
            return formulaToCheck;
        } else if (formulaToCheck instanceof NOT) {
            return notChecker(((NOT) formulaToCheck).getFormula());
        } else if (formulaToCheck instanceof AND) {
            AND and = (AND) formulaToCheck;
            return andChecker(and.getLeftFormula(), (and.getRightFormula()));
        } else if (formulaToCheck instanceof OR) {
            OR or = (OR) formulaToCheck;
            return orChecker(or.getLeftFormula(), or.getRightFormula());
        } else if (formulaToCheck instanceof EX) {
            return exChecker(((EX) formulaToCheck).getFormula());
        } else if (formulaToCheck instanceof AF) {
            return afChecker(((AF) formulaToCheck).getFormula());
        } else if (formulaToCheck instanceof EU) {
            EU eu = (EU) formulaToCheck;
            return euChecker(eu.getLeftFormula(), eu.getRightFormula());
        }
        log.error("shouldn't not reach here");
        return null;
    }

    private Set<State> markStates(Atom atom) {
        Set<State> markedStates = new HashSet<>();
        atom.getAtomList().forEach(atom1 -> {
            kripke.getStates().forEach(state -> {
                Set<String> stateVals = state.getAtoms().stream().flatMap(atom2 -> atom2.getValueSet().stream()).collect(Collectors.toSet());
                if (stateVals.containsAll(atom1.getValueSet())) {
                    markedStates.add(state);
                }
            });
        });
        return markedStates;
    }

}
