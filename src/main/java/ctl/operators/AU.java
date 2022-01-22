package ctl.operators;

import ctl.Formula;
import lombok.*;
import static ctl.logicOperators.NOT.*;
import static ctl.logicOperators.AND.*;

import static ctl.operators.EU.*;
import static ctl.operators.EG.*;


@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AU implements Formula {
    private Formula leftFormula;
    private Formula rightFormula;

    public static AU au(Formula leftFormula,Formula rightFormula) {
        return new AU(leftFormula,rightFormula);
    }

    @Override
    public Formula convert() {
        return and(not(eu(not(rightFormula),and(not(leftFormula),not(rightFormula)))),not(eg(not(rightFormula)))).convert();
    }

    @Override
    public String toString() {
        return String.format("AU(%s,%s)",leftFormula,rightFormula);
    }
}
