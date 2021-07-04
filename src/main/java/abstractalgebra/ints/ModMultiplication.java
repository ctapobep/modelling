package abstractalgebra.ints;

import abstractalgebra.abstractions.MonotypicalGroupOp;

public class ModMultiplication implements MonotypicalGroupOp<Int> {
    private final int module;
    private final ValueValidator<Integer> validator;

    public ModMultiplication(int module, ValueValidator<Integer> validator) {
        this.module = module;
        this.validator = validator;
    }

    public Int calc(Int o1, Int o2) {
        return new Int((o1.val() * o2.val()) % module, validator);
    }
    public Int identity() {
        return new Int(1, validator);
    }
    public Int inverse(Int a) {
        for (int i = 1; i < module; i++) // well, I'm not a very good mathematician as you can see..
            if((i * a.val()) % module == 1)
                return new Int(i);
        throw new IllegalArgumentException(a + " doesn't have a multiplicative inverse mod " + module);
    }
}
