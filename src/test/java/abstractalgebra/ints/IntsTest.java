package abstractalgebra.ints;

import org.junit.Test;

public class IntsTest {
    @Test public void formsCommutativeGroupUnderAddition() {
        Ints.additiveGroup();
    }
    @Test public void formsFiniteCommutativeGroupUnderAddition() {
        Ints.finiteAdditiveGroup();
    }
    @Test public void nonZeroIntsFormCommutativeGroupUnderMultiplication() {
        Ints.finiteMultiplicativeGroup();
    }
}