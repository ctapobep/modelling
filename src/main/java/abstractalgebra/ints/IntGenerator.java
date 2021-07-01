package abstractalgebra.ints;

import abstractalgebra.abstractions.ValueGenerator;

import static io.qala.datagen.RandomShortApi.integer;

public class IntGenerator implements ValueGenerator<Int> {
    @Override public Int random() {
        return new Int(integer());
    }
}
