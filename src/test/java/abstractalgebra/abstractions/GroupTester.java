package abstractalgebra.abstractions;

import abstractalgebra.abstractions.Op;
import abstractalgebra.abstractions.ValueGenerator;

import static org.junit.Assert.assertEquals;

public class GroupTester<T, OP extends Op<T>> {
    private final ValueGenerator<T> generator;
    private final OP op;

    public GroupTester(OP op, ValueGenerator<T> generator) {
        this.generator = generator;
        this.op = op;
    }

    public void assertIsGroup() {
        assertIdentityExists();
        assertCommutative();
        assertAssociative();
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
