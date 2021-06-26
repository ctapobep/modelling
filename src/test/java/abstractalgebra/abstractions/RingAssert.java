package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class RingAssert<T, ADDITION extends GroupOp<T>, MULTIPLICATION extends GroupOp<T>> {
    private final ValueGenerator<T> generator;
    private final ADDITION addition;
    private final MULTIPLICATION multiplication;

    public RingAssert(ADDITION addition, MULTIPLICATION multiplication, ValueGenerator<T> generator) {
        this.generator = generator;
        this.addition = addition;
        this.multiplication = multiplication;
    }
    public void assertIsRing() {
        additionIsAbelianGroup();
        multiplicationIsMonoid();
        multiplicationIsDistributive();
    }
    private void multiplicationIsDistributive() {
        T a = generator.generate(),
          b = generator.generate(),
          c = generator.generate();
        assertEquals(
                multiplication.calc(a, addition.calc(b, c)),
                addition.calc(multiplication.calc(a, b),  multiplication.calc(a, c)));
    }
    private void multiplicationIsMonoid() {
        new MonoidAssert<>(multiplication, generator).assertIsMonoid();
    }
    private void additionIsAbelianGroup() {
        new GroupAssert<>(addition, generator).assertIsAbelianGroup();
    }
}
