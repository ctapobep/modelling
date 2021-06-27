package abstractalgebra.column;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldMember;
import abstractalgebra.abstractions.ValueGenerator;

import static io.qala.datagen.RandomShortApi.integer;

public class ColumnGenerator<T> implements ValueGenerator<Column<T>> {
    private final int dims = integer(0, 50);
    private final Field<T> field;
    private final ValueGenerator<T> fieldGenerator;

    public ColumnGenerator(Field<T> field, ValueGenerator<T> fieldGenerator) {
        this.field = field;
        this.fieldGenerator = fieldGenerator;
    }

    @Override public Column<T> generate() {
        FieldMember<T>[] reals = new FieldMember[dims];
        for (int i = 0; i < reals.length; i++)
            reals[i] = field.create(fieldGenerator.generate());
        return new Column<>(reals);
    }
    public int getDims() {
        return dims;
    }
}
