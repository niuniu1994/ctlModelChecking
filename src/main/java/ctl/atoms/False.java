package ctl.atoms;

import ctl.Formula;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
public class False implements Formula,CalculableFormula {

    public static False False(){
        return new False();
    }

    @Override
    public Formula convert() {
        return this;
    }

    @Override
    public String toString() {
        return "False";
    }
}
