package abstractalgebra.functions;

import abstractalgebra.abstractions.MagmaElement;

public interface Function<T, E extends MagmaElement> {
    E get(E e);
}
