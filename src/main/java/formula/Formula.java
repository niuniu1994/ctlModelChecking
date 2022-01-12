package formula;

/**
 * @author kainingxin
 */
public interface Formula {

    /**
     * Convert a CTL formula into another
     * Because all operators (AF,AG,AU,AX,EF,EG,EF,EU,EX) can be expressed in terms of EX, EG, and EU
     * So in order to simplify the application all the CTL formula inputted
     * will be transformed to CTL formula with only EX, EG, and EU as operators
     * @param formula
     * @return
     */
    Formula convert(Formula formula);
}
