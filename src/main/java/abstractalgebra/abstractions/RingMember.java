package abstractalgebra.abstractions;

import java.util.Objects;

public class RingMember<T> {
    private final T value;
    private final MonotypicalGroupOp<T> add;
    private final MonotypicalGroupOp<T> multiply;

    public RingMember(T value, MonotypicalGroupOp<T> add, MonotypicalGroupOp<T> multiply) {
        this.value = value;
        this.add = add;
        this.multiply = multiply;
    }

    public RingMember<T> add(RingMember<T> o2) {
        return new RingMember<>(add.calc(value, o2.value), add, multiply);
    }
    public RingMember<T> multiply(RingMember<T> o2) {
        return new RingMember<>(multiply.calc(value, o2.value), add, multiply);
    }
    public GroupMember<T> toAdditiveGroup() {
        return new GroupMember<>(value, add);
    }
    public MonoidMember<T> toMultiplicativeMonoid() {
        return new MonoidMember<>(value, multiply);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RingMember<?> that = (RingMember<?>) o;
        return Objects.equals(value, that.value) && Objects.equals(add, that.add) && Objects.equals(multiply, that.multiply);
    }
    public String toString() {
        return value.toString();
    }
}
