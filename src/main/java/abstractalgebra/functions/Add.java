package abstractalgebra.functions;

import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealAddition;

public class Add implements Function<Real> {
    private final Function<Real> right, left;

    public Add(Function<Real> right, Function<Real> left) {
        this.right = right;
        this.left = left;
    }

    public Real get(Real x) {
        return new RealAddition().calc(left.get(x), right.get(x));
    }
}
