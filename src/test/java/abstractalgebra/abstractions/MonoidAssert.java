package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class MonoidAssert<T, OP extends GroupOp<T>> {
    private final ValueGenerator<T> generator;
    private final OP op;

    public MonoidAssert(OP op, ValueGenerator<T> generator) {
        this.generator = generator;
        this.op = op;
    }

    public void assertIsMonoid() {
        assertIdentityExists();
        assertAssociative();
    }

    private void assertAssociative() {
        T a = generator.generate();
        T b = generator.generate();
        T c = generator.generate();
        assertEquals(op.calc(op.calc(a, b), c), op.calc(a, op.calc(b, c)));
    }
    private void assertIdentityExists() {
        T i = op.identity();
        T a = generator.generate();
        T result = op.calc(i, a);
        assertEquals(a, result);
    }
}
