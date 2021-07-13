package abstractalgebra.column;

import abstractalgebra.abstractions.BitypicalGroupOp;
import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;

import java.util.Arrays;

public class ColumnScalarMultiplication<T> implements BitypicalGroupOp<FieldElement<T>, FieldColumn<T>> {
    private final Field<T> field;
    private final int dims;

    public ColumnScalarMultiplication(Field<T> field, int dims) {
        this.field = field;
        this.dims = dims;
    }

    public FieldColumn<T> identity() {
        FieldElement<T>[] r = createEmptyArray(dims);
        Arrays.fill(r, field.multiplicativeIdentity());
        return new FieldColumn<>(r);
    }
    public FieldColumn<T> inverse(FieldColumn<T> a) {
        FieldElement<T>[] r = createEmptyArray(dims);
        for (int i = 0; i < r.length; i++)
            r[i] = field.multiplicativeInverse(a.get(i));
        return new FieldColumn<>(r);
    }

    public FieldColumn<T> calcLeft(FieldElement<T> o1, FieldColumn<T> o2) {
        return calc(o1, o2);
    }
    public FieldColumn<T> calcRight(FieldColumn<T> o2, FieldElement<T> o1) {
        return calc(o1, o2);
    }
    private FieldColumn<T> calc(FieldElement<T> o1, FieldColumn<T> o2) {
        FieldElement<T>[] result = createEmptyArray(o2.dims());
        for (int i = 0; i < o2.dims(); i++)
            result[i] = o1.multiply(o2.get(i));
        return new FieldColumn<>(result);
    }

    @SuppressWarnings("unchecked")
    private FieldElement<T>[] createEmptyArray(int dims) {
        return (FieldElement<T>[]) new FieldElement[dims];
    }
}
