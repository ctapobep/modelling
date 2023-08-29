package functions;

public class SelfCheckingSingleValuedFunction<A, R> implements SingleValuedFunction<A, R> {
    private final SingleValuedFunction<A, R> target;

    public SelfCheckingSingleValuedFunction(SingleValuedFunction<A, R> target) {
        this.target = target;
    }

    public R apply(A arg) {
        assertArgumentIsInDomain(arg);
        R result = target.apply(arg);
        assertResultIsInRange(result);
        return result;
    }
    public Set<A> domain() {
        return target.domain();
    }
    public Set<R> range() {
        return target.range();
    }

    private void assertResultIsInRange(R result) {
        if(!range().contains(result))
            throw new IllegalStateException(
                    "Bug! The function produced the result which is outside of its domain: " + result
            );
    }
    private void assertArgumentIsInDomain(A arg) {
        if(!domain().contains(arg))
            throw new IllegalArgumentException(arg + " isn't in the domain!");
    }
}
