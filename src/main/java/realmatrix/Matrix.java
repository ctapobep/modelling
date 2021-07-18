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
    public static Matrix fromRows(double[][] entries) {
        return new Matrix(entries).transpose();
    }
    public static Matrix identity(int dims) {
        double[][] result = new double[dims][dims];
        for (int r = 0; r < dims; r++)
            result[r] = new double[dims];
        for (int i = 0; i < dims; i++)
            result[i][i] = 1;
        return Matrix.fromColumns(result);
    }
    public Matrix multiply(double scalar) {
        Vector[] newColumns = new Vector[columns.length];
        for(int col = 0; col < width; col++)
            newColumns[col] = columns[col].multiply(scalar);
        return new Matrix(newColumns);
    }
    public Vector multiply(Vector v) {
        if(this.width != v.dims())
            throw new IllegalArgumentException("Dimensions don't match: " +
                    "this.columns="+this.width + ", but vector size="+ v.dims());
        BigDecimal[] result = new BigDecimal[height];
        for(int i = 0; i < height; i++)
            result[i] = getRow(i).dot(v);
        return new Vector(result);
    }
    public Matrix multiply(Matrix rightMatrix) {
        if(this.width != rightMatrix.height)
            throw new IllegalArgumentException("Dimensions don't match: " +
                    "this.columns="+this+ ", but rightMatrix.height="+rightMatrix);
        Vector[] result = new Vector[rightMatrix.width];
        for(int col = 0; col < rightMatrix.width; col++)
            result[col] = multiply(rightMatrix.getColumn(col));
        return Matrix.fromColumns(result);
    }
    public Matrix transpose() {
        Vector[] rows = new Vector[this.height];
        for (int i = 0; i < this.height; i++)
            rows[i] = getRow(i);
        return Matrix.fromColumns(rows);
    }
    public Vector getRow(int rowIdx) {
        double [] row = new double[width];
        for(int i = 0; i < width; i++) row[i] = columns[i].getDouble(rowIdx);
        return new Vector(row);
    }
    public Vector getColumn(int colIdx) {
        return columns[colIdx];
    }
    public double get(int col, int row) {
        return columns[col].getDouble(row);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.equals(columns, matrix.columns);
    }

    public String toString() {
        StringBuilder result = new StringBuilder("Matrix ").append(height).append('x').append(width).append(":\n");
        for(int i = 0; i < height; i++) {
            for (Vector v : columns) result.append(' ').append(v.getDouble(i)).append(",\t");
            result.append('\n');
        }
        return result.toString();
    }
}
