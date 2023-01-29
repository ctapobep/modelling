package abstractalgebra.reals;

import abstractalgebra.abstractions.ValueGenerator;

import java.math.BigDecimal;

import static io.qala.datagen.RandomShortApi.Double;

public class RealGenerator implements ValueGenerator<Real> {
    public Real random() {
        return new Real(BigDecimal.valueOf(Double(-1000, 1000)));
    }
}
