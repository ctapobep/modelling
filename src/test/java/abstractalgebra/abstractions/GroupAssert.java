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
        // monoids are associative and have identity element
        new MonoidAssert<>(op, generator).assertIsMonoid();
        assertHasInverse();
    }

    private void assertHasInverse() {
        T a = generator.generate();
        assertEquals(op.identity(), op.calc(a, op.inverse(a)));
    }
    private void assertCommutative() {
        T a = generator.generate();
        T b = generator.generate();
        assertEquals(op.calc(a, b), op.calc(b, a));
    }
}
