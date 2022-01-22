package ctl.logicOperators;

import ctl.Formula;
import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class NOT implements Formula {
    private Formula formula;

    public static NOT not(Formula formula){
        return new NOT(formula);
    }

    @Override
    public Formula convert() {
        return not(formula.convert());
    }

    @Override
    public String toString() {
        return "NOT(" + formula +')';
    }
}
