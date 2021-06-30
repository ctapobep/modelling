package abstractalgebra.abstractions;

public class VectorSpace<S, V> {
    private final MonotypicalGroupOp<V> vectorAddition;
    private final BitypicalGroupOp<FieldElement<S>, V> scalarMultiplication;
    private final ValueGenerator<V> vectorGenerator;

    public VectorSpace(MonotypicalGroupOp<V> vectorAddition, BitypicalGroupOp<FieldElement<S>, V> scalarMultiplication
            , ValueGenerator<V> vectorGenerator) {
        this.vectorAddition = vectorAddition;
        this.scalarMultiplication = scalarMultiplication;
        this.vectorGenerator = vectorGenerator;
    }

    public VectorElement<S, V> create(V v) {
        return new VectorElement<>(v, vectorAddition, scalarMultiplication);
    }
    public Group<V> toVectorAdditiveGroup() {
        return new Group<>(vectorAddition, vectorGenerator);
    }
}
