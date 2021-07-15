package abstractalgebra.abstractions;

import abstractalgebra.reals.Real;

public interface InnerProduct<S extends Real, V> {
    FieldElement<S> calc(V v1, V v2);
}
