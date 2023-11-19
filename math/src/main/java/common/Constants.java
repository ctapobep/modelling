package common;

import java.math.BigDecimal;

public interface Constants {
    BigDecimal MINUS_ONE = BigDecimal.ONE.negate();
    double DEG120 = 2./3.*Math.PI, DEG45 = Math.PI/4;
}
