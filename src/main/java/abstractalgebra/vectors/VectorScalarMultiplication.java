package abstractalgebra.vectors;

import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealAddition;
import abstractalgebra.reals.RealMultiplication;

import java.util.Arrays;

public class VectorScalarMultiplication {
    private final int dims;

    public VectorScalarMultiplication(int dims) {
        this.dims = dims;
    }
    public Vector identity() {
        Real[] r = new Real[dims];
        Arrays.fill(r, Real.ONE);
        return new Vector(r);
    }
    public Vector inverse(Vector a) {
        Real[] result = new Real[a.dims()];
        for (int i = 0; i < result.length; i++)
            result[i] = new RealAddition().inverse(a.val()[i]);
        return new Vector(result);
    }
    public Vector calc(Real scalar, Vector v) {
        RealMultiplication realMultiplication = new RealMultiplication();
        Real[] result = new Real[v.dims()];
        for (int i = 0; i < result.length; i++)
            result[i] = realMultiplication.calc(v.val()[i], scalar);
        return new Vector(result);
    }
}
