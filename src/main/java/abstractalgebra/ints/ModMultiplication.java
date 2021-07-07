package abstractalgebra.ints;

import abstractalgebra.abstractions.MonotypicalGroupOp;

import java.math.BigInteger;

public class ModMultiplication implements MonotypicalGroupOp<Int> {
    private final BigInteger module;
    private final ValueValidator<Integer> validator;

    public ModMultiplication(int module, ValueValidator<Integer> validator) {
        this.module = BigInteger.valueOf(module);
        this.validator = validator;
    }

    public Int calc(Int o1, Int o2) {
        return new Int(o1.v.multiply(o2.v).mod(module), validator);
    }
    public Int identity() {
        return new Int(1, validator);
    }
    public Int inverse(Int a) {
        for (BigInteger i = BigInteger.ONE; i.compareTo(module) < 0; i = i.add(BigInteger.ONE)) // well, I'm not a very good mathematician as you can see..
            if(a.v.multiply(i).mod(module).equals(BigInteger.ONE))
                return new Int(i);
        throw new IllegalArgumentException(a + " doesn't have a multiplicative inverse mod " + module);
    }
}
