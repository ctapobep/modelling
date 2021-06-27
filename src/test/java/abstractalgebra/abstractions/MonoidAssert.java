package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class MonoidAssert<T, OP extends MonotypicalGroupOp<T>> {
    private final ValueGenerator<T> generator;
    private final Monoid<T> structure;

    public MonoidAssert(Monoid<T> structure, ValueGenerator<T> generator) {
        this.generator = generator;
        this.structure = structure;
    }

    public void assertIsMonoid() {
        assertIdentityExists();
        assertAssociative();
    }

    private void assertAssociative() {
        MonoidElement<T> a = structure.create(generator.generate());
        MonoidElement<T> b = structure.create(generator.generate());
        MonoidElement<T> c = structure.create(generator.generate());
        assertEquals(a.add(b.add(c)), a.add(b).add(c));
    }
    private void assertIdentityExists() {
        MonoidElement<T> i = structure.identity();
        MonoidElement<T> a = structure.create(generator.generate());
        MonoidElement<T> result = i.add(a);
        assertEquals(a, result);
    }
}
