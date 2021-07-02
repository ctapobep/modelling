package abstractalgebra.intsnonnegative;

import abstractalgebra.abstractions.MonotypicalGroupOp;

public class ModAddition implements MonotypicalGroupOp<NonNegativeInt> {
    private final NonNegativeInt module;

    public ModAddition(NonNegativeInt module) {
        this.module = module;
    }

    public NonNegativeInt calc(NonNegativeInt o1, NonNegativeInt o2) {
        return new NonNegativeInt((o1.val() + o2.val()) % module.val());
    }
    public NonNegativeInt identity() {
        return NonNegativeInt.ZERO;
    }
    public NonNegativeInt inverse(NonNegativeInt a) {
        return new NonNegativeInt(module.val() -a.val());
    }
}
