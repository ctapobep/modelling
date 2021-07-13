package abstractalgebra.functions;

import abstractalgebra.abstractions.MonotypicalGroupOp;
import abstractalgebra.reals.Real;

public class FunctionAddition implements MonotypicalGroupOp<Function<Real>> {
    public Function<Real> calc(Function<Real> o1, Function<Real> o2) {
        return new Add(o1, o2);
    }
    public Function<Real> identity() {
        return Zero.INSTANCE;
    }
    public Function<Real> inverse(Function<Real> a) {
        return new TimesMinusOne(a);
    }
}
