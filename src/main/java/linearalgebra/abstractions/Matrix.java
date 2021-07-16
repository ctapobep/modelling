package linearalgebra.abstractions;

import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.reals.Real;
import linearalgebra.column.FieldColumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Matrix<F extends Real> {
    private final List<FieldColumn<F>> cols;
    private final Dims dims;

    @SafeVarargs
    public Matrix(FieldColumn<F> ... cols) {
        this(Arrays.asList(cols));
    }
    public Matrix(List<FieldColumn<F>> cols) {
        this.cols = cols;
        this.dims = new Dims(cols.size(), cols.get(0).dims());
    }

    public Matrix<F> t() {
        //noinspection unchecked
        FieldElement<F> [][]newCols = new FieldElement[dims.rows()][dims.cols()];
        for(int c = 0; c < dims.cols(); c++)
            for(int r = 0; r < dims.rows(); r++)
                newCols[r][c] = cols.get(c).get(r);
        List<FieldColumn<F>> result = new ArrayList<>();
        for (FieldElement<F>[] next : newCols)
            result.add(new FieldColumn<>(next));
        return new Matrix<>(result);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix<?> matrix = (Matrix<?>) o;
        return Objects.equals(cols, matrix.cols);
    }
}
