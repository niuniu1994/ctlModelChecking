package ctl.operators;

import ctl.Formula;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EU implements Formula {
    @NonNull
    private Formula leftFormula;
    @NonNull
    private Formula rightFormula;

    public static EU eu(Formula leftFormula,Formula rightFormula){
        return  new EU(leftFormula,rightFormula);
    }

    @Override
    public Formula convert() {
        return eu(leftFormula.convert(),rightFormula.convert());
    }

    @Override
    public String toString() {
        return String.format("EU(%s,%s)",leftFormula,rightFormula);
    }
}
