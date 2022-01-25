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
    private State start;
    private State end;

    public Transition() {
    }

    public Transition(State start, State end) {
        this.start = start;
        this.end = end;
    }
}
