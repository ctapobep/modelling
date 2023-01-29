package abstractalgebra.reals;

import abstractalgebra.abstractions.Field;

public class RealField {
    public static Field<Real> create() {
        return new Field<>(new RealAddition(), new RealMultiplication(), new RealGenerator());
    }
}
