package linearalgebra.functions;

import abstractalgebra.reals.Real;

import static io.qala.datagen.RandomShortApi.Double;

/**
 * We need {@link #equals(Object)} for all functions and it can't be defined in the interface, so had
 * to create this hack instead. Otherwise would have to declare {@link #equals(Object)} in every implementation
 * which would be error-prone.
 */
abstract class ComparableFunction implements Function {
    public boolean equals(Object o) {
        if(!(o instanceof ComparableFunction))
            return false;
        Function f = (Function) o;
        return equal(this, f, 0) && equal(this, f, 1) && equal(this, f, -1) && equal(this, f, Double(-100, 100));
    }
    private static boolean equal(Function f1, Function f2, double x) {
        return f1.get(new Real(x)).equals(f2.get(new Real(x)));
    }
}
