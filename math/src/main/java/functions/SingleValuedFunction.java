package functions;

public interface SingleValuedFunction<A, R> {
    R apply(A arg);

    Set<A> domain();
    Set<R> range();
}
