package linearalgebra.functions;

import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealMultiplication;

public class OneOver extends ComparableFunction {
    private final Function f;

    public OneOver(Function f) {
        this.f = f;
    }

    public Real get(Real x) {
        return new RealMultiplication().inverse(f.get(x));
    }
}
