package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class MonoidAssert2<T, OP extends MonotypicalGroupOp<T>> {
    private final ValueGenerator<T> generator;
    private final Monoid<T> structure;

    public MonoidAssert2(Monoid<T> structure, ValueGenerator<T> generator) {
        this.generator = generator;
        this.structure = structure;
    }

    public void assertIsMonoid() {
        assertIdentityExists();
        assertAssociative();
    }

    private void assertAssociative() {
        MonoidMember<T> a = structure.create(generator.generate());
        MonoidMember<T> b = structure.create(generator.generate());
        MonoidMember<T> c = structure.create(generator.generate());
        assertEquals(a.add(b.add(c)), a.add(b).add(c));
    }
    private void assertIdentityExists() {
        MonoidMember<T> i = structure.identity();
        MonoidMember<T> a = structure.create(generator.generate());
        MonoidMember<T> result = i.add(a);
        assertEquals(a, result);
    }
}
