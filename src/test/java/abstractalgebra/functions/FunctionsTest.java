package abstractalgebra.functions;

import abstractalgebra.abstractions.VectorSpace;
import abstractalgebra.reals.RealField;
import org.junit.Test;

public class FunctionsTest {
    @Test public void functionsArePartOfVectorSpaces() {
        new VectorSpace<>(
                new FunctionAddition(), new FunctionScalarMultiplication(),
                new FunctionGenerator(),
                RealField.create());
    }
}
