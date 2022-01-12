package atoms;

import formula.Formula;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class False implements Formula {

    private Boolean value = false;



    @Override
    public Formula convert(Formula formula) {
        return this;
    }
}
