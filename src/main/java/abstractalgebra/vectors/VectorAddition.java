package abstractalgebra.vectors;

import abstractalgebra.abstractions.GroupOp;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealAddition;

public class VectorAddition implements GroupOp<Vector> {
    public Vector calc(Vector o1, Vector o2) {
        if(o1.dims() != o2.dims())
            throw new IllegalArgumentException();
        Real[] result = new Real[o1.dims()];
        for (int i = 0; i < result.length; i++)
            result[i] = new RealAddition().calc(o1.val()[i], o2.val()[i]);
        return new Vector(result);
    }
    public Vector identity() {
        return null;
    }
    public Vector inverse(Vector a) {
        return null;
    }
}
