import com.google.common.collect.Sets;
import ctl.Formula;
import static ctl.operators.AG.*;
import static ctl.atoms.Atom.*;


import static ctl.operators.AX.*;
import static ctl.operators.EX.*;

import ctl.atoms.True;
import ctl.logicOperators.AND;
import ctl.operators.AU;
import kripke.Kripke;
import kripke.State;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TransformationTest {

    @Test
    public void convert_test_1(){
        Formula formula2 = AU.au(atom("b"),atom("c")).convert();
        Formula formula = ag(atom("2")).convert();
        Formula formula1 = AND.and(ax(ag(ex(atom("s")))),ag(atom("2"))).convert();

        System.out.println(formula2);
        System.out.println(formula);
        System.out.println(formula1);
    }
    
    @Test
    public void kriple_test_1(){

        State s0 = new State("s0", true,Arrays.asList("a", "b"));
        State s1 = new State("s1", Arrays.asList("b"));
        State s2 = new State("s2", Arrays.asList("b"));
        State s3 = new State("s3", Arrays.asList("c"));

        Kripke kripke = new Kripke();
        kripke.setVals(Sets.newHashSet("a","b","c"));
        kripke.addInitState(s0);
        kripke.setStates(Sets.newHashSet(s1,s2,s3));
        kripke.addTransition(s0, s1);
        kripke.addTransition(s0, s2);
        kripke.addTransition(s1, s1);
        kripke.addTransition(s1, s2);
        kripke.addTransition(s2, s0);
        kripke.addTransition(s2, s3);
        kripke.addTransition(s3, s1);
    }

}
