package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class MonoidAssert<T, OP extends MonotypicalGroupOp<T>> {
    private final Monoid<T> structure;

    public MonoidAssert(Monoid<T> structure) {
        this.structure = structure;
    }

    public void assertIsMonoid() {
        assertIdentityExists();
        assertAssociative();
    }

    private void assertAssociative() {
        MonoidElement<T> a = structure.random();
        MonoidElement<T> b = structure.random();
        MonoidElement<T> c = structure.random();
        assertEquals(a.add(b.add(c)), a.add(b).add(c));
    }
    private void assertIdentityExists() {
        MonoidElement<T> i = structure.identity();
        MonoidElement<T> a = structure.random();
        MonoidElement<T> result = i.add(a);
        assertEquals(a, result);
    }
}
