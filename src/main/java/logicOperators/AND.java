package logicOperators;

import formula.Formula;

/**
 * @author kainingxin
 */
public class AND implements Formula {
    private Formula left;
    private Formula right;

    public AND(Formula left, Formula right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Formula convert(Formula formula) {
        return null;
    }
}
