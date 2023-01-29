package abstractalgebra.abstractions;

import java.util.Objects;

public class RingElement<T> implements MagmaElement {
    private final T value;
    private final MonotypicalGroupOp<T> add;
    private final MonotypicalGroupOp<T> multiply;

    public RingElement(T value, MonotypicalGroupOp<T> add, MonotypicalGroupOp<T> multiply) {
        this.value = value;
        this.add = add;
        this.multiply = multiply;
    }

    public RingElement<T> add(RingElement<T> o2) {
        return new RingElement<>(add.calc(value, o2.value), add, multiply);
    }
    public RingElement<T> multiply(RingElement<T> o2) {
        return new RingElement<>(multiply.calc(value, o2.value), add, multiply);
    }
    public GroupElement<T> toAdditiveGroup() {
        return new GroupElement<>(value, add);
    }
    public MonoidElement<T> toMultiplicativeMonoid() {
        return new MonoidElement<>(value, multiply);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RingElement<?> that = (RingElement<?>) o;
        return Objects.equals(value, that.value) && Objects.equals(add, that.add) && Objects.equals(multiply, that.multiply);
    }
    public String toString() {
        return value.toString();
    }
}
