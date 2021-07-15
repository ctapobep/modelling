package abstractalgebra.column;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealAddition;
import abstractalgebra.reals.RealField;
import abstractalgebra.reals.RealMultiplication;
import org.junit.Test;

import static org.junit.Assert.*;

public class DotProductTest {
    @Test public void normIsPositiveDefiniteForNonZeroVectors() {
        Field<Real> realField = RealField.create();
        ColumnGenerator<Real> columnGenerator = new ColumnGenerator<>(realField);
        FieldColumn<Real> v = columnGenerator.random();
        double result = innerProduct(v, v).asDouble();
        if(v.equals(columnGenerator.zero()))
            assertEquals(0, result, 0);
        else
            assertTrue("Actual: " + result, result > 0);
    }
    @Test @SuppressWarnings({"unchecked", "rawtypes"})
    public void dotProductExample() {
        Field<Real> realField = RealField.create();
        FieldColumn<Real> v1 = new FieldColumn<>(new FieldElement[]{realField.create(new Real(1)), realField.create(new Real(2))});
        FieldColumn<Real> v2 = new FieldColumn<>(new FieldElement[]{realField.create(new Real(-1)), realField.create(new Real(5))});
        assertEquals(new Real(9), innerProduct(v2, v1));
    }
    @Test public void zeroVectorTimesAnythingIsZeroVector() {
        Field<Real> realField = RealField.create();
        ColumnGenerator<Real> columnGenerator = new ColumnGenerator<>(realField);
        FieldColumn<Real> v = columnGenerator.random(),
                          zero = columnGenerator.zero();
        assertEquals(new Real(0), innerProduct(v, zero));
    }
    @Test public void firstArgumentScalingIsLinear() {
        Field<Real> realField = RealField.create();
        FieldElement<Real> scalar = realField.random();

        ColumnGenerator<Real> columnGenerator = new ColumnGenerator<>(realField);
        FieldColumn<Real> v1 = columnGenerator.random(),
                          v2 = columnGenerator.random(),
                          v1TimesScalar = new ColumnScalarMultiplication<>(realField, columnGenerator.dims()).calcLeft(scalar, v1);

        assertEquals(
                new RealMultiplication().calc(innerProduct(v2, v1), scalar.val()),
                innerProduct(v2, v1TimesScalar));
    }
    @Test public void firstArgumentAddingIsLinear() {
        Field<Real> realField = RealField.create();

        ColumnGenerator<Real> columnGenerator = new ColumnGenerator<>(realField);
        FieldColumn<Real> v1 = columnGenerator.random(),
                          v2 = columnGenerator.random(),
                          v3 = columnGenerator.random(),
                          v1PlusV2 = new ColumnAddition<>(realField, columnGenerator.dims()).calc(v1, v2);
        assertEquals(
                innerProduct(v1PlusV2, v3),
                new RealAddition().calc(innerProduct(v1, v3), innerProduct(v2, v3)));
    }

    private Real innerProduct(FieldColumn<Real> v2, FieldColumn<Real> v1TimesScalar) {
        return new DotProduct().calc(v1TimesScalar, v2);
    }
}