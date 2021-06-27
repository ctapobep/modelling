package abstractalgebra.column;

import abstractalgebra.abstractions.MonotypicalGroupOp;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealAddition;

import java.util.Arrays;

public class VectorAddition implements MonotypicalGroupOp<VectorMember> {
    private final int dims;

    public VectorAddition(int dims) {
        this.dims = dims;
    }
    public VectorMember calc(VectorMember o1, VectorMember o2) {
        if(o1.dims() != o2.dims())
            throw new IllegalArgumentException();
        Real[] result = new Real[o1.dims()];
        for (int i = 0; i < result.length; i++)
            result[i] = new RealAddition().calc(o1.val()[i], o2.val()[i]);
        return new VectorMember(result);
    }
    public VectorMember identity() {
        Real[] r = new Real[dims];
        Arrays.fill(r, Real.ZERO);
        return new VectorMember(r);
    }
    public VectorMember inverse(VectorMember a) {
        Real[] result = new Real[a.dims()];
        for (int i = 0; i < result.length; i++)
            result[i] = new RealAddition().inverse(a.val()[i]);
        return new VectorMember(result);
    }
}
