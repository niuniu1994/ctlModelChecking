package kripke;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import ctl.atoms.Atom;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
//@JsonDeserialize(using = StateCustomDeserializer.class)
public class State {
    private String name;
    private boolean isInit = false;
    // the value set of atom stocked in state has only one character
    private List<Atom> atoms = new ArrayList<>();

    public State() {
    }

    public State(String name, boolean isInit, List<String> atoms) {
        this.name = name;
        this.isInit = isInit;
        this.atoms = atoms.stream().map(Atom::new).collect(Collectors.toList());
    }

    public State(String name, List<String> atoms) {
        this.name = name;
        this.atoms = atoms.stream().map(atom -> new Atom(atom)).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return isInit == state.isInit && Objects.equal(name, state.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, isInit);
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", isInit=" + isInit +
                ", atoms=" + atoms +
                '}';
    }
}
