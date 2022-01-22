package ctl.logicOperators;

import static  ctl.logicOperators.OR.*;
import static  ctl.logicOperators.NOT.*;
import ctl.Formula;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class IMPLIES implements Formula{
    private Formula leftFormula;
    private Formula rightFormula;

    public static IMPLIES implies(Formula leftFormula,Formula rightFormula){
        return new IMPLIES(leftFormula,rightFormula);
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
