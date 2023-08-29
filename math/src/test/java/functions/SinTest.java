package functions;

import abstractalgebra.reals.Real;
import abstractalgebra.reals.Reals;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SinTest {
    @Test
    public void acceptAnyReal_andProducesOnlyValuesWithinRangeOf1AndMinus1() {
        Sin sin = new Sin();
        Set<Real> domain = new Reals();

        Real result = sin.apply(domain.random());
        assertTrue(sin.domain().contains(result));
        assertTrue(new Reals(-1, 1).contains(result));
    }

    @Test
    public void examples() {
        Sin sin = new Sin();
        assertTrue(sin.apply(new Real(0)).isClose(Real.ZERO));
        assertTrue(sin.apply(Real.PI).isClose(Real.ZERO));
        assertTrue(sin.apply(new Real(2*Math.PI)).isClose(Real.ZERO));

        assertTrue(sin.apply(new Real(Math.PI/2)).isClose(Real.ONE));
        assertTrue(sin.apply(new Real(Math.PI*3/2)).isClose(new Real(-1)));
    }
}