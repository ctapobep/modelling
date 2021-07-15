package abstractalgebra.abstractions;

import abstractalgebra.reals.Real;

/**
 * https://en.wikipedia.org/wiki/Inner_product_space
 * @param <S> scalar type
 * @param <V> vector type
 */
public interface InnerProductVector<S extends Real, V> {
    FieldElement<S> innerProduct(VectorElement<S, V> v);
}
