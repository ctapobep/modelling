package abstractalgebra.ints;

import abstractalgebra.abstractions.CommutativeGroup;
import abstractalgebra.abstractions.Field;

import java.math.BigInteger;

import static io.qala.datagen.RandomShortApi.integer;

@SuppressWarnings("UnusedReturnValue")
public class Ints {
    public static CommutativeGroup<Int> additiveGroup() {
        return new CommutativeGroup<>(new IntAddition(new AllIntsValidator()), IntGenerator.allInts());
    }
    public static CommutativeGroup<Int> finiteAdditiveGroup() {
        return finiteAdditiveGroup(integer(2, Integer.MAX_VALUE));
    }
    public static CommutativeGroup<Int> finiteAdditiveGroup(int module) {
        AllIntsValidator validator = new AllIntsValidator();
        return new CommutativeGroup<>(
                new ModAddition(module, validator),
                IntGenerator.nonnegativeInts(module));
    }

    public static CommutativeGroup<Int> finiteMultiplicativeGroup() {
        return finiteMultiplicativeGroup(IntGenerator.primeInts().random().asInt());
    }
    public static CommutativeGroup<Int> finiteMultiplicativeGroup(int module) {
        ValueValidator<BigInteger> validator = new NonZeroValidator();
        return new CommutativeGroup<>(
                new ModMultiplication(module, validator),
                IntGenerator.positiveInts(module));
    }
    public static Field<Int> finiteField() {
        int module = IntGenerator.primeInts().random().asInt();
        AllIntsValidator allInts = new AllIntsValidator();
        return new Field<>(
                new ModAddition(module, allInts),
                new ModMultiplication(module, allInts),
                IntGenerator.nonnegativeInts(module)
        );
    }
}
