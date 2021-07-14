package abstractalgebra.column;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealField;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DotProductTest {
    @Test public void normIsPositiveDefinite() {
        Field<Real> realField = RealField.create();
        ColumnGenerator<Real> columnGenerator = new ColumnGenerator<>(realField);
        FieldColumn<Real> v = columnGenerator.random();
        double result = new DotProduct().calc(v, v).asDouble();
        assertTrue("Actual: " + result, result > 0);
    }
    @Test @SuppressWarnings({"unchecked", "rawtypes"})
    public void dotProductExample() {
        Field<Real> realField = RealField.create();
        FieldColumn<Real> v1 = new FieldColumn<>(new FieldElement[]{realField.create(new Real(1)), realField.create(new Real(2))});
        FieldColumn<Real> v2 = new FieldColumn<>(new FieldElement[]{realField.create(new Real(-1)), realField.create(new Real(5))});
        assertEquals(new Real(new BigDecimal(9)), new DotProduct().calc(v1, v2));
    }
}