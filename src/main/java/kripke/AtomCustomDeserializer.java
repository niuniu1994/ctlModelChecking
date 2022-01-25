package kripke;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ctl.atoms.Atom;

import java.io.IOException;

public class AtomCustomDeserializer extends StdDeserializer<Atom> {
    public AtomCustomDeserializer(){
        this(null);
    }

    protected AtomCustomDeserializer(Class<?> vc) {
        super(vc);
    }



    @Override
    public Atom deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        String val = node.get("valueSet").get(0).asText();
        return new Atom(val);
    }
}
