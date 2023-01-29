package linearalgebra.column;

import abstractalgebra.abstractions.FieldElement;

import java.util.Arrays;

public class FieldColumn<T> {
    private final FieldElement<T>[] elements;

    @SafeVarargs
    public FieldColumn(FieldElement<T> ... elements) {
        this.elements = elements;
    }
//    public FieldColumn(FieldElement<T>[] elements) {
//        this.elements = elements;
//    }

    public FieldElement<T> get(int i) {
        return elements[i];
    }

    public int dims() {
        return elements.length;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldColumn<?> column = (FieldColumn<?>) o;
        return Arrays.equals(elements, column.elements);
    }
    public String toString() {
        return Arrays.toString(elements);
    }
}
