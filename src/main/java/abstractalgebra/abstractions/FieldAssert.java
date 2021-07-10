package abstractalgebra.abstractions;

public class FieldAssert<T> implements Assert {
    private final Field<T> field;

    public FieldAssert(Field<T> field) {
        this.field = field;
    }
    public void assertIsField() {
        new RingAssert<>(field.toRing()).assertIsRing();
        new InvertibilityAssert<>(field.toMultiplicativeGroup()).assertHasInverse();
    }
}
