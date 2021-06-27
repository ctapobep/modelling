package abstractalgebra.column;

import abstractalgebra.abstractions.FieldElement;

import java.util.Arrays;

public class Column<T> {
    private final FieldElement<T>[] elements;

    public Column(FieldElement<T>[] elements) {
        this.elements = elements;
    }

    public FieldElement<T> get(int i) {
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
