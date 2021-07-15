package abstractalgebra.abstractions;

import abstractalgebra.reals.Real;

public class VectorSpace<S extends Real, V> implements ValueGenerator<VectorElement<S, V>>, AlgebraicStructure {
    private final MonotypicalGroupOp<V> vectorAddition;
    private final BitypicalGroupOp<FieldElement<S>, V> scalarMultiplication;
    private final InnerProduct<S, V> innerProduct;
    private final ValueGenerator<V> vectorGenerator;
    private final Field<S> scalarField;

    public VectorSpace(
            MonotypicalGroupOp<V> vectorAddition, BitypicalGroupOp<FieldElement<S>, V> scalarMultiplication,
            InnerProduct<S, V> innerProduct, ValueGenerator<V> vectorGenerator,
            Field<S> scalarField) {
        this.vectorAddition = vectorAddition;
        this.scalarMultiplication = scalarMultiplication;
        this.innerProduct = innerProduct;
        this.vectorGenerator = vectorGenerator;
        this.scalarField = scalarField;
        new VectorSpacesAssert<>(this).assertIsVectorSpace();
        new InnerProductAssert<>(this).assertInnerProductCorrect();
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
    public VectorElement<S, V> zero() {
        return create(vectorAddition.identity());
    }
    private VectorElement<S, V> create(V v) {
        return new VectorElement<>(v, vectorAddition, scalarMultiplication, innerProduct);
    }
}
