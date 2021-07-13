package abstractalgebra.functions;

import abstractalgebra.reals.Real;

import java.math.BigDecimal;

public class Zero implements Function<Real>{
    public static final Zero INSTANCE = new Zero();

    public Real get(Real realFieldElement) {
        return new Real(BigDecimal.ZERO);
    }
}
