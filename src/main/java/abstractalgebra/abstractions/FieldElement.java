package abstractalgebra.abstractions;

import java.util.Objects;

public class FieldElement<T> implements MagmaElement {
    private final T value;
    private final MonotypicalGroupOp<T> add;
    private final MonotypicalGroupOp<T> multiply;

    public FieldElement(T value, MonotypicalGroupOp<T> add, MonotypicalGroupOp<T> multiply) {
        this.value = value;
        this.add = add;
        this.multiply = multiply;
    }

    public FieldElement<T> add(FieldElement<T> o2) {
        return new FieldElement<>(add.calc(value, o2.value), add, multiply);
    }
    public FieldElement<T> multiply(FieldElement<T> o2) {
        return new FieldElement<>(multiply.calc(value, o2.value), add, multiply);
    }

    public FieldElement<T> additiveInverse() {
        return new FieldElement<>(add.inverse(value), add, multiply);
    }
    public FieldElement<T> multiplicativeInverse() {
        return new FieldElement<>(multiply.inverse(value), add, multiply);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldElement<?> that = (FieldElement<?>) o;
        return Objects.equals(value, that.value) && Objects.equals(add, that.add) && Objects.equals(multiply, that.multiply);
    }
    public String toString() {
        return value.toString();
    }

    public T val() {
        return value;
    }
}
