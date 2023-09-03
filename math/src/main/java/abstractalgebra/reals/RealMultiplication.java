package abstractalgebra.reals;

import abstractalgebra.abstractions.MonotypicalGroupOp;

import java.math.MathContext;

public class RealMultiplication implements MonotypicalGroupOp<Real> {
    public static final RealMultiplication INSTANCE = new RealMultiplication();

    public Real calc(Real o1, Real o2) {
        return new Real(o1.asBigDecimal().multiply(o2.asBigDecimal()));
    }
    public Real identity() {
        return Real.ONE;
    }
    public Real inverse(Real a) {
        return new Real(Real.ONE.asBigDecimal().divide(a.asBigDecimal(), MathContext.DECIMAL128));
    }

    public static Real multiply(Real r1, Real r2) {
        return INSTANCE.calc(r1, r2);
    }
}
