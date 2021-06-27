package abstractalgebra.column;

import abstractalgebra.abstractions.FieldMember;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealAddition;
import abstractalgebra.reals.RealMultiplication;

import java.util.Arrays;

public class VectorScalarMultiplication {
    private final int dims;

    public VectorScalarMultiplication(int dims) {
        this.dims = dims;
    }
    public VectorMember identity() {
        Real[] r = new Real[dims];
        Arrays.fill(r, Real.ONE);
        return new VectorMember(r);
    }
    public VectorMember inverse(VectorMember a) {
        Real[] result = new Real[a.dims()];
        for (int i = 0; i < result.length; i++)
            result[i] = new RealAddition().inverse(a.val()[i]);
        return new VectorMember(result);
    }
    public VectorMember calc(FieldMember<Real> scalar, VectorMember v) {
        RealMultiplication realMultiplication = new RealMultiplication();
        Real[] result = new Real[v.dims()];
        for (int i = 0; i < result.length; i++)
            result[i] = realMultiplication.calc(v.val()[i], scalar.val());
        return new VectorMember(result);
    }
}
