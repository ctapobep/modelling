package abstractalgebra.abstractions;

import java.util.Objects;

public class VectorElement<S, V> implements MagmaElement {
    private final V value;
    private final MonotypicalGroupOp<V> vectorAddition;
    private final BitypicalGroupOp<FieldElement<S>, V> scalarMultiplication;

    public VectorElement(V value,
                         MonotypicalGroupOp<V> vectorAddition,
                         BitypicalGroupOp<FieldElement<S>, V> scalarMultiplication) {
        this.value = value;
        this.vectorAddition = vectorAddition;
        this.scalarMultiplication = scalarMultiplication;
    }

    public VectorElement<S, V> add(VectorElement<S, V> v) {
        return new VectorElement<>(vectorAddition.calc(this.value, v.value), vectorAddition, scalarMultiplication);
    }
    public VectorElement<S, V> multiply(FieldElement<S> scalar) {
        return new VectorElement<>(scalarMultiplication.calcRight(this.value, scalar), vectorAddition, scalarMultiplication);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VectorElement<?, ?> that = (VectorElement<?, ?>) o;
        return Objects.equals(value, that.value)
               && Objects.equals(vectorAddition, that.vectorAddition)
               && Objects.equals(scalarMultiplication, that.scalarMultiplication);
    }
    @Override public String toString() {
        return value.toString();
    }
}
