package abstractalgebra.ints;

import java.math.BigInteger;

public class MinMaxValidator implements ValueValidator<BigInteger> {
    private final BigInteger min, max;

    public MinMaxValidator(int min, int max) {
        this.min = BigInteger.valueOf(min);
        this.max = BigInteger.valueOf(max);
    }

    @Override public void assertValid(BigInteger v) {
        if(v.compareTo(min) < 0 || v.compareTo(max) >0 )
            throw new IllegalArgumentException("Value " + v + " isn't within boundaries: [" + min + "," + max + "]");
    }
}
