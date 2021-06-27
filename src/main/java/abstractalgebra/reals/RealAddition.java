package abstractalgebra.reals;

import abstractalgebra.abstractions.MonotypicalGroupOp;

import java.math.BigDecimal;

public class RealAddition implements MonotypicalGroupOp<Real> {

    public Real calc(Real o1, Real o2) {
        return new Real(o1.val().add(o2.val()));
    }
    public Real identity() {
        return Real.ZERO;
    }
    public Real inverse(Real a) {
        return new Real(a.val().multiply(new BigDecimal(-1)));
    }
}
