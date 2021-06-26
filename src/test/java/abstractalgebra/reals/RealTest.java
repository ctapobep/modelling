package abstractalgebra.reals;

import abstractalgebra.abstractions.GroupAssert;
import org.junit.Test;

public class RealTest {
    @Test public void formsAbelianGroupUnderAddition() {
        new GroupAssert<>(new RealAddition(), new RealGenerator()).assertIsAbelianGroup();
    }
    @Test public void formsAbelianGroupUnderMultiplication() {
        new GroupAssert<>(new RealMultiplication(), new RealGenerator()).assertIsAbelianGroup();
    }
}