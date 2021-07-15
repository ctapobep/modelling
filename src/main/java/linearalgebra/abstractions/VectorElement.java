package linearalgebra.abstractions;

import abstractalgebra.abstractions.BitypicalGroupOp;
import abstractalgebra.abstractions.FieldElement;
import abstractalgebra.abstractions.MagmaElement;
import abstractalgebra.abstractions.MonotypicalGroupOp;
import abstractalgebra.reals.Real;

public class VectorElement<S extends Real, V> implements MagmaElement, InnerProductVector<S, V> {
    private final V value;
    private final MonotypicalGroupOp<V> vectorAddition;
    private final BitypicalGroupOp<FieldElement<S>, V> scalarMultiplication;
    private final InnerProduct<S, V> innerProduct;

    public VectorElement(V value, MonotypicalGroupOp<V> vectorAddition,
                         BitypicalGroupOp<FieldElement<S>, V> scalarMultiplication, InnerProduct<S, V> innerProduct) {
        this.value = value;
        this.vectorAddition = vectorAddition;
        this.scalarMultiplication = scalarMultiplication;
        this.innerProduct = innerProduct;
    }

    public VectorElement<S, V> add(VectorElement<S, V> v) {
        return createAnother(vectorAddition.calc(this.value, v.value));
    }
    public VectorElement<S, V> multiply(FieldElement<S> scalar) {
        return createAnother(scalarMultiplication.calcRight(this.value, scalar));
    }
    public FieldElement<S> innerProduct(VectorElement<S, V> v) {
        return innerProduct.calc(value, v.value);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VectorElement<?, ?> that = (VectorElement<?, ?>) o;
        return value.equals(that.value)
               && vectorAddition.equals(that.vectorAddition)
               && scalarMultiplication.equals(that.scalarMultiplication)
               && innerProduct.equals(that.innerProduct);
    }
    public String toString() {
        return value.toString();
    }
    private VectorElement<S, V> createAnother(V v) {
        return new VectorElement<>(v, vectorAddition, scalarMultiplication, innerProduct);
    }
}
