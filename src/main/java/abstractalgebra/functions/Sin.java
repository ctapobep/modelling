package abstractalgebra.functions;

import abstractalgebra.reals.Real;

import java.math.BigDecimal;

public class Sin implements Function<Real> {

    public Real get(Real real) {
        return new Real(BigDecimal.valueOf(Math.sin(real.asDouble())));
    }
}
