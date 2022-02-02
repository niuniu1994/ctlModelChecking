package ctl.atoms;

import ctl.Formula;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class True implements Formula{

    public static True True(){
        return new True();
    }

    @Override
    public Formula convert() {
        return this;
    }

    @Override
    public String toString(){
        return "True";
    }
}
