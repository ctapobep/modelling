package linearalgebra.abstractions;

import abstractalgebra.reals.Real;

public class SymmetricMatrix<F extends Real> implements Matrix<F> {
    private final AnyMatrix<F> matrix;

    public SymmetricMatrix(AnyMatrix<F> matrix) {
        this.matrix = matrix;
    }

    public Matrix<F> t() {
        return this;
    }
}
