package ctl;
import static ctl.logicOperators.IMPLY.*;
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
import antlr.ctlBaseVisitor;
import antlr.ctlParser;
import ctl.atoms.Atom;
import ctl.operators.AF;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class CtlVisitorImpl extends ctlBaseVisitor<Formula> {

    @Override
    public Formula visitAtomHandler(ctlParser.AtomHandlerContext ctx) {
        String s = ctx.getChild(0).getText();
        return  atom(s);
    }

    @Override
    public Formula visitFalseHandler(ctlParser.FalseHandlerContext ctx) {
        return False();
    }

    @Override
    public Formula visitTrueHandler(ctlParser.TrueHandlerContext ctx) {
        return True();
    }

    @Override
    public Formula visitAndHandler(ctlParser.AndHandlerContext ctx) {
        return and(visit(ctx.expression(0)), visit(ctx.expression(1)));
    }

    @Override
    public Formula visitExHandler(ctlParser.ExHandlerContext ctx) {
        return ex(visit(ctx.expression()));
    }

    @Override
    public Formula visitAxHandler(ctlParser.AxHandlerContext ctx) {
        return ax(visit(ctx.expression()));
    }

    @Override
    public Formula visitAfHandler(ctlParser.AfHandlerContext ctx) {
        return af(visit(ctx.expression()));
    }

    @Override
    public Formula visitAuHandler(ctlParser.AuHandlerContext ctx) {
        return au(visit(ctx.expression(0)),visit(ctx.expression(1)));
    }

    @Override
    public Formula visitAgHandler(ctlParser.AgHandlerContext ctx) {
        return ag(visit(ctx.expression()));
    }

    @Override
    public Formula visitNotHandler(ctlParser.NotHandlerContext ctx) {
        return not(visit(ctx.expression()));
    }

    @Override
    public Formula visitOrHandler(ctlParser.OrHandlerContext ctx) {
        return or(visit(ctx.expression(0)),visit(ctx.expression(1)));
    }

 

    @Override
    public Formula visitEfHandler(ctlParser.EfHandlerContext ctx) {
        return ef(visit(ctx.expression()));
    }

    @Override
    public Formula visitEgHandler(ctlParser.EgHandlerContext ctx) {
        return eg(visit(ctx.expression()));
    }

    @Override
    public Formula visitEuHandler(ctlParser.EuHandlerContext ctx) {
        return eu(visit(ctx.expression(0)),visit(ctx.expression(1)));
    }

    @Override
    public Formula visitBracketHandler(ctlParser.BracketHandlerContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Formula visitImplyHandler(ctlParser.ImplyHandlerContext ctx) {
        return imply(visit(ctx.expression(0)), visit(ctx.expression(1)));
    }

    
}
