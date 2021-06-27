package abstractalgebra.column;

import abstractalgebra.reals.Real;

import java.util.Arrays;

public class VectorMember {
    public static final VectorMember ZERO = new VectorMember(new Real[]{});
    private final Real[] v;

    public VectorMember(Real[] v) {
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
        VectorMember vector = (VectorMember) o;
        return Arrays.equals(v, vector.v);
    }
    @Override public String toString() {
        return Arrays.toString(v);
    }
}
