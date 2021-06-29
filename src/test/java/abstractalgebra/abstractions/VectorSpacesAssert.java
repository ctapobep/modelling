package abstractalgebra.abstractions;

import abstractalgebra.reals.Real;

import static org.junit.Assert.assertEquals;

public class VectorSpacesAssert<S, V> {
    private final ValueGenerator<V> vectorGenerator;
    private final VectorSpace<S, V> vectorSpace;
    private final Field<S> scalarField;
    private final ValueGenerator<S> fieldValueGenerator;

    public VectorSpacesAssert(ValueGenerator<V> vectorGenerator, VectorSpace<S, V> vectorSpace,
                              ValueGenerator<S> fieldValueGenerator, Field<S> scalarField) {
        this.vectorGenerator = vectorGenerator;
        this.vectorSpace = vectorSpace;
        this.scalarField = scalarField;
        this.fieldValueGenerator = fieldValueGenerator;
    }

    public void assertIsVectorSpace() {
        assertVectorsFormCommutativeGroup();
        assertScalarMultiplicationIsCompatibleWithFieldMultiplication();
    }

    private void assertVectorsFormCommutativeGroup() {
        new GroupAssert<>(vectorSpace.toVectorAdditiveGroup(), vectorGenerator).assertIsAbelianGroup();
    }
    private void assertScalarMultiplicationIsCompatibleWithFieldMultiplication() {
        V c = vectorGenerator.generate();
        VectorElement<S, V> v = vectorSpace.create(c);

        FieldElement<S> s1 = scalarField.create(fieldValueGenerator.generate()),
                        s2 = scalarField.create(fieldValueGenerator.generate());

        assertEquals(v.multiply(s1.multiply(s2)), v.multiply(s2).multiply(s1));
    }
}
