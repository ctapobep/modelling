package abstractalgebra.vectors;

import abstractalgebra.reals.Real;

import java.util.Arrays;

public class Vector {
    public static final Vector ZERO = new Vector(new Real[]{});
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
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Arrays.equals(v, vector.v);
    }
    @Override public String toString() {
        return Arrays.toString(v);
    }
}
