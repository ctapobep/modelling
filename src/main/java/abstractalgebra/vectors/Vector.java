package abstractalgebra.vectors;

import abstractalgebra.reals.Real;

public class Vector {
    private final Real[] v;

    public Vector(Real[] v) {
        this.v = v;
    }

    public Real[] val() {
        return v;
    }
    public int dims() {
        return v.length;
    }
}
