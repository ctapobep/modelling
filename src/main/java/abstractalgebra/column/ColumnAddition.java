package abstractalgebra.column;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldMember;
import abstractalgebra.abstractions.MonotypicalGroupOp;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class ColumnAddition<T> implements MonotypicalGroupOp<Column<T>> {
    private final Field<T> field;
    private final int dims;

    public ColumnAddition(Field<T> field, int dims) {
        this.field = field;
        this.dims = dims;
    }
    public Column<T> calc(Column<T> o1, Column<T> o2) {
        if(o1.dims() != o2.dims())
            throw new IllegalArgumentException();
        FieldMember<T>[] result = new FieldMember[o2.dims()];
        for (int i = 0; i < result.length; i++)
            result[i] = o1.get(i).add(o2.get(i));
        return new Column<>(result);
    }
    public Column<T> identity() {
        FieldMember<T>[] r = new FieldMember[dims];
        Arrays.fill(r, field.additiveIdentity());
        return new Column<>(r);
    }
    public Column<T> inverse(Column<T> a) {
        FieldMember<T>[] result = new FieldMember[a.dims()];
        for (int i = 0; i < result.length; i++)
            result[i] = field.create(field.toRing().toAdditiveGroup().getOp().inverse(a.get(i).val()));
        return new Column<>(result);
    }
}
