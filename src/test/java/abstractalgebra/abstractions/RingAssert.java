package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class RingAssert<T> {
    private final Ring<T> ring;

    public RingAssert(Ring<T> ring) {
        this.ring = ring;
    }
    public void assertIsRing() {
        additionIsAbelianGroup();
        multiplicationIsMonoid();
        multiplicationIsLeftDistributive();
        multiplicationIsRightDistributive();
    }
    private void multiplicationIsLeftDistributive() {
        RingElement<T> a = ring.random(),
                      b = ring.random(),
                      c = ring.random();
        assertEquals(
                a.multiply(b.add(c)),
                a.multiply(b).add(a.multiply(c)));
    }
    private void multiplicationIsRightDistributive() {
        RingElement<T> a = ring.random(),
                      b = ring.random(),
                      c = ring.random();
        assertEquals(
                b.add(c).multiply(a),
                b.multiply(a).add(c.multiply(a)));
    }
    private void multiplicationIsMonoid() {
        new MonoidAssert<>(ring.toMultiplicativeMonoid()).assertIsMonoid();
    }
    private void additionIsAbelianGroup() {
        new GroupAssert<>(ring.toAdditiveGroup()).assertIsAbelianGroup();
    }
}
