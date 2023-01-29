package linearalgebra.abstractions;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.reals.Real;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class InnerProductAssert<S extends Real, V> {
    private final VectorSpace<S, V> vectorSpace;
    private final Field<S> scalarField;

    public InnerProductAssert(VectorSpace<S, V> vectorSpace) {
        this.vectorSpace = vectorSpace;
        this.scalarField = vectorSpace.getScalarField();
    }

    public void assertInnerProductCorrect() {
        assertNormIsPositiveDefiniteForNonZeroVectors();
        assertZeroVectorTimesAnythingIsZeroVector();
        assertFirstArgumentAddingIsLinear();
        assertFirstArgumentScalingIsLinear();
    }

    private void assertNormIsPositiveDefiniteForNonZeroVectors() {
        VectorElement<S, V> v = vectorSpace.random();
        FieldElement<S> result = v.innerProduct(v);
        if(v.equals(vectorSpace.zero()))
            assertEquals(scalarField.additiveIdentity(), result);
        else
            assertTrue("Actual: " + result, result.val().asDouble() > 0);
    }

    private void assertZeroVectorTimesAnythingIsZeroVector() {
        VectorElement<S, V> v = vectorSpace.random(),
                            o = vectorSpace.zero();
        assertEquals(scalarField.additiveIdentity(), o.innerProduct(v));
    }
    private void assertFirstArgumentScalingIsLinear() {
        FieldElement<S> scalar = scalarField.random();

        VectorElement<S, V> v1 = vectorSpace.random(),
                            v2 = vectorSpace.random(),
                            v1TimesScalar = v1.multiply(scalar);
        assertEquals(
                v2.innerProduct(v1).multiply(scalar),
                v2.innerProduct(v1TimesScalar));
    }
    private void assertFirstArgumentAddingIsLinear() {
        VectorElement<S, V> v1 = vectorSpace.random(),
                            v2 = vectorSpace.random(),
                            v3 = vectorSpace.random(),
                            v1PlusV2 = v1.add(v2);
        assertEquals(
                v1PlusV2.innerProduct(v3),
                v1.innerProduct(v3).add(v2.innerProduct(v3)));
    }
}
