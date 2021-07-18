package realmatrix;

import io.qala.datagen.RandomShortApi;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;
import static realmatrix.BigDecimalAssert.assertDecimalEquals;

public class DotProductTest {
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
        BigDecimal scalar = BigDecimal.valueOf(RandomShortApi.Double(-1000, 1000));
        assertDecimalEquals(v1.dot(v2).multiply(scalar), v1.times(scalar).dot(v2));
    }
}
