package functions;

import abstractalgebra.reals.Real;
import abstractalgebra.reals.Reals;
import org.junit.Test;

import static functions.Asserts.assertClose;
import static org.junit.Assert.assertTrue;

public class SinTest {
    @Test
    public void acceptAnyReal_andProducesOnlyValuesWithinRangeOf1AndMinus1() {
        SingleValuedFunction<Real, Real> sin = f();
        Set<Real> domain = new Reals();

        Real result = sin.apply(domain.random());
        assertTrue(sin.domain().contains(result));
        assertTrue(new Reals(-1, 1).contains(result));
    }

    @Test
    public void examples() {
        SingleValuedFunction<Real, Real> sin = f();
        assertClose(sin.apply(new Real(0)), Real.ZERO);
        assertClose(sin.apply(Real.PI), Real.ZERO);
        assertClose(sin.apply(new Real(2 * Math.PI)), Real.ZERO);

        assertClose(sin.apply(new Real(Math.PI / 2)), Real.ONE);
        assertClose(sin.apply(new Real(Math.PI * 3 / 2)), Real.MINUS_ONE);
    }

    private static SingleValuedFunction<Real, Real> f() {
        return Functions.sin();
    }
}