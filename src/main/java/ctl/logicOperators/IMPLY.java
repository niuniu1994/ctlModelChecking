package ctl.logicOperators;

import static  ctl.logicOperators.OR.*;
import static  ctl.logicOperators.NOT.*;
import ctl.Formula;
import lombok.*;

/**
 * @author kainingxin
 */
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class IMPLY implements Formula{
    private Formula leftFormula;
    private Formula rightFormula;

    public static IMPLY imply(Formula leftFormula, Formula rightFormula){
        return new IMPLY(leftFormula,rightFormula);
    }

    @Override
    public Formula convert() {
        return or(not(leftFormula),rightFormula);
    }

    @Override
    public String toString() {
        return String.format("(%s -> %s)",leftFormula,rightFormula);
    }
}
