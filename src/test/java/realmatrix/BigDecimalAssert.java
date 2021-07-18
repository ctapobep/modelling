package realmatrix;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BigDecimalAssert {
    public static void assertDecimalEquals(BigDecimal actual, BigDecimal expected) {
        assertEquals("Values were different, actual: " + actual + ", expected: " + expected,
                0, actual.compareTo(expected));
    }
}
