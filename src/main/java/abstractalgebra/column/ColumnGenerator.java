package abstractalgebra.column;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.abstractions.ValueGenerator;

import static io.qala.datagen.RandomShortApi.integer;

public class ColumnGenerator<T> implements ValueGenerator<FieldColumn<T>> {
    private final int dims = integer(0, 50);
    private final Field<T> field;

    public ColumnGenerator(Field<T> field) {
        this.field = field;
    }

    @Override public FieldColumn<T> random() {
        FieldElement<T>[] reals = new FieldElement[dims];
        for (int i = 0; i < reals.length; i++)
            reals[i] = field.random();
        return new FieldColumn<>(reals);
    }
    public int dims() {
        return dims;
    }
}
