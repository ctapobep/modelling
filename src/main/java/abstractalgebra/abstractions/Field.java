package abstractalgebra.abstractions;

public class Field<T> implements ValueGenerator<FieldElement<T>>{
    private final MonotypicalGroupOp<T> add;
    private final MonotypicalGroupOp<T> multiply;
    private final ValueGenerator<T> valueGenerator;

    public Field(MonotypicalGroupOp<T> add, MonotypicalGroupOp<T> multiply, ValueGenerator<T> valueGenerator) {
        this.add = add;
        this.multiply = multiply;
        this.valueGenerator = valueGenerator;
        new FieldAssert<>(this).assertIsField();
    }

    public Ring<T> toRing() {
        return new Ring<>(add, multiply, valueGenerator);
    }
    public Group<T> toMultiplicativeGroup() {
        return new Group<>(multiply, valueGenerator);
    }
    public MonotypicalGroupOp<T> getMultiplication() {
        return multiply;
    }

    public FieldElement<T> multiplicativeInverse(FieldElement<T> t) {
        return create(multiply.inverse(t.val()));
    }
    public FieldElement<T> additiveInverse(FieldElement<T> t) {
        return create(add.inverse(t.val()));
    }

    public FieldElement<T> multiplicativeIdentity() {
        return create(multiply.identity());
    }
    public FieldElement<T> additiveIdentity() {
        return create(add.identity());
    }

    public FieldElement<T> create(T t) {
        return new FieldElement<>(t, add, multiply);
    }
    public FieldElement<T> random() {
        return new FieldElement<>(valueGenerator.random(), add, multiply);
    }
}
