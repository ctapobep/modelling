package functions;

import abstractalgebra.reals.Real;

import java.math.BigDecimal;

public class Asserts {
    @SafeVarargs
    public static <A, R> void assertHasProperties(SingleValuedFunction<A, R> f, SingleValuedProperty<A, R> ... props) {
        for (SingleValuedProperty<A, R> prop : props)
            prop.assertValid(f);
    }

    public static void assertClose(Real expected, Real actual) {
        BigDecimal e = expected.asBigDecimal();
        BigDecimal a = actual.asBigDecimal();
        if(e.subtract(a).abs().compareTo(new BigDecimal("0.0000000001")) >= 0)
            throw new AssertionError(expected + " isn't close to " + actual);
    }

}
