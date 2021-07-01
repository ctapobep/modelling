package abstractalgebra.abstractions;

public class Monoid<T> implements ValueGenerator<MonoidElement<T>> {
    private final MonotypicalGroupOp<T> add;
    private final ValueGenerator<T> valueGenerator;

    public Monoid(MonotypicalGroupOp<T> add, ValueGenerator<T> valueGenerator) {
        this.add = add;
        this.valueGenerator = valueGenerator;
        new MonoidAssert<>(this).assertIsMonoid();
    }

    public MonoidElement<T> create(T t) {
        return new MonoidElement<>(t, add);
    }
    public MonoidElement<T> identity() {
        return new MonoidElement<>(add.identity(), add);
    }

    public MonoidElement<T> random() {
        return new MonoidElement<>(valueGenerator.random(), add);
    }
}
