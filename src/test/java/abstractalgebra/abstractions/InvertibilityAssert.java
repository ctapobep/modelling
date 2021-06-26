package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class InvertibilityAssert<T, OP extends GroupOp<T>> {
    private final ValueGenerator<T> generator;
    private final OP op;

    public InvertibilityAssert(OP op, ValueGenerator<T> generator) {
        this.generator = generator;
        this.op = op;
    }

    public void assertHasInverse() {
        T a = generator.generate();
        assertEquals(op.identity(), op.calc(a, op.inverse(a)));
    }
}
