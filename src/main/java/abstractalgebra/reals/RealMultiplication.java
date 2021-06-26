package abstractalgebra.reals;

import abstractalgebra.abstractions.GroupOp;

import java.math.MathContext;

public class RealMultiplication implements GroupOp<Real> {
    public Real calc(Real o1, Real o2) {
        return new Real(o1.val().multiply(o2.val()));
    }
    @Override public Real identity() {
        return Real.ONE;
    }
    @Override public Real inverse(Real a) {
        return new Real(Real.ONE.val().divide(a.val(), MathContext.DECIMAL128));
    }
}