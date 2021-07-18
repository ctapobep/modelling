package realmatrix;

import java.math.BigDecimal;
import java.util.Arrays;

public class Vector {
    private final BigDecimal[] entries;

    public Vector(double... entries) {
        this.entries = new BigDecimal[entries.length];
        for (int i = 0; i < entries.length; i++)
            this.entries[i] = BigDecimal.valueOf(entries[i]);
    }
    public Vector(BigDecimal[] entries) {
        this.entries = entries;
    }
    public Vector multiply(double scalar) {
        BigDecimal[] result = new BigDecimal[entries.length];
        for(int i = 0; i < entries.length; i++)
            result[i] = entries[i].multiply(BigDecimal.valueOf(scalar));
        return new Vector(result);
    }
    public BigDecimal get(int n) {
        return entries[n];
    }
    public double getDouble(int n) {
        return entries[n].doubleValue();
    }

    public double dot(Vector that) {
        if(this.size() != that.size())
            throw new IllegalArgumentException("Sizes didn't match: " + this.size() + " and " + that.size());
        double result = 0;
        for(int i = 0; i < size(); i++) result += this.getDouble(i) * that.getDouble(i);
        return result;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        for (int i = 0; i < entries.length; i++) {
            if(get(i).compareTo(vector.get(i)) != 0)
                return false;
        }
        return true;
    }
    public String toString() {
        return Arrays.toString(entries);
    }

    public int size() {
        return entries.length;
    }
}
