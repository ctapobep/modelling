package abstractalgebra.column;

import abstractalgebra.abstractions.BitypicalGroupOp;
import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;

import java.util.Arrays;

public class ColumnScalarMultiplication<T> implements BitypicalGroupOp<FieldElement<T>, Column<T>> {
    private final Field<T> field;
    private final int dims;

    public ColumnScalarMultiplication(Field<T> field, int dims) {
        this.field = field;
        this.dims = dims;
    }

    public Column<T> calcLeft(FieldElement<T> o1, Column<T> o2) {
        FieldElement<T>[] result = createEmptyArray(o2.dims());
        for (int i = 0; i < o2.dims(); i++)
            result[i] = o1.multiply(o2.get(i));
        return new Column<>(result);
    }

    public Column<T> identity() {
        FieldElement<T>[] r = createEmptyArray(dims);
        Arrays.fill(r, field.multiplicativeIdentity());
        return new Column<>(r);
    }
    public Column<T> inverse(Column<T> a) {
        FieldElement<T>[] r = createEmptyArray(dims);
        for (int i = 0; i < r.length; i++)
            r[i] = field.multiplicativeInverse(a.get(i));
        return new Column<>(r);
    }
    public Column<T> calc(FieldElement<T> scalar, Column<T> v) {
        return calcLeft(scalar, v);
    }
    @Override public Column<T> calcRight(Column<T> o2, FieldElement<T> o1) {
        return null;
    }
    @Override public FieldElement<T> identity1() {
        return null;
    }
    @Override public FieldElement<T> inverse1(FieldElement<T> a) {
        return null;
    }
    @Override public Column<T> identity2() {
        return null;
    }
    @Override public Column<T> inverse2(Column<T> a) {
        return null;
    }
    @SuppressWarnings("unchecked")
    private FieldElement<T>[] createEmptyArray(int dims) {
        return (FieldElement<T>[]) new FieldElement[dims];
    }
}
