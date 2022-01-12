package atoms;
import formula.Formula;
import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Atom implements Formula {

    private String value;

    public static Atom atom(String value){return  new Atom(value);}

    @Override
    public Formula convert(Formula formula) {
        return this;
    }
}
