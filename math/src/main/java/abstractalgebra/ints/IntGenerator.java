package abstractalgebra.ints;

import abstractalgebra.abstractions.ValueGenerator;

import java.math.BigInteger;

import static io.qala.datagen.RandomShortApi.integer;
import static io.qala.datagen.RandomShortApi.sample;

public class IntGenerator {
    public static ValueGenerator<Int> allInts() {
        return () -> new Int(BigInteger.valueOf(integer()), new MinMaxValidator(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
    public static ValueGenerator<Int> nonnegativeInts(int maxExclusive) {
        return () -> new Int(BigInteger.valueOf(integer(maxExclusive-1)), new MinMaxValidator(0, maxExclusive - 1));
    }
    public static ValueGenerator<Int> positiveInts(int maxExclusive) {
        return () -> new Int(BigInteger.valueOf(integer(1, maxExclusive-1)), new NonZeroValidator());
    }
    public static ValueGenerator<Int> primeInts() {
        return () -> new Int(BigInteger.valueOf(sample(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 43, 113)), new NonZeroValidator());
    }
}
