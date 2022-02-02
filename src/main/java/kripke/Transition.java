package kripke;

import lombok.*;


/**
 * @author kainingxin
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Transition {
    //start state
    private State start;
    //end state
    private State end;

    public Transition() {
    }

    public Transition(State start, State end) {
        this.start = start;
        this.end = end;
    }
}
