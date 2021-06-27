package abstractalgebra.abstractions;

public class Monoid<T> {
    private final MonotypicalGroupOp<T> add;

    public Monoid(MonotypicalGroupOp<T> add) {
        this.add = add;
    }

    public MonoidMember<T> create(T t) {
        return new MonoidMember<>(t, add);
    }
    public MonoidMember<T> identity() {
        return new MonoidMember<>(add.identity(), add);
    }
}
