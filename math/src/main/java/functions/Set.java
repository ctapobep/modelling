package functions;

import abstractalgebra.abstractions.ValueGenerator;

public interface Set<T> extends ValueGenerator<T> {
    boolean contains(T v);
}
