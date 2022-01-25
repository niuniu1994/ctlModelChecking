package ctl.atoms;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;
import com.google.common.collect.Sets;
import ctl.Formula;
import kripke.AtomCustomDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author kainingxin
 */
@Getter
@Setter
@JsonDeserialize(using = AtomCustomDeserializer.class)
public class Atom implements Formula,CalculableFormula {



    /**
     * At very first the atom can only have one str as the value
     * when And(atom1, atom2), we merge the value of two atom in the valueSet
     * when Not(atom1)  we put all items in vals that are not exist in valueSet of kripke in valueSet and remove the old items
     */
    @JsonProperty("valueSet")
    private Set<String> valueSet;

    /**
     * At very first the atom can only have one str as the value
     * when Or(atom1, atom2), we add atom2 in the atomList
     */
    @JsonIgnore
    private List<Atom> atomList = new ArrayList<>();

    public Atom() {
    }

    public Atom(String value) {
        this.valueSet = Set.of(value);
        this.atomList.add(this);
    }


    public Atom(String... value) {
        this.valueSet = Sets.newHashSet(value);
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

    public Atom(List<String> valueSet) {
        this.valueSet = new HashSet<>(valueSet);
        this.atomList.add(this);
    }


    public static Atom atom(String... value){return  new Atom(value);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atom atom = (Atom) o;
        return atom.toString().equals(this.toString());
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
