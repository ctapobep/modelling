package functions;

import abstractalgebra.reals.Real;
import abstractalgebra.reals.Reals;
import org.junit.Test;

import static abstractalgebra.reals.RealMultiplication.multiply;
import static functions.Asserts.assertClose;
import static org.junit.Assert.*;

public class CosTest {
    @Test
    public void acceptAnyReal_andProducesOnlyValuesWithinRangeOf1AndMinus1() {
        SingleValuedFunction<Real, Real> f = f();
        Set<Real> domain = new Reals();

        Real result = f.apply(domain.random());
        assertTrue(f.domain().contains(result));
        assertTrue(new Reals(-1, 1).contains(result));
    }

    @Test
    public void examples() {
        SingleValuedFunction<Real, Real> f = f();
        assertClose(f.apply(Real.ZERO), Real.ONE);
        assertClose(f.apply(Real.PI), Real.MINUS_ONE);
        assertClose(f.apply(multiply(new Real(2), Real.PI)), Real.ONE);

        assertClose(f.apply(new Real(Math.PI / 2)), Real.ZERO);
        assertClose(f.apply(new Real(Math.PI * 3 / 2)),Real.ZERO);
    }

    private static SingleValuedFunction<Real, Real> f() {
        return Functions.cos();
    }
}