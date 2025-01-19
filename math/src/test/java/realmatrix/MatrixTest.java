package realmatrix;

import org.junit.Test;

import java.util.Random;

import static io.qala.datagen.RandomShortApi.Double;
import static io.qala.datagen.RandomShortApi.integer;
import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;
import static realmatrix.Matrix.fromRows;
import static realmatrix.Matrix.identity;
import static realmatrix.RealMatrixAssert.assertMatrixEquals;

public class MatrixTest {

    @Test public void scalarMultiplicationMultipliesEveryEntry() {
        Matrix matrix = Matrix.fromColumns(new double[][]{{1, 0, 3}, {-2, 1.5, -1}}).times(2);
        assertEquals(new Vector(2, 0, 6), matrix.getColumn(0));
        assertEquals(new Vector(-4, 3, -2), matrix.getColumn(1));
    }
    @Test public void transposingTurnsRowsIntoColumns() {
        Matrix matrix = Matrix.fromColumns(new double[][]{{1, 0, 3}, {-2, 1.5F, -1}}).t();
        assertEquals(new Vector(1, 0, 3), matrix.getRow(0));
        assertEquals(new Vector(-2, 1.5F, -1), matrix.getRow(1));
    }
    @Test public void multiplyingByVectorIsSameAsMultiplying1ColumnMatrix() {
        Vector v = new Vector(-1, 0, 1, 0);
        Matrix matrix = fromRows(new double[][]{{1, 2, 3, 4}, {5, 6, 7, 8}});
        assertEquals(Matrix.fromColumns(matrix.times(v)), matrix.times(Matrix.fromColumns(v)));
    }
    @Test public void matrixMultiplicationMultipliesColumnsOfRightMatrixByRowsOfLeftMatrix() {
        Matrix result = fromRows(new double[][]{{1, 0, 3}, {-2, 1.5F, -1}})
                .times(fromRows(new double[][]{{1, 0}, {-2, -1}, {3, 4}}));
        assertEquals(new Vector(10, 12), result.getRow(0));
        assertEquals(new Vector(-2-3-3, -1.5F-4), result.getRow(1));
    }
    @Test public void matrixCreatedFromColumnsIsTransposeOfTheOneCreatedFromRows() {
        Random r = new Random();
        double[][] data = {{r.nextDouble(), r.nextDouble()}, {r.nextDouble(), r.nextDouble()}, {r.nextDouble(), r.nextDouble()}};
        assertEquals(Matrix.fromColumns(data).t(), fromRows(data));
    }
    @Test public void multiplyingByInverseYieldsIdentity() {
        Matrix identity = identity(2);
        Matrix m1 = fromRows(new double[][]{
                {20, 10},
                {15, 5}});
        Matrix inverse = fromRows(new double[][]{
                {-1. / 10,  1. / 5},
                { 3. / 10, -2. / 5}});
        assertEquals(identity, m1.times(inverse));
    }
    @Test public void canSwapRows() {
        Matrix m1 = fromRows(new double[][]{
                {20, 10},
                {10, 10},
                {15, 5}});
        Matrix expected = fromRows(new double[][]{
                {15, 5},
                {10, 10},
                {20, 10}});
        assertEquals(expected, m1.swap(0, 2));
    }
    @Test public void canAddRows() {
        Matrix m1 = fromRows(new double[][]{
                {20, 10},
                {10, 10},
                {15, 5}});
        Matrix expected = fromRows(new double[][]{
                {20, 10},
                { 0, 5},
                {15, 5}});
        assertEquals(expected, m1.addRow(1, 0, -.5));
    }

    @Test public void grammSchmidt_doesNothingToDiagonalMatrices() {
        int dims = integer(1, 5);
        double scalar = Double(-5, 5);
        assertMatrixEquals(identity(dims).times(scalar), identity(dims).times(scalar).grammScmidt());
    }
    @Test public void grammSchmidt_doesNothingToOrthogonalMatrices() {
        Matrix m = fromRows(new double[][]{
                {1, 2},
                {-2, 1}
        }).times(Double(-5, 5));
        assertMatrixEquals(m, m.grammScmidt());
    }
    @Test public void grammSchmidt_orthogonizesMatrixColumns() {
        assertMatrixEquals(
                fromRows(new double[][]{
                        {1, 1 - 1. / sqrt(2)},
                        {0, -1. / sqrt(2)}}),
                fromRows(new double[][]{
                        {1, 1},
                        {0, 1}
                }).grammScmidt());
    }
}