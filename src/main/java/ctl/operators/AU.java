package ctl.operators;

import ctl.Formula;
import lombok.*;
import static ctl.logicOperators.NOT.*;
import static ctl.logicOperators.AND.*;

import static ctl.operators.EU.*;
import static ctl.operators.AF.*;


/**
 * @author kainingxin
 */
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AU implements Formula {
    @NonNull
    private Formula leftFormula;
    @NonNull
    private Formula rightFormula;

    public static AU au(Formula leftFormula,Formula rightFormula) {
        return new AU(leftFormula,rightFormula);
    }

    @Override
    public Formula convert() {
        return and(not(eu(not(rightFormula),not(and(leftFormula,rightFormula)))),af(rightFormula));
    }

    @Override
    public String toString() {
        return String.format("AU(%s,%s)",leftFormula,rightFormula);
    }
}
