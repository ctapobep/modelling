package realmatrix;

import static org.junit.Assert.assertEquals;
import static realmatrix.RealVectorAssert.assertVectorEquals;

public class RealMatrixAssert {
    private static final double DEFAULT_EPSILON = 1e-9;

    public static void assertMatrixEquals(String msg, Matrix expected, Matrix actual) {
        assertMatrixEquals(msg, expected, actual, DEFAULT_EPSILON);
    }
    public static void assertMatrixEquals(Matrix expected, Matrix actual) {
        assertMatrixEquals(expected, actual, 1e-9);
    }
    public static void assertMatrixEquals(Matrix expected, Matrix actual, double e) {
        assertMatrixEquals(null, expected, actual, e);
    }
    public static void assertMatrixEquals(String msg, Matrix expected, Matrix actual, double e) {
        if(e < 0)
            throw new IllegalArgumentException();
        msg = msg == null ? "" : msg + ". ";
        assertEquals(msg + "Dimensions are different!", expected.dims(), actual.dims());
        for (int i = 0; i < expected.width(); i++) {
            msg = msg + "Col #" + i + " are different:\n Expected: " + expected + "\n Actual:   " + actual;
            assertVectorEquals(msg, expected.getRow(i), actual.getRow(i));
        }
    }
}
