package kripke.util;

import antlr.ctlLexer;
import antlr.ctlParser;
import ctl.CtlVisitorImpl;
import ctl.Formula;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class CtlFactory {


    public static Formula build(String ctlStr) {
        if (ctlStr == null || ctlStr.isEmpty()){
            throw new IllegalArgumentException("Ctl formula is empty");
        }

        try {
            ctlLexer ctlLexer = new ctlLexer(CharStreams.fromString(ctlStr.replaceAll("\s+","")));
            CommonTokenStream commonTokenStream = new CommonTokenStream(ctlLexer);
            ctlParser ctlParser = new ctlParser(commonTokenStream);
            ParseTree parseTree = ctlParser.expression();
            CtlVisitorImpl visitor = new CtlVisitorImpl();
            return visitor.visit(parseTree);
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }

    }
    
}
