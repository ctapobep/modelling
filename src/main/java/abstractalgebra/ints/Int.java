package abstractalgebra.ints;

public class Int {
    public static final Int ZERO = new Int(0), ONE = new Int(1);
    private final int v;

    public Int(int v) {
        this.v = v;
    }
    public int val() {
        return v;
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Int anInt = (Int) o;
        return v == anInt.v;
    }
    @Override public String toString() {
        return v + "";
    }
}
