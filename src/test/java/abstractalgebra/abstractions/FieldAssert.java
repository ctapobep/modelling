package abstractalgebra.abstractions;

public class FieldAssert<T> {
    private final Field<T> field;
    private final ValueGenerator<T> generator;

    public FieldAssert(Field<T> field, ValueGenerator<T> generator) {
        this.field = field;
        this.generator = generator;
    }
    public void assertIsField() {
        new RingAssert<>(field.toRing(), generator).assertIsRing();
        new InvertibilityAssert<>(field.getMultiplication(), generator).assertHasInverse();
    }
}
