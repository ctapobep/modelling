package realmatrix;

import org.junit.Test;

import static realmatrix.RealVectorAssert.assertVectorEquals;

public class VectorTest {
    @Test
    public void project() {
        assertVectorEquals(new Vector(1, 0), new Vector(1, 2).projectOn(new Vector(1, 0)));
        assertVectorEquals(new Vector(0, 2), new Vector(1, 2).projectOn(new Vector(0, 1)));
        assertVectorEquals(new Vector(3 * (11./25), 4 * (11./25)), new Vector(1, 2).projectOn(new Vector(3, 4)));
    }
}