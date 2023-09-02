package functions;

import abstractalgebra.reals.Real;

import java.math.BigDecimal;
import java.util.List;

import static functions.SingleValuedProperty.IS_EVEN;

public class Cos implements SingleValuedFunction<Real, Real> {
    private static final Sin sin = new Sin();

    public Cos() {
        Asserts.assertHasProperties(this, IS_EVEN);
    }

    public Real apply(Real arg) {
        return sin.apply(new Real(arg.asBigDecimal().add(new BigDecimal(Math.PI/2))));
    }

    public Set<Real> domain() {
        return sin.domain();
    }
    public Set<Real> range() {
        return sin.range();
    }

}
