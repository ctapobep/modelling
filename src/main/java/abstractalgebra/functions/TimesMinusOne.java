package abstractalgebra.functions;

import abstractalgebra.reals.Real;

import java.math.BigDecimal;

public class TimesMinusOne implements Function<Real> {
    private static final BigDecimal MINUS_ONE = BigDecimal.valueOf(-1);
    private final Function<Real> wrapped;

    public TimesMinusOne(Function<Real> wrapped) {
        this.wrapped = wrapped;
    }

    public Real get(Real real) {
        return new Real(MINUS_ONE.multiply(wrapped.get(real).asBigDecimal()));
    }
}
