package realmatrix;

import io.qala.datagen.RandomShortApi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

import static io.qala.datagen.RandomShortApi.integer;
import static io.qala.datagen.RandomShortApi.sample;

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
    public Vector add(Vector v) {
        BigDecimal[] result = new BigDecimal[dims()];
        for(int i = 0; i < entries.length; i++)
            result[i] = get(i).add(v.get(i));
        return new Vector(result);
    }
    public Vector times(double scalar) {
        return times(BigDecimal.valueOf(scalar));
    }
    public Vector times(BigDecimal scalar) {
        BigDecimal[] result = new BigDecimal[entries.length];
        for(int i = 0; i < entries.length; i++)
            result[i] = entries[i].multiply(scalar);
        return new Vector(result);
    }
    public Vector divide(BigDecimal scalar) {
        BigDecimal[] result = new BigDecimal[dims()];
        for(int i = 0; i < dims(); i++)
            result[i] = get(i).divide(scalar, MathContext.DECIMAL128);
        return new Vector(result);
    }
    public BigDecimal get(int n) {
        return entries[n];
    }

    public BigDecimal dot(Vector that) {
        if(this.dims() != that.dims())
            throw new IllegalArgumentException("Sizes didn't match: " + this.dims() + " and " + that.dims());
        BigDecimal result = BigDecimal.ZERO;
        for(int i = 0; i < dims(); i++)
            result = result.add(get(i).multiply(that.get(i)));
        return result;
    }
    public BigDecimal norm() {
        return this.dot(this).sqrt(MathContext.DECIMAL128);
    }
    public Vector toUnitVector() {
        return divide(norm());
    }
    public int dims() {
        return entries.length;
    }
    public boolean isZero() {
        return repeat(BigDecimal.ZERO, dims()).equals(this);
    }
    public static Vector repeat(BigDecimal value, int n) {
        BigDecimal[] vector = new BigDecimal[n];
        Arrays.fill(vector, value);
        return new Vector(vector);
    }

    public static Vector randomNonZero(int dims) {
        Vector v;
        do {
            v = random(dims);
        } while(v.isZero());
        return v;
    }
    public static Vector randomNonZero() {
        return randomNonZero(integer(1, 100));
    }
    public static Vector random() {
        return random(integer(1, 100));
    }
    public static Vector random(int dims) {
        BigDecimal[] result = new BigDecimal[dims];
        for (int i = 0; i < dims; i++)
            result[i] = BigDecimal.valueOf(sample(RandomShortApi.Double(-1000, 1000)));
        return new Vector(result);
    }
    public static Vector randomUnitVector(int dims) {
        Vector v = randomNonZero(dims);
        return v.divide(v.norm());
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        for (int i = 0; i < entries.length; i++)
            if(get(i).compareTo(vector.get(i)) != 0)
                return false;
        return true;
    }
    public String toString() {
        BigDecimal e = new BigDecimal("1e-6");
        float[] rounded = new float[entries.length];
        for (int i = 0; i < entries.length; i++)
            rounded[i] = entries[i].abs().compareTo(e) <= 0 ? 0F : entries[i].floatValue();
        StringBuilder sb = new StringBuilder();
        for (float v : rounded)
            sb.append(' ').append(v).append("\t");
        return sb.toString();
    }
}
