package abstractalgebra.column;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.MonotypicalGroupOp;
import abstractalgebra.abstractions.VectorSpace;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealField;
import org.junit.Test;

public class FieldColumnTest {
    @Test public void formsGroupUnderAddition() {
        Field<Real> realField = RealField.create();
        ColumnGenerator<Real> generator = new ColumnGenerator<>(realField);

        MonotypicalGroupOp<FieldColumn<Real>> vectorAddition = new ColumnAddition<>(realField, generator.dims());
        ColumnScalarMultiplication<Real> scalarMultiplication = new ColumnScalarMultiplication<>(realField, generator.dims());
        new VectorSpace<>(vectorAddition, scalarMultiplication, generator, realField);
    }
}
