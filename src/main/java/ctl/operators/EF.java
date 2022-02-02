package ctl.operators;

import ctl.Formula;
import lombok.*;

import static ctl.operators.EU.*;
import static ctl.atoms.True.*;
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EF implements Formula {
    @NonNull
    private Formula formula;

    public static EF ef(Formula formula){
        return new EF(formula);
    }

    @Override
    public Formula convert() {
        return eu(True(),formula).convert();
    }

    @Override
    public String toString() {
        return String.format("EF(%s)",formula);
    }
}
