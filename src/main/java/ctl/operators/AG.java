package ctl.operators;

import ctl.Formula;
import lombok.*;
import static ctl.logicOperators.NOT.*;
import static ctl.operators.EF.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AG implements Formula{
    @NonNull
    private Formula formula;

    public static AG ag (Formula formula){
        return new AG(formula);
    }

    @Override
    public Formula convert() {
        return not(ef(not(formula))).convert();
    }

    @Override
    public String toString() {
        return String.format("AG(%s)",formula);
    }
}
