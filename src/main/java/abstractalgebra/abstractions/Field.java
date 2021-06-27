package abstractalgebra.abstractions;

public class Field<T> {
    private final MonotypicalGroupOp<T> add;
    private final MonotypicalGroupOp<T> multiply;

    public Field(MonotypicalGroupOp<T> add, MonotypicalGroupOp<T> multiply) {
        this.add = add;
        this.multiply = multiply;
    }

    public FieldElement<T> create(T t) {
        return new FieldElement<>(t, add, multiply);
    }
    public Ring<T> toRing() {
        return new Ring<>(add, multiply);
    }
    public Group<T> toMultiplicativeGroup() {
        return new Group<>(multiply);
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
}
