import com.google.common.collect.Sets;
import ctl.CtlModelChecker;
import ctl.Formula;
import ctl.atoms.Atom;
import static ctl.logicOperators.AND.*;
import static ctl.logicOperators.NOT.*;
import static ctl.atoms.Atom.*;
import static ctl.logicOperators.OR.*;
import static ctl.atoms.False.*;
import ctl.logicOperators.AND;
import ctl.logicOperators.NOT;
import ctl.logicOperators.OR;

import ctl.operators.EX;
import kripke.Kripke;
import kripke.State;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static ctl.logicOperators.NOT.*;
import static ctl.atoms.Atom.*;

import java.util.Arrays;
import java.util.HashSet;

public class CtlTest {
    private CtlModelChecker ctlModelChecker;

    @BeforeEach
    public  void setup(){

        State s0 = new State("s0", true, Arrays.asList("a", "b"));
        State s1 = new State("s1", Arrays.asList("b"));
        State s2 = new State("s2", Arrays.asList("b"));
        State s3 = new State("s3", Arrays.asList("c"));

        Kripke kripke = new Kripke();

        kripke.setVals(Sets.newHashSet("a","b","c"));
        kripke.addInitState(s0);
        kripke.setStates(Sets.newHashSet(s0,s1,s2,s3));
        kripke.addTransition(s0, s1);
        kripke.addTransition(s0, s2);
        kripke.addTransition(s1, s1);
        kripke.addTransition(s1, s2);
        kripke.addTransition(s2, s0);
        kripke.addTransition(s2, s3);
        kripke.addTransition(s3, s1);

        kripke.initCombinations();

        ctlModelChecker = new CtlModelChecker(kripke);
    }

    @Test
    public void notCheckerTest(){
        Atom atom = new Atom("a");
        Atom atom2 = new Atom("c");

        atom.getAtomList().add(new Atom("b"));
        atom2.getAtomList().add(new Atom("a"));

        NOT notFormula = not(atom);
        Formula res = ctlModelChecker.notChecker(notFormula);

        assertTrue(res instanceof Atom);

    }

    @Test
    public void andCheckerTest(){
        // (a or b) and ( c or d or e) => (ac or ad or ae or bc or bd or be)

        Atom atom = new Atom("a");
        Atom atom2 = new Atom("c");

        AND and = and(atom,atom2);
        Formula formula = ctlModelChecker.andChecker(and.getLeftFormula(),and.getRightFormula());

        atom.getAtomList().add(new Atom("b"));
        atom2.getAtomList().add(new Atom("a"));

        and = and(atom,atom2);
        formula = ctlModelChecker.andChecker(and.getLeftFormula(),and.getRightFormula());
        assertEquals(4,((Atom)formula).getAtomList().size());
        assertTrue(((Atom)formula).getAtomList().stream().anyMatch(a -> a.getValueSet().equals(Sets.newHashSet("a","b"))));
        assertTrue(((Atom)formula).getAtomList().stream().anyMatch(a -> a.getValueSet().equals(Sets.newHashSet("a"))));
        assertTrue(((Atom)formula).getAtomList().stream().anyMatch(a -> a.getValueSet().equals(Sets.newHashSet("a","c"))));
        assertTrue(((Atom)formula).getAtomList().stream().anyMatch(a -> a.getValueSet().equals(Sets.newHashSet("b","c"))));

        AND and1 = and(atom,atom);
        ctlModelChecker.andChecker(and1.getLeftFormula(),and1.getRightFormula());

    }

    @Test
    public void orCheckerTest(){
        Atom atom = new Atom("a");
        Atom atom2 = new Atom("c");

        atom.getAtomList().add(new Atom("b"));
        atom2.getAtomList().add(new Atom("a"));

        OR or = OR.or(atom,atom2);
        Formula formula = ctlModelChecker.orChecker(atom,atom2);
    }

    @Test
    public void firstPhraseTest(){
        assertTrue(ctlModelChecker.checkCtlFormula(and(atom("a"),atom("b"))));
        assertFalse(ctlModelChecker.checkCtlFormula(and(atom("a"),atom("c"))));
        assertTrue(ctlModelChecker.checkCtlFormula(atom("a")));
        assertTrue(ctlModelChecker.checkCtlFormula(atom("c")));
        assertTrue(ctlModelChecker.checkCtlFormula(or(atom("a"),atom("c"))));
        assertTrue(ctlModelChecker.checkCtlFormula(and(not(atom("a")),atom("c"))));
    }

    @Test
    public void exCheckedTest(){
        Atom atom = new Atom("a","c");
        assertEquals(False(),ctlModelChecker.exChecker(EX.ex(atom("a","c"))));


    }

}
