package abstractalgebra.abstractions;

public interface RingOp<T> extends GroupOp<T> {
    T inverse(T a);
}
