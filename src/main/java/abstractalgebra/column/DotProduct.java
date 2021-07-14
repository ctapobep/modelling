package abstractalgebra.column;

import abstractalgebra.abstractions.InnerProduct;
import abstractalgebra.reals.Real;

import java.math.BigDecimal;

public class DotProduct implements InnerProduct<Real, FieldColumn<Real>> {
    @Override
    public Real calc(FieldColumn<Real> v1, FieldColumn<Real> v2) {
        if(v1.dims() != v2.dims())
            throw new IllegalArgumentException("Vectors of different lengths: " + v1 + " and " + v2);
        BigDecimal result = new BigDecimal(0);
        for (int r = 0; r < v1.dims(); r++)
            result = result.add(v1.get(r).multiply(v2.get(r)).val().asBigDecimal());
        return new Real(result);
    }
}
