package abstractalgebra.reals;

import abstractalgebra.abstractions.GroupAssert;
import org.junit.Test;

public class RealTest {
    @Test public void formsGroupUnderAddition() {
        new GroupAssert<>(new RealAddition(), new RealGenerator()).assertIsGroup();
    }
    @Test public void formsGroupUnderMultiplication() {
        new GroupAssert<>(new RealMultiplication(), new RealGenerator()).assertIsGroup();
    }
}