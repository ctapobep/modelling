package abstractalgebra.abstractions;

import java.util.Objects;

public class MonoidElement<T> {
    protected final T value;
    protected final MonotypicalGroupOp<T> op;

    public MonoidElement(T value, MonotypicalGroupOp<T> op) {
        this.value = value;
        this.op = op;
    }

    public MonoidElement<T> add(MonoidElement<T> o2) {
        return new MonoidElement<>(op.calc(value, o2.value), op);
    }
    public MonoidElement<T> inverse() {
        return new MonoidElement<>(this.op.inverse(this.value), op);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonoidElement<?> that = (MonoidElement<?>) o;
        return Objects.equals(value, that.value) && Objects.equals(op, that.op);
    }
    public String toString() {
        return value.toString();
    }
}
