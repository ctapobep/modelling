package abstractalgebra.abstractions;

public class Group<T> implements MagmaElement<T> {
    private final MonotypicalGroupOp<T> add;

    public Group(MonotypicalGroupOp<T> add) {
        this.add = add;
    }

    public GroupElement<T> create(T t) {
        return new GroupElement<>(t, add);
    }
    public Monoid<T> toMonoid() {
        return new Monoid<>(add);
    }
    public MonotypicalGroupOp<T> getOp() {
        return add;
    }
}
