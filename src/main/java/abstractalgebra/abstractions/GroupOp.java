package abstractalgebra.abstractions;

public interface GroupOp<T> {
    T calc(T o1, T o2);
    T identity();
    T inverse(T a);
}
