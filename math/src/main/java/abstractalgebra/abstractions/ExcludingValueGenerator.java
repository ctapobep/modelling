package abstractalgebra.abstractions;

public class ExcludingValueGenerator<T> implements ValueGenerator<T> {
    private final ValueGenerator<T> primary;
    private final T excluded;

    public ExcludingValueGenerator(ValueGenerator<T> primary, T excluded) {
        this.primary = primary;
        this.excluded = excluded;
    }

    @Override public T random() {
        T v;
        do {
            v = primary.random();
        } while (v.equals(excluded));
        return v;
    }
}
