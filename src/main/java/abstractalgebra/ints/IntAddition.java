package abstractalgebra.ints;

import abstractalgebra.abstractions.RingOp;

public class IntAddition implements RingOp<Int> {

    public Int calc(Int o1, Int o2) {
        return new Int(o1.val() + o2.val());
    }
    public Int identity() {
        return Int.ZERO;
    }
    public Int inverse(Int a) {
        return new Int(-a.val());
    }
}
