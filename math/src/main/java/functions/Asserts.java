package functions;

public class Asserts {
    @SafeVarargs
    public static <A, R> void assertHasProperties(SingleValuedFunction<A, R> f, SingleValuedProperty<A, R> ... props) {
        for (SingleValuedProperty<A, R> prop : props)
            prop.assertValid(f);
    }
}
