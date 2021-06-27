package abstractalgebra.abstractions;

public class Monoid<T> {
    private final MonotypicalGroupOp<T> add;

    public Monoid(MonotypicalGroupOp<T> add) {
        this.add = add;
    }

    public MonoidElement<T> create(T t) {
        return new MonoidElement<>(t, add);
    }
    public MonoidElement<T> identity() {
        return new MonoidElement<>(add.identity(), add);
    }
}
