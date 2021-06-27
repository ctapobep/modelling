package abstractalgebra.abstractions;

public class VectorElement<S, V extends Field<S>> {
    private final V value;
    private final MonotypicalGroupOp<V> vectorAddition;
    private final BitypicalGroupOp<S, V> scalarMultiplication;

    public VectorElement(V value, MonotypicalGroupOp<V> vectorAddition, BitypicalGroupOp<S, V> scalarMultiplication) {
        this.value = value;
        this.vectorAddition = vectorAddition;
        this.scalarMultiplication = scalarMultiplication;
    }

    public VectorElement<S, V> add(VectorElement<S, V> v) {
        return new VectorElement<>(vectorAddition.calc(this.value, v.value), vectorAddition, scalarMultiplication);
    }
    public VectorElement<S, V> multiply(FieldElement<S> scalar) {
        return new VectorElement<>(scalarMultiplication.calcRight(this.value, scalar.val()), vectorAddition, scalarMultiplication);
    }
}
