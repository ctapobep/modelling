package abstractalgebra.functions;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.reals.Real;

import java.math.BigDecimal;

public class Sin implements Function<Real, FieldElement<Real>> {
    private final Field<Real> field;

    public Sin(Field<Real> field) {
        this.field = field;
    }

    @Override public FieldElement<Real> get(FieldElement<Real> real) {
        double sin = Math.sin(real.val().asDouble());
        return field.create(new Real(BigDecimal.valueOf(sin)));
    }
}
