package linearalgebra.abstractions;

import abstractalgebra.abstractions.Assert;
import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.abstractions.GroupAssert;
import abstractalgebra.reals.Real;

import static org.junit.Assert.assertEquals;

public class VectorSpacesAssert<S extends Real, V> implements Assert {
    private final VectorSpace<S, V> vectorSpace;
    private final Field<S> scalarField;

    public VectorSpacesAssert(VectorSpace<S, V> vectorSpace) {
        this.vectorSpace = vectorSpace;
        this.scalarField = vectorSpace.getScalarField();
    }

    public void assertIsVectorSpace() {
        assertVectorsFormCommutativeGroup();
        assertScalarMultiplicationIsCompatibleWithFieldMultiplication();
        assertScalarMultiplicationHasIdentity();
        assertScalarMultiplicationIsDistributiveWithRespectToVectorAddition();
        assertScalarMultiplicationIsDistributiveWithRespectToFieldAddition();
    }

    private void assertVectorsFormCommutativeGroup() {
        new GroupAssert<>(vectorSpace.getVectorAdditiveGroup()).assertIsCommutativeGroup();
    }
    private void assertScalarMultiplicationIsCompatibleWithFieldMultiplication() {
        VectorElement<S, V> v = vectorSpace.random();
        FieldElement<S> s1 = scalarField.random(),
                        s2 = scalarField.random();
        assertEquals(v.multiply(s1.multiply(s2)), v.multiply(s2).multiply(s1));
    }
    private void assertScalarMultiplicationHasIdentity() {
        VectorElement<S, V> v = vectorSpace.random();
        FieldElement<S> s = scalarField.multiplicativeIdentity();
        assertEquals(v, v.multiply(s));
    }
    private void assertScalarMultiplicationIsDistributiveWithRespectToVectorAddition() {
        VectorElement<S, V> v1 = vectorSpace.random(),
                            v2 = vectorSpace.random();
        FieldElement<S> s = scalarField.multiplicativeIdentity();
        assertEquals(v1.add(v2).multiply(s), v1.multiply(s).add(v2.multiply(s)));
    }
    private void assertScalarMultiplicationIsDistributiveWithRespectToFieldAddition() {
        VectorElement<S, V> v = vectorSpace.random();
        FieldElement<S> s1 = scalarField.random(),
                        s2 = scalarField.random();
        assertEquals(v.multiply(s1.add(s2)), v.multiply(s1).add(v.multiply(s2)));
    }
}
