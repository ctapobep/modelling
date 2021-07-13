package abstractalgebra.functions;

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
    @Override public Function inverse2(Function a) {
        return new OneOver(a);
    }
    @Override public Function identity2() {
        return Constant.ONE;
    }

    @Override public FieldElement<Real> identity1() {
        return null;
    }
    @Override public FieldElement<Real> inverse1(FieldElement<Real> a) {
        return null;
    }
}
