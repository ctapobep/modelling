package abstractalgebra.reals;

import java.math.BigDecimal;
import java.util.Objects;

public class Real {
    public static final Real ZERO = new Real(BigDecimal.ZERO), ONE = new Real(BigDecimal.ONE);
    private final BigDecimal v;

    public Real(BigDecimal v) {
        this.v = v;
    }
    public BigDecimal val() {
        return v;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Real another = (Real) o;
        return Math.abs(v.doubleValue() - another.v.doubleValue()) < 1e-20;
    }
    public String toString() {
        return v.toString();
    }
}
