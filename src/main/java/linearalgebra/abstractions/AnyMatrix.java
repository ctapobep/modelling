package linearalgebra.abstractions;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.reals.Real;
import abstractalgebra.reals.RealField;
import linearalgebra.column.FieldColumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnyMatrix<F extends Real> implements Matrix<F> {
    private final List<FieldColumn<F>> cols;
    private final Dims dims;

    public AnyMatrix(List<FieldColumn<F>> cols) {
        this.cols = cols;
        this.dims = new Dims(cols.size(), cols.get(0).dims());
    }

    public static AnyMatrix<Real> rows(double[][] cols) {
        Field<Real> reals = RealField.create();
        FieldElement<Real> [][]newCols = new FieldElement[cols.length][cols[0].length];
        for (int r = 0; r < cols.length; r++)
            for (int c = 0; c < cols[r].length; c++)
                newCols[c][r] = reals.create(new Real(cols[c][r]));
        return matrixFromCols(newCols);
    }

    public AnyMatrix<F> t() {
        List<FieldColumn<F>> newCols = new ArrayList<>();
        for (int r = 0; r < dims.rows(); r++)
            newCols.add(row(r));
        return new AnyMatrix<>(newCols);
    }
    public FieldColumn<F> row(int r) {
        //noinspection unchecked
        FieldElement<F> []col = new FieldElement[dims.cols()];
        for (int c = 0; c < cols.size(); c++)
            col[c] = cols.get(c).get(r);
        return new FieldColumn<>(col);
    }
    public FieldColumn<F> col(int c) {
        return cols.get(c);
    }

    private static <F extends Real> AnyMatrix<F> matrixFromCols(FieldElement<F>[][] newCols) {
        List<FieldColumn<F>> result = new ArrayList<>();
        for (FieldElement<F>[] next : newCols)
            result.add(new FieldColumn<>(next));
        return new AnyMatrix<>(result);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnyMatrix<?> matrix = (AnyMatrix<?>) o;
        return Objects.equals(cols, matrix.cols);
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int r = 0; r < dims.rows(); r++) {
            for (int c = 0; c < dims.cols(); c++)
                s.append(String.format("%5s", cols.get(c).get(r))).append('\t');
            s.append('\n');
        }
        return s.toString();
    }
}
