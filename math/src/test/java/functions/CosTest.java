package functions;

import abstractalgebra.reals.Real;
import abstractalgebra.reals.Reals;
import org.junit.Test;

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
        f.apply(new Real(0)).assertIsClose(Real.ONE);
        f.apply(Real.PI).assertIsClose(new Real(-1));
        f.apply(new Real(2 * Math.PI)).assertIsClose(Real.ONE);

        f.apply(new Real(Math.PI / 2)).assertIsClose(Real.ZERO);
        f.apply(new Real(Math.PI * 3 / 2)).assertIsClose(Real.ZERO);
    }

    private static SingleValuedFunction<Real, Real> f() {
        return new Cos();
    }
}