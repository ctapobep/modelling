package abstractalgebra.ints;

import abstractalgebra.abstractions.MonotypicalGroupOp;

public class ModAddition implements MonotypicalGroupOp<Int> {
    private final int module;
    private final ValueValidator<Integer> validator;

    public ModAddition(int module, ValueValidator<Integer> validator) {
        this.module = module;
        this.validator = validator;
    }

    public Int calc(Int o1, Int o2) {
        return new Int((o1.val() + o2.val()) % module, validator);
    }
    public Int identity() {
        return new Int(0, validator);
    }
    public Int inverse(Int a) {
        return new Int(module - a.val(), validator);
    }
}
