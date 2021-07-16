package linearalgebra.abstractions;


import abstractalgebra.reals.Real;

public interface Matrix<T extends Real> {
    Matrix<T> t();
}
