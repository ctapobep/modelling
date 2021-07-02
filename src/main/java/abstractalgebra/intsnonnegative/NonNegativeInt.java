package abstractalgebra.intsnonnegative;

public class NonNegativeInt {
    public static final NonNegativeInt ZERO = new NonNegativeInt(0), ONE = new NonNegativeInt(1);
    private final int v;

    public NonNegativeInt(int v) {
        if(v < 0)
            throw new IllegalArgumentException("Can't be negative: " + v);
        this.v = v;
    }

    int val() {
        return v;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NonNegativeInt that = (NonNegativeInt) o;
        return v == that.v;
    }
    public String toString() {
        return String.valueOf(v);
    }
}
