package functions;

import abstractalgebra.reals.Real;
import abstractalgebra.reals.Reals;

import static functions.SingleValuedProperty.IS_ODD;

public class Sin implements SingleValuedFunction<Real, Real> {
    private static final Set<Real> DOMAIN = new Reals();
    private static final Set<Real> RANGE = new Reals(new Real(-1), Real.ONE);

    public Sin() {
        Asserts.assertHasProperties(this, IS_ODD);
    }

    public Real apply(Real arg) {
        return new Real(Math.sin(arg.asDouble()));
    }

    public Set<Real> domain() {
        return DOMAIN;
    }
    public Set<Real> range() {
        return RANGE;
    }
}
