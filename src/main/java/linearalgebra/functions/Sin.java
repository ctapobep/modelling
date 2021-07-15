package linearalgebra.functions;

import abstractalgebra.reals.Real;

import java.math.BigDecimal;

public class Sin extends ComparableFunction {

    public Real get(Real x) {
        return new Real(BigDecimal.valueOf(Math.sin(x.asDouble())));
    }
}
