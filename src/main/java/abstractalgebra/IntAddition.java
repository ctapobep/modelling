package abstractalgebra;

import abstractalgebra.abstractions.Op;

public class IntAddition implements Op<Int> {

    @Override public Int calc(Int o1, Int o2) {
        return new Int(o1.val() + o2.val());
    }
    @Override public Int identity() {
        return Int.ZERO;
    }
}
