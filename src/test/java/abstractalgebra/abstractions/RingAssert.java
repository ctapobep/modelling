package abstractalgebra.abstractions;

public class RingAssert<T, OP extends RingOp<T>> {
    private final ValueGenerator<T> generator;
    private final OP op;

    public RingAssert(ValueGenerator<T> generator, OP op) {
        this.generator = generator;
        this.op = op;
    }
    public void assertIsRing() {
//        new GroupAssert<ValueGenerator<T>, T>(generator, op).assertIsGroup();
    }
}
