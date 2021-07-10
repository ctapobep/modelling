package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

class GroupAssert<T> implements Assert {
    private final Group<T> group;

    public GroupAssert(Group<T> group) {
        this.group = group;
    }

    public void assertIsCommutativeGroup() {
        assertIsGroup();
        assertCommutative();
    }
    public void assertIsGroup() {
        // monoids are associative and have identity element
        new MonoidAssert<>(group.toMonoid()).assertIsMonoid();
        new InvertibilityAssert<>(group).assertHasInverse();
    }

    private void assertCommutative() {
        GroupElement<T> a = group.random();
        GroupElement<T> b = group.random();
        assertEquals(a.add(b), b.add(a));
    }
}
