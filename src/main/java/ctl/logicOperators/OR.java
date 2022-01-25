package ctl.logicOperators;
import static ctl.logicOperators.NOT.*;
import static ctl.logicOperators.AND.*;
import ctl.Formula;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OR implements Formula {
    private Formula leftFormula;
    private Formula rightFormula;

    public static OR or(Formula leftFormula, Formula rightFormula){
        return new OR(leftFormula,rightFormula);
    }


    @Override
    public Formula convert() {
        return or(leftFormula.convert(),rightFormula.convert());
    }

    @Override
    public String toString() {
        return String.format("(%s OR %s)",leftFormula,rightFormula);
    }
}
