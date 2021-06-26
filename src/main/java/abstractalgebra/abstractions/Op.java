package abstractalgebra.abstractions;

public interface Op<T> {
    T calc(T o1, T o2);
    T identity();
}
