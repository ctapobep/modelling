package realmatrix;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RealVectorAssert {
    private static final double DEFAULT_EPSILON = 1e-9;

    public static void assertVectorEquals(String msg, Vector expected, Vector actual) {
        assertVectorEquals(msg, expected, actual, DEFAULT_EPSILON);
    }
    public static void assertVectorEquals(Vector expected, Vector actual) {
        assertVectorEquals(expected, actual, 1e-9);
    }
    public static void assertVectorEquals(Vector expected, Vector actual, double e) {
        assertVectorEquals(null, expected, actual, e);
    }
    public static void assertVectorEquals(String msg, Vector expected, Vector actual, double e) {
        if(e < 0)
            throw new IllegalArgumentException();
        msg = msg == null ? "" : msg + ". ";
        assertEquals(msg + "Dimensions are different!", expected.dims(), actual.dims());
        for (int i = 0; i < expected.dims(); i++)
            assertTrue(
                    msg + "Values differ in " + i + " component:\n Expected: " + expected + "\n Actual: " + actual,
                    expected.get(i)
                            .subtract(actual.get(i))
                            .abs()
                            .compareTo(new BigDecimal(e)) < 0
            );
    }
}
