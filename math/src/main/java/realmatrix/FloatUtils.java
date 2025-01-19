package realmatrix;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.math.MathContext.DECIMAL128;

class FloatUtils {


    BigDecimal round(BigDecimal d, int posAfterDecimal) {
        long multiplier = BigInteger.TEN.pow(posAfterDecimal).longValueExact();
        return d.multiply(BigDecimal.valueOf(multiplier)).round(DECIMAL128).divide(BigDecimal.valueOf(multiplier), DECIMAL128);
    }
}
