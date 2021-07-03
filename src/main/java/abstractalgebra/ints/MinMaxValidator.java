package abstractalgebra.ints;

public class MinMaxValidator implements ValueValidator<Integer> {
    private final int min, max;
    public MinMaxValidator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override public void assertValid(Integer v) {
        if(v < min || v > max)
            throw new IllegalArgumentException("Value " + v + " isn't within boundaries: [" + min + "," + max + "]");
    }
}
