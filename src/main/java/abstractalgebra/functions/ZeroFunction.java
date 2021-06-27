package abstractalgebra.functions;

import abstractalgebra.abstractions.Field;
import abstractalgebra.abstractions.FieldMember;

public class ZeroFunction<T> implements Function<T, FieldMember<T>>{
    private final Field<T> field;

    public ZeroFunction(Field<T> field) {
        this.field = field;
    }

    public FieldMember<T> get(FieldMember<T> realFieldMember) {
        return field.multiplicativeIdentity();
    }
}
