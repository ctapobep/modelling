package linearalgebra.functions;

import abstractalgebra.reals.Real;

/**
 * Should probably be deprecated in favour of {@link functions.SingleValuedFunction}.
 */
public interface Function {
    Real get(Real x);
}
