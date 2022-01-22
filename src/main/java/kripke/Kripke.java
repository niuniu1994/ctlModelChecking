package kripke;

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
    private List<Set<String>> combinations;


    public Kripke() {
        this.states = new HashSet<>();
        this.initStates = new HashSet<>();
        this.transitions = new HashSet<>();
        this.vals = new HashSet<>();
        this.combinations = new ArrayList<>();
    }

    public Kripke(Set<String> vals, Set<State> states, Set<State> initStates, Set<Transition> transitions) {
        this.vals = vals;
        this.states = states;
        this.initStates = initStates;
        this.transitions = transitions;
        this.combinations = new ArrayList<>();
        initCombinations();
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

    public void initCombinations() {
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
