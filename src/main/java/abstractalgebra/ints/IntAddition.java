package abstractalgebra.ints;

import abstractalgebra.abstractions.MonotypicalGroupOp;

import java.math.BigInteger;

public class IntAddition implements MonotypicalGroupOp<Int> {
    private final ValueValidator<Integer> validator;

    public IntAddition(ValueValidator<Integer> validator) {
        this.validator = validator;
    }

    public Int calc(Int o1, Int o2) {
        return new Int(o1.v.add(o2.v), validator);
    }
    public Int identity() {
        return new Int(BigInteger.ZERO, validator);
    }
    public Int inverse(Int a) {
        return new Int(a.v.negate(), validator);
    }
}
