package ctl.operators;

import ctl.Formula;
import static ctl.logicOperators.NOT.*;
import static ctl.operators.EX.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AX implements Formula {
    private Formula formula;

    public static AX ax(Formula formula){
        return new AX(formula);
    }

    @Override
    public Formula convert() {
        return not(ex(not(formula))).convert();
    }

    @Override
    public String toString() {
        return String.format("AX(%s)",formula);
    }
}
