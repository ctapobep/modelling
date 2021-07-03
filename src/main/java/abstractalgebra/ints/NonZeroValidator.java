package abstractalgebra.ints;

public class NonZeroValidator implements ValueValidator<Integer> {
    @Override public void assertValid(Integer integer) {
        if(integer == 0)
            throw new IllegalArgumentException("Can't be 0!");
    }
}
