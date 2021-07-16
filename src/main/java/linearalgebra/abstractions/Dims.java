package linearalgebra.abstractions;

public class Dims {
    private final int cols, rows;

    public Dims(int col, int rows) {
        this.cols = col;
        this.rows = rows;
    }

    public int cols() {
        return cols;
    }
    public int rows() {
        return rows;
    }

    public Dims t() {
        return new Dims(rows, cols);
    }
}
