import com.google.common.collect.Sets;
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

/**
 * KripkeFactory Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jan 23, 2022</pre>
 */
public class KripkeFactoryTest {

    private Kripke kripke;

    @BeforeEach
    public void setup() {
        State s0 = new State("s0", true, Arrays.asList("a", "b"));
        State s1 = new State("s1", Arrays.asList("b"));
        State s2 = new State("s2", Arrays.asList("b"));
        State s3 = new State("s3", Arrays.asList("c"));

        Kripke kripke = new Kripke();

        kripke.setVals(Sets.newHashSet("a", "b", "c"));
        kripke.addInitState(s0);
        kripke.setStates(Sets.newHashSet(s0, s1, s2, s3));
        kripke.addTransition(s0, s1);
        kripke.addTransition(s0, s2);
        kripke.addTransition(s1, s1);
        kripke.addTransition(s1, s2);
        kripke.addTransition(s2, s0);
        kripke.addTransition(s2, s3);
        kripke.addTransition(s3, s1);

        this.kripke = kripke;
    }

    /**
     * Method: readKripkeFromJson(String path)
     */
    @Test
    public void testReadKripkeFromJson() throws Exception {
        Kripke kripke = KripkeFactory.build("src/test/resources/testOutPut.json");
//        BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of("src/test/resources/atoms.json"));
//        State state = new State("s1", Arrays.asList("b"));
//        bufferedWriter.write(new ObjectMapper().writeValueAsString(state));
//        bufferedWriter.close();
//        BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/test/resources/atoms.json"));
//        State atom = new ObjectMapper().readValue(bufferedReader,State.class);
//        System.out.println(atom);

        List<State> states = new ArrayList<>(kripke.getStates());
        System.out.println(states);
        System.out.println(states.get(0).getAtoms());
    }

    /**
     * Method: writeKripkeToJson(Kripke kripke)
     */
    @Test
    public void testWriteKripkeToJson() throws Exception {
        String output = KripkeFactory.write(kripke);
        BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of("src/test/resources/testOutPut.json"));

        bufferedWriter.write(output);
        bufferedWriter.close();
    }


} 
