package ctl.operators;

import ctl.Formula;
import static ctl.logicOperators.NOT.*;
import static ctl.operators.AF.*;
import lombok.*;

/**
 * @author kainingxin
 */
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EG implements Formula {
    @NonNull
    private Formula formula;
    public static EG eg(Formula formula){
        return new EG(formula);
    }

    @Override
    public Formula convert() {
        return not(af(not(formula))).convert();
    }

    @Override
    public String toString() {
        return String.format("EG(%s)",formula);
    }
}
