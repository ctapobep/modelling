package abstractalgebra.ints;

import abstractalgebra.abstractions.MonotypicalGroupOp;

public class IntAddition implements MonotypicalGroupOp<Int> {
    private final ValueValidator<Integer> validator;

    public IntAddition(ValueValidator<Integer> validator) {
        this.validator = validator;
    }

    public Int calc(Int o1, Int o2) {
        return new Int(o1.val() + o2.val(), validator);
    }
    public Int identity() {
        return new Int(0, validator);
    }
    public Int inverse(Int a) {
        return new Int(-a.val(), validator);
    }
}
