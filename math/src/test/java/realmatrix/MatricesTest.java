package realmatrix;

import io.qala.datagen.RandomShortApi;
import org.junit.Test;

import static common.Constants.DEG120;
import static common.Constants.DEG45;
import static io.qala.datagen.RandomShortApi.Double;
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static realmatrix.Matrices.*;
import static realmatrix.Matrix.times;
import static realmatrix.RealVectorAssert.assertVectorEquals;

public class MatricesTest {
    @Test
    public void rotatingAroundX_doesNotChangeX() {
        Vector rotated = rotationX(PI).times(new Vector(2, 3, 4));
        assertVectorEquals(new Vector(2, -3, -4), rotated);
    }
    @Test
    public void rotatingAroundY_doesNotChangeY() {
        Vector rotated = Matrices.rotationY(PI).times(new Vector(-1, 3, 2));
        assertVectorEquals(new Vector(1, 3, -2), rotated);
    }
    @Test
    public void rotatingAroundZ_doesNotChangeZ() {
        Vector rotated = rotationZ(PI).times(new Vector(-1, 3, 2));
        assertVectorEquals(new Vector(1, -3, 2), rotated);
    }
    @Test
    public void rotating3d_0_or360_isIdempotent() {
        Vector v = new Vector(1, 2, 4);
        Vector rotated = rotation3d(0, 2*PI, 4*PI).times(v);
        assertVectorEquals(v, rotated);
    }
    @Test
    public void rotating3d_rotatesAroundX_thenY_thenZ() {
        Vector rotated = rotation3d(PI, PI / 2, PI/4).times(new Vector(1, 2, 4));
        assertVectorEquals(new Vector(4.242641, 1.414214, 1), rotated, 1e-6);
    }
    @Test
    public void exampleRotation() {
        double xAngle = DEG45;
        double zAngle = Math.acos(1./sqrt(3));
        Matrix r = times(
                rotationX(xAngle), rotationZ(zAngle), // finally, cancel the original rotation
                rotationX(DEG120), // then the main rotation
                rotationZ(-zAngle), rotationX(-xAngle) // first, aligning with X axis
        );

        Vector eigen = new Vector(1,1,1).times(Double(-10, 10));
        assertVectorEquals("Eigen vector must've stayed where it was", eigen, r.times(eigen));
        System.out.println(eigen);
        System.out.println(r);
    }
}