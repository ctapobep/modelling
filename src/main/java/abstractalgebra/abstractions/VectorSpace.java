package abstractalgebra.abstractions;

public class VectorSpace<S, V> implements ValueGenerator<VectorElement<S, V>>, AlgebraicStructure {
    private final MonotypicalGroupOp<V> vectorAddition;
    private final BitypicalGroupOp<FieldElement<S>, V> scalarMultiplication;
    private final ValueGenerator<V> vectorGenerator;
    private final Field<S> scalarField;

    public VectorSpace(
            MonotypicalGroupOp<V> vectorAddition, BitypicalGroupOp<FieldElement<S>, V> scalarMultiplication,
            ValueGenerator<V> vectorGenerator,
            Field<S> scalarField) {
        this.vectorAddition = vectorAddition;
        this.scalarMultiplication = scalarMultiplication;
        this.vectorGenerator = vectorGenerator;
        this.scalarField = scalarField;
        new VectorSpacesAssert<>(this).assertIsVectorSpace();
    }

    public Group<V> getVectorAdditiveGroup() {
        return new Group<>(vectorAddition, vectorGenerator);
    }
    public Field<S> getScalarField() {
        return scalarField;
    }

    public VectorElement<S, V> random() {
        return create(vectorGenerator.random());
    }
    private VectorElement<S, V> create(V v) {
        return new VectorElement<>(v, vectorAddition, scalarMultiplication);
    }
}
