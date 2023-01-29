package realmatrix;

import ch.obermuhlner.math.big.DefaultBigDecimalMath;

import java.math.BigDecimal;

public class Matrices {
    public static Matrix rotation(double rad) {
        BigDecimal radians = BigDecimal.valueOf(rad);
        return Matrix.fromRows(
                new Vector(new BigDecimal[]{DefaultBigDecimalMath.cos(radians),DefaultBigDecimalMath.sin(radians).multiply(BigDecimal.valueOf(-1))}),
                new Vector(new BigDecimal[]{DefaultBigDecimalMath.sin(radians), DefaultBigDecimalMath.cos(radians)})
        );
    }
}
