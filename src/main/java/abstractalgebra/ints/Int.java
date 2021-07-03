package abstractalgebra.ints;

public class Int {
    final int v;
    final ValueValidator<Integer> validator;

    public Int(int v) {
        this(v, new MinMaxValidator(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
    public Int(int v, ValueValidator<Integer> validator) {
        validator.assertValid(v);
        this.v = v;
        this.validator = validator;
    }
    int val() {
        return v;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Int anInt = (Int) o;
        return v == anInt.v;
    }
    public String toString() {
        return v + "";
    }
}
