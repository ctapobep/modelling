package abstractalgebra.functions;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.abstractions.InnerProduct;
import abstractalgebra.reals.Real;

public class CrossCorrelation implements InnerProduct<Real, Function> {
    private final Field<Real> field;
    public CrossCorrelation(Field<Real> field) {
        this.field = field;
    }
    @Override public FieldElement<Real> calc(Function v1, Function v2) {
        return null;
    }
}
