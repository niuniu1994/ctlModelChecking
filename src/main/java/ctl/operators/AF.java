package ctl.operators;

import ctl.Formula;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AF implements Formula {
    private Formula formula;

    public static AF af(Formula formula){return new AF(formula);}


    @Override
    public Formula convert() {
        return af(formula.convert());
    }

    @Override
    public String toString() {
        return String.format("AF(%s)",formula);
    }
}
