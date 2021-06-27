package abstractalgebra.abstractions;

public class Field<T> {
    private final MonotypicalGroupOp<T> add;
    private final MonotypicalGroupOp<T> multiply;

    public Field(MonotypicalGroupOp<T> add, MonotypicalGroupOp<T> multiply) {
        this.add = add;
        this.multiply = multiply;
    }

    public FieldMember<T> create(T t) {
        return new FieldMember<>(t, add, multiply);
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
    public FieldMember<T> multiplicativeIdentity() {
        return new FieldMember<>(multiply.identity(), add, multiply);
    }
    public FieldMember<T> additiveIdentity() {
        return new FieldMember<>(add.identity(), add, multiply);
    }
}
