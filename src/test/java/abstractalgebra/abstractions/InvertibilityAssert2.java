package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class InvertibilityAssert2<T, OP extends MonotypicalGroupOp<T>> {
    private final ValueGenerator<T> generator;
    private final OP op;

    public InvertibilityAssert2(OP op, ValueGenerator<T> generator) {
        this.generator = generator;
        this.op = op;
    }

    public void assertHasInverse() {
        T a = generator.generate();
        assertEquals(op.identity(), op.calc(a, op.inverse(a)));
    }
}
