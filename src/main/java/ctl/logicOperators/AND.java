package ctl.logicOperators;

import ctl.Formula;
import lombok.*;

/**
 * @author kainingxin
 */


@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AND implements Formula {
    @NonNull
    private Formula leftFormula;
    @NonNull
    private Formula rightFormula;

    public static AND and(Formula leftFormula, Formula rightFormula) {
        return new AND(leftFormula,rightFormula);
    }
    
    @Override
    public Formula convert() {
        return and(leftFormula.convert(),rightFormula.convert()) ;
    }

    @Override
    public String toString() {
        return String.format("(%s AND %s)",leftFormula,rightFormula);
    }
}
