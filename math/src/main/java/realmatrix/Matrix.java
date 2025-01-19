package realmatrix;

import java.math.BigDecimal;
import java.util.Arrays;

public class Matrix {
    private final Vector[] columns;
    private final int width, height;

    private Matrix(double[][] entries) {
        this.columns = new Vector[entries.length];
        this.width = entries.length;
        this.height = entries[0].length;
        for(int i = 0; i < width; i++)
            columns[i] = new Vector(entries[i]);
    }
    private Matrix(Vector[] columns) {
        this.columns = columns;
        this.width = columns.length;
        this.height = columns[0].dims();
    }
    public static Matrix fromColumns(double[][] entries) {
        return new Matrix(entries);
    }
    public static Matrix fromColumns(Vector... columns) {
        return new Matrix(columns);
    }
    public static Matrix fromRows(Vector... rows) {
        return new Matrix(rows).t();
    }
    public static Matrix fromRows(double[][] entries) {
        return new Matrix(entries).t();
    }
    public static Matrix identity(int dims) {
        double[][] result = new double[dims][dims];
        for (int r = 0; r < dims; r++)
            result[r] = new double[dims];
        for (int i = 0; i < dims; i++)
            result[i][i] = 1;
        return Matrix.fromColumns(result);
    }

    /**
     * For multiplication that looks like on paper (right to left). So that we don't have to nest multiplication calls.
     */
    public static Matrix times(Matrix ... matrices) {
        Matrix result = Matrix.identity(matrices[0].height);
        for (int i = matrices.length-1; i >= 0; i--)
            result = matrices[i].times(result);
        return result;
    }
    public Matrix times(double scalar) {
        Vector[] newColumns = new Vector[columns.length];
        for(int col = 0; col < width; col++)
            newColumns[col] = columns[col].times(scalar);
        return new Matrix(newColumns);
    }
    public Vector times(Vector v) {
        if(this.width != v.dims())
            throw new IllegalArgumentException("Dimensions don't match: " +
                    "this.columns="+this.width + ", but vector size="+ v.dims());
        BigDecimal[] result = new BigDecimal[height];
        for(int i = 0; i < height; i++)
            result[i] = getRow(i).dot(v);
        return new Vector(result);
    }
    public Matrix times(Matrix rightMatrix) {
        if(this.width != rightMatrix.height)
            throw new IllegalArgumentException("Dimensions don't match: " +
                    "this.columns="+this+ ", but rightMatrix.height="+rightMatrix);
        Vector[] result = new Vector[rightMatrix.width];
        for(int col = 0; col < rightMatrix.width; col++)
            result[col] = times(rightMatrix.getColumn(col));
        return Matrix.fromColumns(result);
    }

    /** transpose */
    public Matrix t() {
        Vector[] rows = getRows();
        return Matrix.fromColumns(rows);
    }
    public Matrix grammScmidt() {
        Vector[] result = new Vector[width];
        result[0] = getColumn(0);
        for (int c = 1; c < width; c++) {
            Vector curr = getColumn(c);
            for (int j = 0; j < c; j++)
                curr = curr.projectOn(getColumn(j));
            result[c] = curr;
        }
        return fromColumns(result);
    }
    public Vector getRow(int rowIdx) {
        BigDecimal [] row = new BigDecimal[width];
        for(int i = 0; i < width; i++)
            row[i] = columns[i].get(rowIdx);
        return new Vector(row);
    }
    public Matrix swap(int row1, int row2) {
        Vector[] rows = getRows();
        rows[row1] = getRow(row2);
        rows[row2] = getRow(row1);
        return Matrix.fromRows(rows);
    }

    public Matrix addRow(int rowToChange, int rowToAdd, double coeffToMultiply2ndRow) {
        Vector[] rows = getRows();
        rows[rowToChange] = rows[rowToChange].add(rows[rowToAdd].times(coeffToMultiply2ndRow));
        return fromRows(rows);
    }
    public Vector getColumn(int colIdx) {
        return columns[colIdx];
    }
    public BigDecimal get(int col, int row) {
        return columns[col].get(row);
    }

    public Matrix rref() {
        return new GaussianElimination(getRows()).rref();
    }

    public String dims() {
        return height + "x" + width;
    }
    public int height() {return height;}
    public int width() {return width;}

    private Vector[] getRows() {
        Vector[] rows = new Vector[height];
        for (int r = 0; r < height; r++)
            rows[r] = getRow(r);
        return rows;
    }
    private Vector[] getCols() {
        Vector[] rows = new Vector[width];
        System.arraycopy(this.columns, 0, rows, 0, width);
        return rows;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.equals(columns, matrix.columns);
    }

    public String toString() {
        int[] maxSymbolsInCol = new int[width];
        for (int c = 0; c < width; c++) {
            for (int r = 0; r < height; r++) {
                int currLen = (get(c, r) + "").length();
                maxSymbolsInCol[c] = Math.max(currLen, maxSymbolsInCol[c]);
            }
        }
        StringBuilder result = new StringBuilder("Matrix ").append(height).append('x').append(width).append(":\n");
        for(int i = 0; i < height; i++)
            result.append(getRow(i)).append('\n');
        return result.toString();
    }

}
