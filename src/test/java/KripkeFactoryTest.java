import kripke.Kripke;
import kripke.util.KripkeFactory;
import kripke.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * KripkeFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 23, 2022</pre>
 */
public class KripkeFactoryTest {

    private Kripke kripke;

    private Kripke kripke1;

    @BeforeEach
    public void setup() {
        State s0 = new State("s0", Arrays.asList("c"));
        State s1 = new State("s1", List.of("a"));
        State s2 = new State("s2", List.of("a","b"));
        State s3 = new State("s3", List.of("b"));
        State s4 = new State("s4", List.of("b"));


        Kripke kripke = new Kripke();

        kripke.setVals(Set.of("a", "b", "c"));
        kripke.addInitState(s0);
        kripke.addInitState(s3);
        kripke.setStates(Set.of(s0, s1, s2, s3,s4));
        kripke.addTransition(s0, s4);
        kripke.addTransition(s0, s1);
        kripke.addTransition(s1, s2);
        kripke.addTransition(s2, s3);
        kripke.addTransition(s3, s3);
        kripke.addTransition(s3, s0);
        kripke.addTransition(s4, s4);

        this.kripke = kripke;



    }

    /**
     * Method: readKripkeFromJson(String path)
     */
    @Test
    public void testReadKripkeFromJson() throws Exception {
        Kripke kripke = KripkeFactory.build("src/test/resources/kriple2.json");
        List<State> states = new ArrayList<>(kripke.getStates());
    }

    /**
     * Method: writeKripkeToJson(Kripke kripke)
     */
    @Test
    public void testWriteKripkeToJson() throws Exception {
        String output = KripkeFactory.write(kripke);
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of("src/test/resources/kriple2.json"));

        bufferedWriter.write(output);
        bufferedWriter.close();
    }


} 
