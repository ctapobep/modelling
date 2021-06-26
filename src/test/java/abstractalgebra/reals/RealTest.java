package abstractalgebra.reals;

import abstractalgebra.abstractions.GroupAssert;
import abstractalgebra.abstractions.RingAssert;
import org.junit.Test;

public class RealTest {
    @Test public void formsAbelianGroupUnderAddition() {
        new GroupAssert<>(new RealAddition(), new RealGenerator()).assertIsAbelianGroup();
    }
    @Test public void formsAbelianGroupUnderMultiplication() {
        new GroupAssert<>(new RealMultiplication(), new RealGenerator()).assertIsAbelianGroup();
    }
    @Test public void formsRingUnderAdditionAndMultiplication() {
        new RingAssert<>(new RealAddition(), new RealMultiplication(), new RealGenerator()).assertIsRing();
    }
    @Test public void formsFieldUnderAdditionAndMultiplication() {
        new RingAssert<>(new RealAddition(), new RealMultiplication(), new RealGenerator()).assertIsRing();
    }
}