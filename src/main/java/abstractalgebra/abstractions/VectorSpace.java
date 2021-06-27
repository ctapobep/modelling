package abstractalgebra.abstractions;

public class VectorSpace<S, V> {
    private final MonotypicalGroupOp<V> vectorAddition;
    private final BitypicalGroupOp<S, V> scalarMultiplication;

    public VectorSpace(MonotypicalGroupOp<V> vectorAddition, BitypicalGroupOp<S, V> scalarMultiplication) {
        this.vectorAddition = vectorAddition;
        this.scalarMultiplication = scalarMultiplication;
    }

//    public VectorElement<S, Field<S>> create(V v) {
//        return new VectorElement<>(v, vectorAddition, scalarMultiplication);
//    }
}
