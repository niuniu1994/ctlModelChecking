import ctl.CtlModelChecker;
import kripke.Kripke;
import kripke.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static ctl.atoms.Atom.atom;
import static ctl.logicOperators.AND.and;
import static ctl.operators.AF.af;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CtlTest {
    private CtlModelChecker ctlModelChecker;
    State s0;
    State s1;
    State s2;
    State s3;
    @BeforeEach
    public  void setup(){

        s0 = new State("s0",List.of("a", "b"));
        s1 = new State("s1", List.of("b"));
        s2 = new State("s2", List.of("b"));
        s3 = new State("s3", List.of("c"));

        Kripke kripke = new Kripke();

        kripke.setVals(Set.of("a","b","c"));
        kripke.addInitState(s0);
        kripke.setStates(Set.of(s0,s1,s2,s3));
        kripke.addTransition(s0, s1);
        kripke.addTransition(s0, s2);
        kripke.addTransition(s1, s1);
        kripke.addTransition(s1, s2);
        kripke.addTransition(s2, s0);
        kripke.addTransition(s2, s3);
        kripke.addTransition(s3, s1);


        ctlModelChecker = new CtlModelChecker(kripke);
    }

    @Test
    public void notCheckerTest(){
        Set<State> res = ctlModelChecker.notChecker(Set.of(s0));
        assertEquals(Set.of(s1,s2,s3),res);
    }

    @Test
    public void andCheckerTest(){
        Set<State> res = ctlModelChecker.andChecker(Set.of(s0,s1,s2),Set.of(s0));
        assertEquals(Set.of(s0),res);
    }

    @Test
    public void orCheckerTest(){
        Set<State> res = ctlModelChecker.orChecker(Set.of(s0,s1,s2),Set.of(s0));
        assertEquals(Set.of(s0,s1,s2),res);
    }


    @Test
    public void exCheckerTest(){
        Set<State> res = ctlModelChecker.exChecker(Set.of(s0,s1,s2));
        assertEquals(Set.of(s0,s1,s2,s3),res);
    }

    @Test
    public void afCheckerTest(){
        Set<State> res = ctlModelChecker.afChecker(Set.of(s0,s1,s2));
        assertEquals(Set.of(s0,s1,s2,s3),res);
    }


    @Test
    public void euCheckTest(){
        Set<State> res = ctlModelChecker.euChecker(Set.of(s0,s1,s2),Set.of(s3));
        assertEquals(Set.of(s0,s1,s2,s3),res);
    }

    @Test
    public void ctlModelChecker(){
        assertEquals(List.of("s0"),ctlModelChecker.checkCtlFormula(af(and(atom("a"),atom("b")))));
    }
}
