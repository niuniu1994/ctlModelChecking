package kripke;


import ctl.atoms.Atom;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class State {
    //the name of the state
    private String name;
    // the value set of atom stocked in state has only one character
    private List<Atom> atoms = new ArrayList<>();

    public State() {
    }

    public State(String name, List<String> atoms) {
        this.name = name;
        this.atoms = atoms.stream().map(Atom::new).collect(Collectors.toList());
    }

}
