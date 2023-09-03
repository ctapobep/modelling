package functions;

import abstractalgebra.reals.Real;
import org.junit.Test;

import static functions.Asserts.assertClose;

public class SquareTest {
    @Test
    public void check() {
        assertClose(Functions.sqr().apply(new Real(-2)), new Real(4));
    }
}