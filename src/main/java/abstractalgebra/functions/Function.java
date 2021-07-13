package abstractalgebra.functions;

import abstractalgebra.reals.Real;
import io.qala.datagen.RandomShortApi;

import static io.qala.datagen.RandomShortApi.Double;

public interface Function {
    Real get(Real x);

    default boolean equals(Function f) {
        return equal(this, f, 0) && equal(this, f, 1) && equal(this, f, -1) && equal(this, f, Double(-100, 100));
    }
    private static boolean equal(Function f1, Function f2, double x) {
        return f1.get(new Real(x)).equals(f2.get(new Real(x)));
    }
}
