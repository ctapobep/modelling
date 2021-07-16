package linearalgebra.abstractions;

import abstractalgebra.abstractions.Field;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealField;
import linearalgebra.column.FieldColumn;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixTest {
    @Test public void matrixTranspose() {
        Field<Real> field = RealField.create();
        Matrix<Real> m = new Matrix<>(new FieldColumn<>(field.create(new Real(1))));
        assertEquals(m, m.t());
    }
}