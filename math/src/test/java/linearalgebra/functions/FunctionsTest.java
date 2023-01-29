package linearalgebra.functions;

import abstractalgebra.abstractions.Field;
import linearalgebra.abstractions.VectorSpace;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealField;
import org.junit.Test;

public class FunctionsTest {
    @Test public void functionsArePartOfVectorSpaces() {
        Field<Real> scalarField = RealField.create();
        new VectorSpace<>(
                new FunctionAddition(), new FunctionScalarMultiplication(),
                new CrossCorrelation(scalarField), new FunctionGenerator(),
                scalarField);
    }
}
