package abstractalgebra.abstractions;

public interface BitypicalGroupOp<T1, T2> {
    T2 calcLeft(T1 o1, T2 o2);
    T2 calcRight(T2 o2, T1 o1);

    T1 identity1();
    T1 inverse1(T1 a);

    T2 identity2();
    T2 inverse2(T2 a);
}
