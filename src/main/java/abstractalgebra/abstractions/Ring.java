package abstractalgebra.abstractions;

public class Ring<T> implements ValueGenerator<RingElement<T>> {
    private final MonotypicalGroupOp<T> add;
    private final MonotypicalGroupOp<T> multiply;
    private final ValueGenerator<T> valueGenerator;

    public Ring(MonotypicalGroupOp<T> add, MonotypicalGroupOp<T> multiply, ValueGenerator<T> valueGenerator) {
        this.add = add;
        this.multiply = multiply;
        this.valueGenerator = valueGenerator;
    }

    public RingElement<T> create(T t) {
        return new RingElement<>(t, add, multiply);
    }

    public Group<T> toAdditiveGroup() {
        return new Group<>(add, valueGenerator);
    }
    public Monoid<T> toMultiplicativeMonoid() {
        return new Monoid<>(multiply, valueGenerator);
    }
    @Override public RingElement<T> generate() {
        return new RingElement<>(valueGenerator.generate(), add, multiply);
    }
}
