package abstractalgebra.ints;

import java.math.BigInteger;

public class Int {
    final BigInteger v;
    final ValueValidator<BigInteger> validator;

    public Int(int v, ValueValidator<BigInteger> validator) {
        this.v = BigInteger.valueOf(v);
        validator.assertValid(this.v);
        this.validator = validator;
    }
    public Int(BigInteger v) {
        this(v, new MinMaxValidator(Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
    public Int(BigInteger v, ValueValidator<BigInteger> validator) {
        validator.assertValid(v);
        this.v = new BigInteger(v + "");
        this.validator = validator;
    }
    int val() {
        return v.intValueExact();
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Int anInt = (Int) o;
        return v.equals(anInt.v);
    }
    public String toString() {
        return v.toString();
    }
}
