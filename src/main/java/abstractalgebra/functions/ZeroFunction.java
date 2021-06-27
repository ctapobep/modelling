package abstractalgebra.functions;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldElement;

public class ZeroFunction<T> implements Function<T, FieldElement<T>>{
    private final Field<T> field;

    public ZeroFunction(Field<T> field) {
        this.field = field;
    }

    public FieldElement<T> get(FieldElement<T> realFieldElement) {
        return field.multiplicativeIdentity();
    }
}
