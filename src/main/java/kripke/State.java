package kripke;

import ctl.atoms.Atom;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kainingxin
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class State {
    private String name;
    private boolean isInit = false;
    private List<Atom> atoms = new ArrayList<>();

    public State(String name, boolean isInit, List<String> atoms) {
        this.name = name;
        this.isInit = isInit;
        this.atoms = atoms.stream().map(Atom::new).collect(Collectors.toList());
    }

    public State(String name, List<String> atoms) {
        this.name = name;
        this.atoms = atoms.stream().map(Atom::new).collect(Collectors.toList());
    }

    public State() {
    }
}
