package ctl.atoms;
import com.google.common.base.Objects;
import ctl.Formula;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;


@Getter
@Setter
public class Atom implements Formula,CalculableFormula {



    /**
     * At very first the atom can only have one str as the value
     * when And(atom1, atom2), we merge the value of two atom in the valueSet
     * when Not(atom1)  we put all items in vals that are not exist in valueSet of kripke in valueSet and remove the old items
     */

    private Set<String> valueSet = new HashSet<>();

    /**
     * At very first the atom can only have one str as the value
     * when Or(atom1, atom2), we add atom2 in the atomList
     */
    private List<Atom> atomList = new ArrayList<>();


    public Atom(String... value) {
        this.valueSet.addAll(Arrays.stream(value).collect(Collectors.toList()));
        this.atomList.add(this);
    }

    public Atom(Set<String> valueSet, List<Atom> atomList) {
        this.valueSet = valueSet;
        this.atomList = atomList;
    }

    public Atom(Set<String> valueSet) {
        this.valueSet = valueSet;
        this.atomList.add(this);
    }

    public static Atom atom(String... value){return  new Atom(value);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atom atom = (Atom) o;
        return Objects.equal(valueSet, atom.valueSet)
                && Objects.equal(atomList.remove(this), atom.atomList.remove(this));
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valueSet);
    }

    @Override
    public Formula convert() {
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        atomList.forEach(atom -> {
            stringBuilder.append(" {");
            atom.getValueSet().forEach(val -> stringBuilder.append(String.format("%s,",val)));
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            stringBuilder.append("}");
        });
        return stringBuilder.toString();
    }
}
