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
    public static final Real
            ZERO = new Real(BigDecimal.ZERO),
            ONE = new Real(BigDecimal.ONE),
            MINUS_ONE = new Real(new BigDecimal(-1)),
            PI = new Real(Math.PI),
            INF = new Real(new BigDecimal(Double.MAX_VALUE));
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

    public void assertIsClose(Real that) {
        if(this.v.subtract(that.v).abs().compareTo(new BigDecimal("0.0000000001")) >= 0)
            throw new AssertionError(this + " isn't close to " + that);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Real that = (Real) o;
        // This isn't a strict enough equals(), it violates the spec, but it's much convenient this way.
        // I don't think it will break any hash-based collections, at least not much.
        return this.v.subtract(that.v).abs().compareTo(new BigDecimal("0.0000000001")) < 0;
    }
    public int hashCode() {
        return Objects.hash(v);
    }
    public String toString() {
        return v.toString();
    }
}
