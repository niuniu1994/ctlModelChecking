package kripke.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kripke.Kripke;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author kainingxin
 */
public class KripkeFactory {
    
    public static Kripke build(String path) throws IOException {
        BufferedReader reader = Files.newBufferedReader(Path.of(path));
        return new ObjectMapper().readValue(reader,Kripke.class);
    }

    public static String write(Kripke kripke) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(kripke);
    }

}
