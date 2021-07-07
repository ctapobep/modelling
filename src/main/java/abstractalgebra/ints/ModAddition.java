package abstractalgebra.ints;

import abstractalgebra.abstractions.MonotypicalGroupOp;

import java.math.BigInteger;

public class ModAddition implements MonotypicalGroupOp<Int> {
    private final BigInteger module;
    private final ValueValidator<BigInteger> validator;

    public ModAddition(int module, ValueValidator<BigInteger> validator) {
        this.module = new BigInteger(module + "");
        this.validator = validator;
    }

    public Int calc(Int o1, Int o2) {
        return new Int(o1.v.add(o2.v).mod(module), validator);
    }
    public Int identity() {
        return new Int(BigInteger.ZERO, validator);
    }
    public Int inverse(Int a) {
        return new Int(module.subtract(a.v), validator);
    }
}
