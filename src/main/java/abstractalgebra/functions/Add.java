package abstractalgebra.functions;

import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealAddition;

public class Add extends ComparableFunction {
    private final Function right, left;

    public Add(Function right, Function left) {
        this.right = right;
        this.left = left;
    }

    public Real get(Real x) {
        return new RealAddition().calc(left.get(x), right.get(x));
    }
}
