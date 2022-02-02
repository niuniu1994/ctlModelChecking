package kripke;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@EqualsAndHashCode
public class Kripke {
    // Kripke = (S, I, R, L)
    //values of atomic proposition
    private Set<String> vals;
    //a finite set of states S.
    private Set<State> states;
    //a set of initial states I ⊆ S.
    private Set<State> initStates;
    //a transition relation R ⊆ S × S such that R is left-total
    private Set<Transition> transitions;

    public Kripke() {
        this.states = new HashSet<>();
        this.initStates = new HashSet<>();
        this.transitions = new HashSet<>();
        this.vals = new HashSet<>();

    }

    public Kripke(Set<String> vals, Set<State> states, Set<State> initStates, Set<Transition> transitions) {
        this.vals = vals;
        this.states = states;
        this.initStates = initStates;
        this.transitions = transitions;
    }

    public void addTransition(State start, State end){
        this.transitions.add(new Transition(start,end));
    }

    public void addState(State state){
        this.states.add(state);
    }

    public void addInitState(State state){
        this.initStates.add(state);
        this.states.add(state);
    }

}
