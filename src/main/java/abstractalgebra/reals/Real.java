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
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Real another = (Real) o;
        return v.compareTo(another.v) == 0;
    }
    @Override public int hashCode() {
        return Objects.hash(v);
    }
    @Override public String toString() {
        return v.toString();
    }
}
