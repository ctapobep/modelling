package abstractalgebra.ints;

import abstractalgebra.abstractions.CommutativeGroup;

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
        return finiteMultiplicativeGroup(IntGenerator.primeInts().random().val());
    }
    public static CommutativeGroup<Int> finiteMultiplicativeGroup(int module) {
        ValueValidator<Integer> validator = new NonZeroValidator();
        return new CommutativeGroup<>(
                new ModMultiplication(module, validator),
                IntGenerator.positiveInts(module));
    }
}
