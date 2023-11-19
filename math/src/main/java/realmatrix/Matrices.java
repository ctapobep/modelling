package realmatrix;

import java.math.BigDecimal;

import static ch.obermuhlner.math.big.DefaultBigDecimalMath.cos;
import static ch.obermuhlner.math.big.DefaultBigDecimalMath.sin;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static common.Constants.MINUS_ONE;

public class Matrices {

    public static Matrix rotation(double rad) {
        BigDecimal radians = BigDecimal.valueOf(rad);
        return Matrix.fromRows(
                new Vector(new BigDecimal[]{cos(radians), sin(radians).multiply(MINUS_ONE)}),
                new Vector(new BigDecimal[]{sin(radians), cos(radians)})
        );
    }

    public static Matrix rotationX(double rad) {
        BigDecimal cos = cos(new BigDecimal(rad));
        BigDecimal sin = sin(new BigDecimal(rad));
        return Matrix.fromRows(
                new Vector(new BigDecimal[]{ONE, ZERO, ZERO}),
                new Vector(new BigDecimal[]{ZERO, cos, sin.multiply(MINUS_ONE)}),
                new Vector(new BigDecimal[]{ZERO, sin, cos})
        );
    }
    public static Matrix rotationY(double rad) {
        BigDecimal cos = cos(new BigDecimal(rad));
        BigDecimal sin = sin(new BigDecimal(rad));
        return Matrix.fromRows(
                new Vector(new BigDecimal[]{cos, ZERO, sin.multiply(MINUS_ONE)}),
                new Vector(new BigDecimal[]{ZERO, ONE, ZERO}),
                new Vector(new BigDecimal[]{sin, ZERO, cos})
        );
    }
    public static Matrix rotationZ(double rad) {
        BigDecimal cos = cos(new BigDecimal(rad));
        BigDecimal sin = sin(new BigDecimal(rad));
        return Matrix.fromRows(
                new Vector(new BigDecimal[]{cos, sin.multiply(MINUS_ONE), ZERO}),
                new Vector(new BigDecimal[]{sin, cos, ZERO}),
                new Vector(new BigDecimal[]{ZERO, ZERO, ONE})
        );
    }

    /**
     * First rotates around x, then around y and then around z.
     */
    public static Matrix rotation3d(double x, double y, double z) {
        return Matrix.times(rotationZ(z), rotationY(y), rotationX(x));
    }
}
