package ctl.operators;

import ctl.Formula;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class EX implements Formula {
    private Formula formula;

    public static EX ex(Formula formula){
        return new EX(formula);
    }

    @Override
    public Formula convert() {
        return ex(formula.convert());
    }

    @Override
    public String toString() {
        return String.format("EX(%s)",formula);
    }


}
