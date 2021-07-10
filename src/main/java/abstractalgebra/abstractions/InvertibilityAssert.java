package abstractalgebra.abstractions;

import static org.junit.Assert.assertEquals;

public class InvertibilityAssert<T> implements Assert {
    private final Group<T> group;

    public InvertibilityAssert(Group<T> group) {
        this.group = group;
    }

    public void assertHasInverse() {
        GroupElement<T> a = group.random();
        assertEquals(group.identity(), a.add(a.inverse()));
    }
}
