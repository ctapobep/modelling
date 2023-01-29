package linearalgebra.functions;

import abstractalgebra.abstractions.MonotypicalGroupOp;

public class FunctionAddition implements MonotypicalGroupOp<Function> {
    public Function calc(Function o1, Function o2) {
        return new Add(o1, o2);
    }
    public Function identity() {
        return Constant.ZERO;
    }
    public Function inverse(Function a) {
        return new TimesMinusOne(a);
    }
}
