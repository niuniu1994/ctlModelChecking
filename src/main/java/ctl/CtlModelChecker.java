package ctl;


import ctl.atoms.Atom;
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

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public Set<State> atomChecker(Atom atomToCheck) {
        return  kripke.getStates().stream().filter(state -> state.getAtoms().contains(atomToCheck)).collect(Collectors.toSet());
    }


    public List<String> checkCtlFormula(Formula formulaToCheck) {
        if (formulaToCheck == null) {
            System.out.println("formula is empty");
            return new ArrayList<>();
        }

        Formula formula = formulaToCheck.convert();
        System.out.println( formulaToCheck + " => " + formula);
        return ctlFormulaChecker(formula).stream().map(State::getName).sorted().collect(Collectors.toList());
    }

    /**
     *
     * @param states
     * @return
     */
    public Set<State> notChecker(Set<State> states) {
        return kripke.getStates().stream().filter(state -> !states.contains(state)).collect(Collectors.toSet());
    }


    /**
     *
     * @param left
     * @param right
     * @return
     */
    public Set<State> andChecker(Set<State> left, Set<State> right) {
        return left.stream().filter(right::contains).collect(Collectors.toSet());
    }

    /**
     * @param left
     * @param right
     * @return
     */
    public Set<State> orChecker(Set<State> left, Set<State> right) {
       return Stream.concat(left.stream(),right.stream()).collect(Collectors.toSet());
    }

    /**
     * @param states
     * @return
     */
    public Set<State> exChecker(Set<State> states) {
       return kripke.getTransitions().stream().filter(transition -> states.contains(transition.getEnd())).map(Transition::getStart).collect(Collectors.toSet());
    }


    public Set<State> afChecker(Set<State> states) {
        Set<State> res = new HashSet<>(states);
        State s = null;
        do {
            s = kripke.getStates().stream().filter(state -> res.containsAll(kripke.getTransitions().stream()
                    .filter(transition -> transition.getStart().equals(state)).map(Transition::getEnd)
                    .collect(Collectors.toSet()))).filter(state -> !res.contains(state)).findFirst().orElse(null);
            if (s != null) res.add(s);
        } while (s != null);
        return res;
    }

    public Set<State> euChecker(Set<State> left, Set<State> right) {
        Set<State> res = new HashSet<>(right);
        State s = null;
        do {
            s = left.stream().filter(state -> !Collections.disjoint(res,kripke.getTransitions().stream()
                    .filter(transition -> transition.getStart().equals(state)).map(Transition::getEnd)
                    .collect(Collectors.toSet()))).filter(state -> !res.contains(state)).findFirst().orElse(null);
            if (s != null) res.add(s);
        } while (s != null);
        return res;
    }

    public Set<State> trueChecker(){
        return kripke.getStates();
    }

    public Set<State> falseChecker(){
        return new HashSet<>();
    }

    private Set<State> ctlFormulaChecker(Formula formulaToCheck) {
        if (formulaToCheck == null){
            return new HashSet<>();
        }

        if (formulaToCheck instanceof Atom atom) {
            return atomChecker(atom);
        } else if (formulaToCheck instanceof NOT not) {
            return notChecker(ctlFormulaChecker(not.getFormula()));
        } else if (formulaToCheck instanceof AND and) {
            return andChecker(ctlFormulaChecker(and.getLeftFormula()),ctlFormulaChecker(and.getRightFormula()));
        } else if (formulaToCheck instanceof OR or) {
            return orChecker(ctlFormulaChecker(or.getLeftFormula()), ctlFormulaChecker(or.getRightFormula()));
        } else if (formulaToCheck instanceof EX ex) {
            return exChecker(ctlFormulaChecker(ex.getFormula()));
        } else if (formulaToCheck instanceof AF af) {
            return afChecker(ctlFormulaChecker(af.getFormula()));
        } else if (formulaToCheck instanceof EU eu) {
            return euChecker(ctlFormulaChecker(eu.getLeftFormula()),ctlFormulaChecker(eu.getRightFormula()));
        }else if (formulaToCheck instanceof True){
            return trueChecker();
        }else if (formulaToCheck instanceof False){
            return falseChecker();
        }

        return new HashSet<>();
    }

}
