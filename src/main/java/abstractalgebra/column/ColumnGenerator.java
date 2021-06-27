package abstractalgebra.column;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.abstractions.ValueGenerator;

import static io.qala.datagen.RandomShortApi.integer;

public class ColumnGenerator<T> implements ValueGenerator<FieldColumn<T>> {
    private final int dims = integer(0, 50);
    private final Field<T> field;
    private final ValueGenerator<T> fieldGenerator;

    public ColumnGenerator(Field<T> field, ValueGenerator<T> fieldGenerator) {
        this.field = field;
        this.fieldGenerator = fieldGenerator;
    }

    @Override public FieldColumn<T> generate() {
        FieldElement<T>[] reals = new FieldElement[dims];
        for (int i = 0; i < reals.length; i++)
            reals[i] = field.create(fieldGenerator.generate());
        return new FieldColumn<>(reals);
    }
    public int dims() {
        return dims;
    }
}
