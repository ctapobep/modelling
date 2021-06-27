package abstractalgebra.abstractions;

public interface MonotypicalGroupOp<T> {
    T calc(T o1, T o2);
    T identity();
    T inverse(T a);
}
