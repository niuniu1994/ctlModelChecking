package atoms;

import formula.Formula;

public class True implements Formula{
    private Boolean value = false;

    @Override
    public Formula convert(Formula formula) {
        return this;
    }
}
