package realmatrix;

import java.math.BigDecimal;
import java.math.MathContext;

public class GaussianElimination {
    private final Vector[] rows;
    private final int height;

    public GaussianElimination(Vector[] rows) {
        this.rows = rows;
        this.height = rows.length;
    }

    public Matrix rref() {
        int currentRow = 0;

        int minPivotCol=-1, minPivotRowIdx = 0;
        for (int r = 0; r < height; r++) {
            int pivotCol = getPivotCol(r);
            if(pivotCol < minPivotCol) {
                minPivotCol = pivotCol;
                minPivotRowIdx = r;
            }
        }

        swap(currentRow, minPivotRowIdx);
        BigDecimal pivotValue = rows[currentRow].get(minPivotCol);
        Vector newRow = rows[currentRow].times(BigDecimal.ONE.divide(pivotValue, MathContext.UNLIMITED));
        return null;
    }

    private int getPivotCol(int row) {
        Vector r = rows[row];
        for (int c = 0; c < r.dims(); c++)
            if(r.get(c).compareTo(BigDecimal.ZERO) != 0)
                return c;
        return -1;
    }

    private void swap(int row1, int row2) {
        Vector tmp = rows[row1];
        rows[row1] = rows[row2];
        rows[row2] = tmp;
    }
}
