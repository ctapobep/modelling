package abstractalgebra.abstractions;

public class Group<T> implements MagmaElement<T>, ValueGenerator<GroupElement<T>> {
    private final MonotypicalGroupOp<T> add;
    private final ValueGenerator<T> valueGenerator;

    public Group(MonotypicalGroupOp<T> add, ValueGenerator<T> valueGenerator) {
        this.add = add;
        this.valueGenerator = valueGenerator;
    }

    public GroupElement<T> identity() {
        return create(add.identity());
    }

    public GroupElement<T> create(T t) {
        return new GroupElement<>(t, add);
    }
    public Monoid<T> toMonoid() {
        return new Monoid<>(add, valueGenerator);
    }
    public MonotypicalGroupOp<T> getOp() {
        return add;
    }

    public GroupElement<T> generate() {
        return new GroupElement<>(valueGenerator.generate(), add);
    }
}
