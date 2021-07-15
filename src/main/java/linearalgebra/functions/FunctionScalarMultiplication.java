package linearalgebra.functions;

import abstractalgebra.abstractions.BitypicalGroupOp;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.reals.Real;

public class FunctionScalarMultiplication implements BitypicalGroupOp<FieldElement<Real>, Function> {

    @Override public Function calcLeft(FieldElement<Real> o1, Function o2) {
        return new MultiplyByScalar(o1.val(), o2);
    }
    @Override public Function calcRight(Function o2, FieldElement<Real> o1) {
        return calcLeft(o1, o2);
    }
}
