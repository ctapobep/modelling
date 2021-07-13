package abstractalgebra.functions;

import abstractalgebra.reals.Real;

import java.math.BigDecimal;

public class TimesMinusOne implements Function {
    private static final BigDecimal MINUS_ONE = BigDecimal.valueOf(-1);
    private final Function wrapped;

    public TimesMinusOne(Function wrapped) {
        this.wrapped = wrapped;
    }

    public Real get(Real x) {
        return new Real(MINUS_ONE.multiply(wrapped.get(x).asBigDecimal()));
    }
}
