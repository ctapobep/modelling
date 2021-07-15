package abstractalgebra.functions;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.abstractions.InnerProduct;
import abstractalgebra.reals.Real;

import java.math.BigDecimal;

public class CrossCorrelation implements InnerProduct<Real, Function> {
    private final Field<Real> field;

    public CrossCorrelation(Field<Real> field) {
        this.field = field;
    }

    public FieldElement<Real> calc(Function v1, Function v2) {
        BigDecimal result = BigDecimal.ZERO;
        double stepDouble = 2./100;
        BigDecimal stepBd = BigDecimal.valueOf(stepDouble);
        for(int i = 0; i < 100; i++) {
            Real x = new Real(stepDouble * i - 1);
            result = result.add(
                    v1.get(x).asBigDecimal()
                            .multiply(v2.get(x).asBigDecimal())
                            .multiply(stepBd)
            );
        }
        return field.create(new Real(result));
    }
}
