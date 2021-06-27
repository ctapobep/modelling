package abstractalgebra.abstractions;

import java.util.Objects;

public class FieldMember<T> implements MagmaElement<T>{
    private final T value;
    private final MonotypicalGroupOp<T> add;
    private final MonotypicalGroupOp<T> multiply;

    public FieldMember(T value, MonotypicalGroupOp<T> add, MonotypicalGroupOp<T> multiply) {
        this.value = value;
        this.add = add;
        this.multiply = multiply;
    }

    public FieldMember<T> add(FieldMember<T> o2) {
        return new FieldMember<>(add.calc(value, o2.value), add, multiply);
    }
    public FieldMember<T> multiply(FieldMember<T> o2) {
        return new FieldMember<>(multiply.calc(value, o2.value), add, multiply);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldMember<?> that = (FieldMember<?>) o;
        return Objects.equals(value, that.value) && Objects.equals(add, that.add) && Objects.equals(multiply, that.multiply);
    }
    public String toString() {
        return value.toString();
    }

    public T val() {
        return value;
    }
}
