
import static ctl.atoms.True.True;
import static ctl.logicOperators.AND.*;
import static ctl.logicOperators.NOT.*;
import static ctl.atoms.Atom.*;
import static ctl.logicOperators.OR.*;
import static ctl.atoms.False.*;
import static ctl.operators.AX.*;
import static ctl.operators.AU.*;
import static ctl.operators.AG.*;
import static ctl.operators.AF.*;
import static ctl.operators.EG.*;
import static ctl.operators.EX.*;
import static ctl.operators.EU.*;
import static ctl.operators.EF.*;

import static org.junit.jupiter.api.Assertions.*;

import ctl.atoms.Atom;
import ctl.atoms.False;
import ctl.atoms.True;
import ctl.logicOperators.AND;
import ctl.operators.*;
import kripke.util.CtlFactory;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CtlFactoryTest {

    @Test
    public void atomTest(){
        Atom expected = (Atom)CtlFactory.build("a");
        Atom res = atom("a");
        assertEquals(res,expected);
    }

    @Test
    public void trueTest(){
        True expected = (True)CtlFactory.build("true");
        assertEquals(True(),expected);
    }

    @Test
    public void falseTest(){
        False expected = (False)CtlFactory.build("false");
        assertEquals(False(),expected);
    }

    @Test
    public void auTest(){
        AU expected = (AU)CtlFactory.build("A((a&&b)Ua)");
        AU res = au(and(atom("a"),atom("b")),atom("a"));
        assertEquals(res,expected);
    }

    @Test
    public void afTest(){
        AF expected = (AF)CtlFactory.build("AF(a)");
        AF res = af(atom("a"));
        assertEquals(res,expected);
    }

    @Test
    public void axTest(){
        AX expected = (AX)CtlFactory.build("AX(a&&b)");
        AX res = ax(and(atom("a"),atom("b")));
        assertEquals(res,expected);
    }

    @Test
    public void euTest() {
        EU expected = (EU)CtlFactory.build("E((a&&b)U(c||a))");
        EU res = eu(and(atom("a"),atom("b")),or(atom("c"),atom("a")));
        assertEquals(res,expected);
    }

    @Test
    public void egTest() {
        EG expected = (EG)CtlFactory.build("EG(^(a))");
        EG res = eg(not(atom("a")));
        assertEquals(res,expected);
    }
}
