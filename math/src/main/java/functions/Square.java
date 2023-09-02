package functions;

import abstractalgebra.reals.Real;
import abstractalgebra.reals.Reals;

public class Square implements SingleValuedFunction<Real, Real> {
    private static final Set<Real> DOMAIN = new Reals(), RANGE = Reals.NON_NEGATIVE;

    public Square() {
        Asserts.assertHasProperties(this, SingleValuedProperty.IS_EVEN);
    }

    public Real apply(Real arg) {
        return new Real(arg.asBigDecimal().pow(2));
    }

    public Set<Real> domain() {
        return DOMAIN;
    }
    public Set<Real> range() {
        return RANGE;
    }
}
