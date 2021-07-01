package abstractalgebra.abstractions;

public class Group<T> implements MagmaElement<T>, ValueGenerator<GroupElement<T>> {
    private final MonotypicalGroupOp<T> add;
    private final ValueGenerator<T> valueGenerator;

    public Group(MonotypicalGroupOp<T> add, ValueGenerator<T> valueGenerator) {
        this.add = add;
        this.valueGenerator = valueGenerator;
        new GroupAssert<>(this).assertIsAbelianGroup();
    }

    public GroupElement<T> identity() {
        return create(add.identity());
    }

    public Monoid<T> toMonoid() {
        return new Monoid<>(add, valueGenerator);
    }


    public GroupElement<T> random() {
        return new GroupElement<>(valueGenerator.random(), add);
    }
    private GroupElement<T> create(T t) {
        return new GroupElement<>(t, add);
    }
}
