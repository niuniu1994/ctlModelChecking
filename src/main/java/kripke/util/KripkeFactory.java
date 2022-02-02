package kripke.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ctl.atoms.Atom;
import kripke.Kripke;
import kripke.State;
import kripke.Transition;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author kainingxin
 */
public class KripkeFactory {
    
    public static Kripke build(String path) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of(path));
        Kripke kripke = new ObjectMapper().readValue(reader,Kripke.class);
        kripleVerify(kripke);
        return kripke;
    }

    public static String write(Kripke kripke) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(kripke);
    }

    /**
     * Verification
     * @param kripke
     */
    private static void kripleVerify(Kripke kripke){
        //Verify the atomic propositions possess by state are in vals set
        Set<String> valSets = kripke.getStates().stream().flatMap(state -> state.getAtoms().stream()).map(Atom::getValue).collect(Collectors.toSet());
        if (!kripke.getVals().containsAll(valSets)){
            Set<String> set = valSets.stream().filter(s -> !kripke.getVals().contains(s)).collect(Collectors.toSet());
            System.out.println("Unknown atomic proposition found in states : " + set);
            throw new IllegalArgumentException("Unknown atomic proposition found in states : " + set);
        }

        //Verify state name no duplicate
        List<String> names = kripke.getStates().stream().map(State::getName).toList();
        if (kripke.getStates().size() != new HashSet<>(names).size()){
            System.out.println("Duplicate state name found : " + names);
            throw new IllegalArgumentException("Unknown atomic proposition found in states : " + names);
        }

        //Verify every state start a transition
        List<State> states = kripke.getTransitions().stream().map(Transition::getStart).toList();
        if (kripke.getStates().size() != new HashSet<>(states).size()){
            Set<String> ss = kripke.getStates().stream().filter(state -> !states.contains(state)).map(State::getName).collect(Collectors.toSet());

            System.out.println("Containing no source state: " + ss );
            throw new IllegalArgumentException("Containing no source state : " + ss);
        }

    }

}
