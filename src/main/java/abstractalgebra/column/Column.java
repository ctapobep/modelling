package abstractalgebra.column;

import abstractalgebra.abstractions.FieldMember;

import java.util.Arrays;

public class Column<T> {
    private final FieldMember<T>[] elements;

    public Column(FieldMember<T>[] elements) {
        this.elements = elements;
    }

    public FieldMember<T> get(int i) {
        return elements[i];
    }

    public int dims() {
        return elements.length;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Column<?> column = (Column<?>) o;
        return Arrays.equals(elements, column.elements);
    }
    public String toString() {
        return Arrays.toString(elements);
    }
}
