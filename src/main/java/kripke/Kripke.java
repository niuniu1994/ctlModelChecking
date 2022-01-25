package kripke;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


@Setter
@Getter
@EqualsAndHashCode
public class Kripke {

    private Set<String> vals;
    private Set<State> states;
    private Set<State> initStates;
    private Set<Transition> transitions;
    @JsonIgnore
    private List<Set<String>> combinations;


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

    public static Kripke readFromFile(String path){
        return new Kripke();
    }


    public List<Set<String>> getCombinations() {
        if (combinations == null){
            initCombinations();
        }
        return combinations;
    }

    public void initCombinations() {
        if (combinations == null){
            combinations = new ArrayList<>();
        }

       int len = vals.size();
       if (len == 0) {
           return;
       }
       Deque<String> stack = new ArrayDeque<>();
       dfs(this.vals.toArray(new String[vals.size()]),len,0,stack);
    }

    private void dfs(String[] vals , int len, int level, Deque<String> stack){
        if (level == len){
            if (!stack.isEmpty()){
                combinations.add(new HashSet<>(stack));
            }
            return;
        }

        dfs(vals,len,level + 1,stack);

        stack.addLast(vals[level]);
        dfs(vals,len,level + 1, stack);
        stack.removeLast();
    }
}
