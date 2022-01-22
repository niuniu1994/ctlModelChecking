package ctl;

import ctl.atoms.Atom;
import ctl.atoms.CalculableFormula;
import ctl.atoms.False;
import ctl.atoms.True;
import ctl.logicOperators.AND;
import ctl.logicOperators.NOT;
import ctl.logicOperators.OR;
import ctl.operators.AF;
import ctl.operators.EX;
import kripke.Kripke;
import kripke.State;
import lombok.extern.log4j.Log4j2;
import static ctl.atoms.True.*;
import static ctl.atoms.False.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
public class CtlModelChecker {

    private Kripke kripke;

    public CtlModelChecker(Kripke kripke) {
        this.kripke = kripke;
    }

    /**
     * Atom checked
     * @param atomToCheck
     * @return
     */
    public boolean atomChecker(Atom atomToCheck){
        for (Atom atom: atomToCheck.getAtomList()) {
            if (kripke.getStates().stream().anyMatch(state -> state.getAtoms().stream()
                    .flatMap(atom1 -> atom1.getValueSet().stream()).collect(Collectors.toSet()).containsAll(atom.getValueSet()))){
                return true;
            }
        }
        return false;
    }




    public boolean checkCtlFormula(Formula formulaToCheck){
        Formula formula = ctlFormulaChecker(formulaToCheck);
        if (formula instanceof True){
            return true;
        }else if (formula instanceof  False){
            return false;
        }else{
            return atomChecker((Atom)formula);
        }
    }

    /**
     * Not checker
     * @param notFormula
     * @return
     */
    public Formula notChecker(NOT notFormula){
        if (notFormula.getFormula() instanceof Atom){
            List<Set<String>> combinations = new ArrayList<>(kripke.getCombinations());
            List<Atom> atomList = new ArrayList<>();
            //remove all vals in atom
            ((Atom)notFormula.getFormula()).getAtomList().forEach(atom -> {
                combinations.remove(atom.getValueSet());
            });

            //add the rest in the atomlist
            combinations.forEach(comb -> atomList.add(new Atom(comb)));

            Atom atom = atomList.get(0);
            atom.setAtomList(atomList);
            log.info("not( {} )=>  {}",notFormula.getFormula(),atom);
            return atom;
        }else if (notFormula.getFormula() instanceof  True){
            return False::new;
        }else if (notFormula.getFormula() instanceof  False){
            return True::new;
        }else {
            return ctlFormulaChecker(notFormula.getFormula());
        }
    }


    /**
     * And checker
     * @param left
     * @param right
     * @return
     */
    public Formula andChecker(Formula left, Formula right){

        if (left instanceof False || right instanceof False){
            return False();
        }else if (left instanceof True && right instanceof True){
            return True();
        }else if (left instanceof CalculableFormula && !(right instanceof CalculableFormula)){
            return andChecker(left,ctlFormulaChecker(right));
        }else if (!(left instanceof CalculableFormula) && right instanceof CalculableFormula){
            return andChecker(ctlFormulaChecker(left),right);
        }else if (left instanceof Atom && right instanceof Atom){
            // (a or b) and ( c or d or e) => (ac or ad or ae or bc or bd or be)
            Set<Set<String>> valsSetSet = new HashSet<>();

            //generate new states
            ((Atom) left).getAtomList().forEach(atomLeft -> {
                ((Atom) right).getAtomList().forEach(atomRight -> {
                    Set<String> res = Stream.concat(atomLeft.getValueSet().stream(),atomRight.getValueSet().stream()).collect(Collectors.toSet());
                    //no duplicate exist than add in list
                    valsSetSet.add(res);
                });
            });

            List<Atom> atomList = valsSetSet.stream().map(Atom::new).collect(Collectors.toList());
            Atom atom = atomList.get(0);
            atom.setAtomList(atomList);
            log.info("{} and {} => {}",left,right,atom);
            return atom;
        }else {
            return andChecker(ctlFormulaChecker(left),ctlFormulaChecker(right));
        }


    }

    /**
     *
     * @param left
     * @param right
     * @return
     */
    public Formula orChecker(Formula left, Formula right){
        if (left instanceof True || right instanceof True){
            return True();
        }else if (left instanceof False && right instanceof False){
            return False();
        }else if (left instanceof CalculableFormula && !(right instanceof CalculableFormula)){
            return orChecker(left,ctlFormulaChecker(right));
        }else if (! (left instanceof CalculableFormula) && right instanceof CalculableFormula){
            return orChecker(ctlFormulaChecker(left),right);
        }else if (left instanceof Atom && right instanceof Atom){
           Set<Set<String>> valsSetSet = Stream.concat(((Atom) left).getAtomList().stream(),((Atom) right).getAtomList().stream()).map(Atom::getValueSet).collect(Collectors.toSet());
           List<Atom> atomList = valsSetSet.stream().map(Atom::new).collect(Collectors.toList());
           Atom atom = atomList.get(0);
           atom.setAtomList(atomList);
           log.info("{} or {} => {}",left,right,atom);
           return atom;
        }else {
            return orChecker(ctlFormulaChecker(left),ctlFormulaChecker(right));
        }
    }

    /**
     *
     * @param exFormula
     * @return
     */
    public Formula exChecker(Formula exFormula) {
        if (exFormula instanceof EX) {
            Formula formula = ((EX) exFormula).getFormula();
            if (formula instanceof Atom) {
                for (Atom atom : ((Atom) formula).getAtomList()) {
                    if (kripke.getTransitions().stream().anyMatch(transition -> transition.getEnd().getAtoms()
                            .stream().flatMap(atom1 -> atom1.getValueSet().stream()).collect(Collectors.toSet()).containsAll(atom.getValueSet()))) {
                        log.info("{} => {}",exFormula,True());
                        return True();
                    }
                }
                log.info("{} => {}",exFormula,False());
                return False();
            } else if (formula instanceof True) {
                return True();
            } else if (formula instanceof False) {
                return False();
            } else {
                return exChecker(ctlFormulaChecker(formula));
            }
        }else {
            log.error("{} is not a EX formula", exFormula);
            throw new IllegalArgumentException();
        }

    }

    public Formula afChecker(Formula afFormula){
        if (afFormula instanceof AF){
            Formula formula = ((AF)afFormula).getFormula();
            if (formula instanceof Atom){

            }else if (formula instanceof True){
                return True();
            }else if (formula instanceof False){
                return  False();
            }else {
                return afChecker(ctlFormulaChecker(formula));
            }
        }else {
            log.error("{} is not a AX formula", afFormula);
            throw new IllegalArgumentException();
        }
    }

    private Formula ctlFormulaChecker( Formula formulaToCheck){
        if (formulaToCheck instanceof CalculableFormula){
            return formulaToCheck;
        }else if (formulaToCheck instanceof NOT){
            return notChecker((NOT) formulaToCheck);
        }else if (formulaToCheck instanceof AND){
            AND and = (AND) formulaToCheck;
            return andChecker(and.getLeftFormula(),(and.getRightFormula()));
        }else if (formulaToCheck instanceof OR){
            OR or = (OR) formulaToCheck;
            return orChecker(or.getLeftFormula(),or.getRightFormula());
        }else if(formulaToCheck instanceof EX){

        }

        return null;
    }

}
