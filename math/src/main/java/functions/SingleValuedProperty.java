package functions;

import abstractalgebra.reals.Real;

import java.math.BigDecimal;

interface SingleValuedProperty<A, R> {
    void assertValid(SingleValuedFunction<A, R> f);

    SingleValuedProperty<Real, Real> IS_EVEN = f -> {
        Real x = f.domain().random();
        Real minusX = new Real(x.asBigDecimal().multiply(new BigDecimal(-1)));
        f.apply(x).assertIsClose(f.apply(minusX));
    };
    SingleValuedProperty<Real, Real> IS_ODD = f -> {
        Real x = f.domain().random();
        Real minusX = new Real(x.asBigDecimal().multiply(new BigDecimal(-1)));
        Real y = f.apply(x);
        Real minusY = new Real(y.asBigDecimal().multiply(new BigDecimal(-1)));
        minusY.assertIsClose(f.apply(minusX));
    };
}
