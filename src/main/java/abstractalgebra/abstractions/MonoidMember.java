package abstractalgebra.abstractions;

import java.util.Objects;

public class MonoidMember<T> {
    protected final T value;
    protected final MonotypicalGroupOp<T> op;

    public MonoidMember(T value, MonotypicalGroupOp<T> op) {
        this.value = value;
        this.op = op;
    }

    public MonoidMember<T> add(MonoidMember<T> o2) {
        return new MonoidMember<>(op.calc(value, o2.value), op);
    }
    public MonoidMember<T> inverse() {
        return new MonoidMember<>(this.op.inverse(this.value), op);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonoidMember<?> that = (MonoidMember<?>) o;
        return Objects.equals(value, that.value) && Objects.equals(op, that.op);
    }
    public String toString() {
        return value.toString();
    }
}
