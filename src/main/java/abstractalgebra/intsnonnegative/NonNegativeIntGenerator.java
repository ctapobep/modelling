package abstractalgebra.intsnonnegative;

import abstractalgebra.abstractions.ValueGenerator;

import static io.qala.datagen.RandomShortApi.integer;

public class NonNegativeIntGenerator implements ValueGenerator<NonNegativeInt> {
    private final NonNegativeInt module;

    public NonNegativeIntGenerator() {
        this(integer(2, 100));
    }
    public NonNegativeIntGenerator(int maxExclusive) {
        this.module = new NonNegativeInt(maxExclusive);
    }

    public NonNegativeInt random() {
        return new NonNegativeInt(integer(0, module.val()-1));
    }
    public NonNegativeInt getModule() {
        return module;
    }
}
