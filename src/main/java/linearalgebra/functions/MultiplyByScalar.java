package linearalgebra.functions;

import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealMultiplication;

public class MultiplyByScalar extends ComparableFunction {
    private final Real scalar;
    private final Function f;

    public MultiplyByScalar(Real scalar, Function f) {
        this.scalar = scalar;
        this.f = f;
    }

    public Real get(Real x) {
        return new RealMultiplication().calc(f.get(x), scalar);
    }
}
