package realmatrix;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MatrixTest {

    @Test public void scalarMultiplicationMultipliesEveryEntry() {
        Matrix matrix = Matrix.fromColumns(new double[][]{{1, 0, 3}, {-2, 1.5, -1}}).multiply(2);
        assertEquals(new Vector(2, 0, 6), matrix.getColumn(0));
        assertEquals(new Vector(-4, 3, -2), matrix.getColumn(1));
    }
    @Test public void transposingTurnsRowsIntoColumns() {
        Matrix matrix = Matrix.fromColumns(new double[][]{{1, 0, 3}, {-2, 1.5F, -1}}).transpose();
        assertEquals(new Vector(1, 0, 3), matrix.getRow(0));
        assertEquals(new Vector(-2, 1.5F, -1), matrix.getRow(1));
    }
    @Test public void multiplyingByVectorIsSameAsMultiplying1ColumnMatrix() {
        Vector v = new Vector(-1, 0, 1, 0);
        Matrix matrix = Matrix.fromRows(new double[][]{{1, 2, 3, 4}, {5, 6, 7, 8}});
        assertEquals(Matrix.fromColumns(matrix.multiply(v)), matrix.multiply(Matrix.fromColumns(v)));
    }
    @Test public void matrixMultiplicationMultipliesColumnsOfRightMatrixByRowsOfLeftMatrix() {
        Matrix result = Matrix.fromRows(new double[][]{{1, 0, 3}, {-2, 1.5F, -1}})
                .multiply(Matrix.fromRows(new double[][]{{1, 0}, {-2, -1}, {3, 4}}));
        assertEquals(new Vector(10, 12), result.getRow(0));
        assertEquals(new Vector(-2-3-3, -1.5F-4), result.getRow(1));
    }
    @Test public void matrixCreatedFromColumnsIsTransposeOfTheOneCreatedFromRows() {
        Random r = new Random();
        double[][] data = {{r.nextDouble(), r.nextDouble()}, {r.nextDouble(), r.nextDouble()}, {r.nextDouble(), r.nextDouble()}};
        assertEquals(Matrix.fromColumns(data).transpose(), Matrix.fromRows(data));
    }
    @Test public void multiplyingByInverseYieldsIdentity() {
        Matrix identity = Matrix.identity(2);
        Matrix m1 = Matrix.fromRows(new double[][]{
                {20, 10},
                {15, 5}});
        Matrix inverse = Matrix.fromRows(new double[][]{
                {-1. / 10,  1. / 5},
                { 3. / 10, -2. / 5}});
        assertEquals(identity, m1.multiply(inverse));
    }
}