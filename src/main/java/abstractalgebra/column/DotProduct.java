package abstractalgebra.column;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.abstractions.InnerProduct;
import abstractalgebra.reals.Real;

import java.math.BigDecimal;

public class DotProduct implements InnerProduct<Real, FieldColumn<Real>> {
    private final Field<Real> field;
    public DotProduct(Field<Real> field) {
        this.field = field;
    }

    public FieldElement<Real> calc(FieldColumn<Real> v1, FieldColumn<Real> v2) {
        if(v1.dims() != v2.dims())
            throw new IllegalArgumentException("Vectors of different lengths: " + v1 + " and " + v2);
        BigDecimal result = new BigDecimal(0);
        for (int r = 0; r < v1.dims(); r++)
            result = result.add(v1.get(r).multiply(v2.get(r)).val().asBigDecimal());
        return field.create(new Real(result));
    }
}
