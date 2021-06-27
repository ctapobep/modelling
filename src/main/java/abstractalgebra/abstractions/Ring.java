package abstractalgebra.abstractions;

public class Ring<T> {
    private final MonotypicalGroupOp<T> add;
    private final MonotypicalGroupOp<T> multiply;

    public Ring(MonotypicalGroupOp<T> add, MonotypicalGroupOp<T> multiply) {
        this.add = add;
        this.multiply = multiply;
    }

    public RingMember<T> create(T t) {
        return new RingMember<>(t, add, multiply);
    }

    public Group<T> toAdditiveGroup() {
        return new Group<>(add);
    }
    public Monoid<T> toMultiplicativeMonoid() {
        return new Monoid<>(multiply);
    }
}
