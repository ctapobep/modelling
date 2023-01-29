package abstractalgebra.abstractions;

public interface BitypicalGroupOp<T1, T2> {
    T2 calcLeft(T1 o1, T2 o2);
    T2 calcRight(T2 o2, T1 o1);
}
