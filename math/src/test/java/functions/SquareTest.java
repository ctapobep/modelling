package functions;

import abstractalgebra.reals.Real;
import org.junit.Test;

public class SquareTest {
    @Test
    public void check() {
        Functions.sqr().apply(new Real(-2)).assertIsClose(new Real(4));
    }
}