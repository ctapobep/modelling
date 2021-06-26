package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class GroupAssert<T, OP extends GroupOp<T>> {
    private final ValueGenerator<T> generator;
    private final OP op;

    public GroupAssert(OP op, ValueGenerator<T> generator) {
        this.generator = generator;
        this.op = op;
    }

    /**
     * aka Commutative Group
     */
    public void assertIsAbelianGroup() {
        assertIsGroup();
        assertCommutative();
    }
    public void assertIsGroup() {
        assertIdentityExists();
        assertAssociative();
        assertHasInverse();
    }

    private void assertHasInverse() {
        T a = generator.generate();
        assertEquals(op.identity(), op.calc(a, op.inverse(a)));
    }

    private void assertAssociative() {
        T a = generator.generate();
        T b = generator.generate();
        T c = generator.generate();
        assertEquals(op.calc(op.calc(a, b), c), op.calc(a, op.calc(b, c)));
    }
    private void assertCommutative() {
        T a = generator.generate();
        T b = generator.generate();
        assertEquals(op.calc(a, b), op.calc(b, a));
    }
    private void assertIdentityExists() {
        T i = op.identity();
        T a = generator.generate();
        T result = op.calc(i, a);
        assertEquals(a, result);
    }
}
