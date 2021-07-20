package realmatrix;

import java.math.BigDecimal;
import java.math.MathContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BigDecimalAssert {
    public static void assertDecimalEqualsPrecisely(BigDecimal expected, BigDecimal actual) {
        assertTrue("Values were different, actual: " + actual + ", expected: " + expected,
                isEqualsPrecisely(actual, expected));
    }

    public static void assertDecimalEquals(BigDecimal expected, BigDecimal actual) {
        assertTrue("Values were different, actual: " + actual + ", expected: " + expected,
                isEquals(expected, actual));
    }

    public static boolean isEquals(BigDecimal expected, BigDecimal actual) {
        return actual.subtract(expected).abs().doubleValue() < 1e-10;
    }
    public static boolean isEqualsPrecisely(BigDecimal expected, BigDecimal actual) {
        return actual.compareTo(expected) == 0;
    }
}
