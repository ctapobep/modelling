package linearalgebra.abstractions;

import abstractalgebra.reals.Real;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {
    @Test public void symmetricMatricesAreTransposesOfThemselves() {
        Matrix<Real> m = Matrix.rows(new double[][]{{1}});
        assertEquals(m, m.t());

        m = Matrix.rows(new double[][]{
                {1 , -2},
                {-2,  1}}
        );
        assertEquals(m, m.t());
    }
}