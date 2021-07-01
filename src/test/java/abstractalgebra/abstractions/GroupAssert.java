package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class GroupAssert<T> {
    private final Group<T> group;

    public GroupAssert(Group<T> group) {
        this.group = group;
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
        new MonoidAssert<>(group.toMonoid()).assertIsMonoid();
        new InvertibilityAssert<>(group).assertHasInverse();
    }

    private void assertCommutative() {
        GroupElement<T> a = group.generate();
        GroupElement<T> b = group.generate();
        assertEquals(a.add(b), b.add(a));
    }
}
