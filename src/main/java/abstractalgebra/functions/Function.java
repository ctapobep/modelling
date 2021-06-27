package abstractalgebra.functions;

import abstractalgebra.abstractions.MagmaElement;

public interface Function<T, E extends MagmaElement<T>> {
    E get(E e);
}
