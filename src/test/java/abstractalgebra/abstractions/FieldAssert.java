package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class FieldAssert<T, ADDITION extends MonotypicalGroupOp<T>, MULTIPLICATION extends MonotypicalGroupOp<T>> {
    private final ValueGenerator<T> generator;
    private final ADDITION addition;
    private final MULTIPLICATION multiplication;

    public FieldAssert(ADDITION addition, MULTIPLICATION multiplication, ValueGenerator<T> generator) {
        this.generator = generator;
        this.addition = addition;
        this.multiplication = multiplication;
    }
    public void assertIsField() {
        new RingAssert<>(addition, multiplication, generator).assertIsRing();
        new InvertibilityAssert<>(multiplication, generator).assertHasInverse();
    }
}
