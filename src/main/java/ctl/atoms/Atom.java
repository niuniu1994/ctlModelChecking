package ctl.atoms;

import ctl.Formula;
import lombok.*;

/**
 * @author kainingxin
 */
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Atom implements Formula {

    @NonNull
    private String value;

    public Atom() {
    }

    public Atom(String value) {
        this.value = value;
    }

    public static Atom atom(String value){return  new Atom(value);}


    @Override
    public Formula convert() {
        return this;
    }

}
