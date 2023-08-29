package abstractalgebra.reals;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class Real {
    private static final Map<Double, BigDecimal> DOUBLE_TO_BIG = Map.of(
            0D, BigDecimal.ZERO,
            1D, BigDecimal.ONE,
            10D, BigDecimal.TEN
    );
    public static final Real ZERO = new Real(BigDecimal.ZERO), ONE = new Real(BigDecimal.ONE), PI = new Real(Math.PI);
    private final BigDecimal v;

    public Real(double v) {
        this(DOUBLE_TO_BIG.getOrDefault(v, BigDecimal.valueOf(v)));
    }
    public Real(BigDecimal v) {
        this.v = v;
    }
    public BigDecimal asBigDecimal() {
        return v;
    }
    public double asDouble() {
        return v.doubleValue();
    }

    public boolean isClose(Real that) {
        return Math.abs(v.doubleValue() - that.v.doubleValue()) < 1e-15;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Real that = (Real) o;
        return Objects.equals(this.asBigDecimal(), that.asBigDecimal());
    }
    public int hashCode() {
        return Objects.hash(v);
    }
    public String toString() {
        return v.toString();
    }
}
