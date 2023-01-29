package abstractalgebra.ints;

import java.math.BigInteger;

public class NonZeroValidator implements ValueValidator<BigInteger> {
    @Override public void assertValid(BigInteger integer) {
        if(BigInteger.ZERO.equals(integer))
            throw new IllegalArgumentException("Can't be 0!");
    }
}
