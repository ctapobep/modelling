package functions;

import abstractalgebra.reals.Real;

/**
 * Produces self-checking versions of the functions by wrapping them with assertions.
 */
public class Functions {
    public static SingleValuedFunction<Real, Real> sin() {
        return safe(new Sin());
    }
    public static SingleValuedFunction<Real, Real> cos() {
        return safe(new Cos());
    }

    private static <A, R> SingleValuedFunction<A, R> safe(SingleValuedFunction<A, R> f) {
        return new SelfCheckingSingleValuedFunction<>(f);
    }
}
