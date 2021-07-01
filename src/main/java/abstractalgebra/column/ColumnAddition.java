package abstractalgebra.column;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.abstractions.MonotypicalGroupOp;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class ColumnAddition<T> implements MonotypicalGroupOp<FieldColumn<T>> {
    private final Field<T> field;
    private final int dims;

    public ColumnAddition(Field<T> field, int dims) {
        this.field = field;
        this.dims = dims;
    }
    public FieldColumn<T> calc(FieldColumn<T> o1, FieldColumn<T> o2) {
        if(o1.dims() != o2.dims())
            throw new IllegalArgumentException();
        FieldElement<T>[] result = new FieldElement[o2.dims()];
        for (int i = 0; i < result.length; i++)
            result[i] = o1.get(i).add(o2.get(i));
        return new FieldColumn<>(result);
    }
    public FieldColumn<T> identity() {
        FieldElement<T>[] r = new FieldElement[dims];
        Arrays.fill(r, field.additiveIdentity());
        return new FieldColumn<>(r);
    }
    public FieldColumn<T> inverse(FieldColumn<T> a) {
        FieldElement<T>[] result = new FieldElement[a.dims()];
        for (int i = 0; i < result.length; i++)
            result[i] = a.get(i).additiveInverse();
        return new FieldColumn<>(result);
    }
}
