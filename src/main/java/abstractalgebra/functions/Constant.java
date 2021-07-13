package abstractalgebra.functions;

import abstractalgebra.reals.Real;

public class Constant extends ComparableFunction {
    public static final Constant ZERO = new Constant(new Real(0)), ONE = new Constant(new Real(1));
    private final Real y;

    public Constant(Real y) {
        this.y = y;
    }

    public Real get(Real x) {
        return y;
    }
}
