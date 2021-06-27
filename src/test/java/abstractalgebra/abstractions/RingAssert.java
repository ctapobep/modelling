package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class RingAssert<T> {
    private final ValueGenerator<T> generator;
    private final Ring<T> ring;

    public RingAssert(Ring<T> ring, ValueGenerator<T> generator) {
        this.generator = generator;
        this.ring = ring;
    }
    public void assertIsRing() {
        additionIsAbelianGroup();
        multiplicationIsMonoid();
        multiplicationIsLeftDistributive();
        multiplicationIsRightDistributive();
    }
    private void multiplicationIsLeftDistributive() {
        RingMember<T> a = ring.create(generator.generate()),
                      b = ring.create(generator.generate()),
                      c = ring.create(generator.generate());
        assertEquals(
                a.multiply(b.add(c)),
                a.multiply(b).add(a.multiply(c)));
    }
    private void multiplicationIsRightDistributive() {
        RingMember<T> a = ring.create(generator.generate()),
                      b = ring.create(generator.generate()),
                      c = ring.create(generator.generate());
        assertEquals(
                b.add(c).multiply(a),
                b.multiply(a).add(c.multiply(a)));
    }
    private void multiplicationIsMonoid() {
        new MonoidAssert2<>(ring.toMultiplicativeMonoid(), generator).assertIsMonoid();
    }
    private void additionIsAbelianGroup() {
        new GroupAssert2<>(ring.toAdditiveGroup(), generator).assertIsAbelianGroup();
    }
}
