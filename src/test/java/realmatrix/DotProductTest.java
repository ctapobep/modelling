package realmatrix;

import org.junit.Test;

import java.math.BigDecimal;

import static io.qala.datagen.RandomShortApi.Double;
import static org.junit.Assert.assertTrue;
import static realmatrix.BigDecimalAssert.assertDecimalEquals;
import static realmatrix.BigDecimalAssert.isEquals;

public class DotProductTest {
    @Test public void sumOfVectorsOfSameLength_isPerpendicularToDifference() {
        Vector a = Vector.random(2);
        Vector rotated = Matrices.rotation(Double(-1, 1)).times(a);
        Vector sum = a.add(rotated);
        Vector difference = a.add(rotated.times(-1));
        assertDecimalEquals(BigDecimal.ZERO, sum.dot(difference));
    }
    @Test public void triangleInequality() {
        Vector a = Vector.random(),
               b = Vector.random(a.dims());
        assertTrue(// ‖a + b‖ ≤ ‖a‖ + ‖b‖
                a.add(b).norm().compareTo(
                        a.norm().add(b.norm())) < 1);
    }
    @Test public void schwarzInequality() {
        Vector a = Vector.random(),
               b = Vector.random(a.dims());
        BigDecimal ab = a.dot(b).abs();
        BigDecimal abnorms = a.norm().multiply(b.norm());
        assertTrue(// |a · b| ≤ ‖a‖ ‖b‖
                ab.compareTo(abnorms) < 0 || isEquals(ab, abnorms));
    }
    @Test public void unitVectorHasLengthOf1() {
        Vector v = Vector.randomNonZero();
        assertTrue(BigDecimal.ONE.subtract(v.toUnitVector().norm()).abs().doubleValue() < 1e-30);
        assertDecimalEquals(BigDecimal.ONE, v.toUnitVector().norm());
    }

    @Test public void normIsPositiveDefiniteForNonZeroVectors() {
        Vector v = Vector.random();
        if(v.isZero())
            assertDecimalEquals(BigDecimal.ZERO, v.norm());
        else
            assertTrue(v.norm().compareTo(BigDecimal.ZERO) > 0);
    }
    @Test public void zeroVectorTimesAnythingIsZeroVector() {
        Vector v = Vector.random();
        Vector zero = Vector.repeat(BigDecimal.ZERO, v.dims());
        assertDecimalEquals(BigDecimal.ZERO, v.dot(zero));
        assertDecimalEquals(BigDecimal.ZERO, zero.dot(v));
        assertDecimalEquals(BigDecimal.ZERO, zero.dot(zero));
    }
    @Test public void firstArgumentAdditionIsLinear() {
        Vector v1 = Vector.random(),
               v2 = Vector.random(v1.dims()),
               v3 = Vector.random(v1.dims()),
               v1PlusV2 = v1.add(v2);
        assertDecimalEquals(v1PlusV2.dot(v3), v1.dot(v3).add(v2.dot(v3)));
    }
    @Test public void firstArgumentScalingIsLinear() {
        Vector v1 = Vector.random(),
               v2 = Vector.random(v1.dims());
        BigDecimal scalar = BigDecimal.valueOf(Double(-1000, 1000));
        assertDecimalEquals(v1.dot(v2).multiply(scalar), v1.times(scalar).dot(v2));
    }
}
