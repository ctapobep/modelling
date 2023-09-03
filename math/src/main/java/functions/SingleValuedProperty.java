package functions;

import abstractalgebra.reals.Real;

import static abstractalgebra.reals.RealMultiplication.multiply;
import static functions.Asserts.assertClose;

interface SingleValuedProperty<A, R> {
    void assertValid(SingleValuedFunction<A, R> f);

    SingleValuedProperty<Real, Real> IS_EVEN = f -> {
        Real x = f.domain().random();
        Real minusX = multiply(x, Real.MINUS_ONE);
        assertClose(f.apply(x), f.apply(minusX));
    };
    SingleValuedProperty<Real, Real> IS_ODD = f -> {
        Real x = f.domain().random();
        Real minusX = multiply(x, Real.MINUS_ONE);
        Real y = f.apply(x);
        Real minusY = multiply(y, Real.MINUS_ONE);
        assertClose(minusY, f.apply(minusX));
    };
}
