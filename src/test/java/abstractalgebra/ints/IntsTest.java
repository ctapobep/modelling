package abstractalgebra.ints;

import abstractalgebra.abstractions.CommutativeGroup;
import org.junit.Test;

public class IntsTest {
    @Test public void formsCommutativeGroupUnderAddition() {
        IntGenerator intGenerator = new IntGenerator();
        new CommutativeGroup<>(new IntAddition(), intGenerator);
    }
}