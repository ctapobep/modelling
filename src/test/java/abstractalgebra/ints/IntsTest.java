package abstractalgebra.ints;

import abstractalgebra.abstractions.GroupAssert;
import org.junit.Test;

public class IntsTest {
    @Test public void formsAbelianGroupUnderAddition() {
        new GroupAssert<>(new IntAddition(), new IntGenerator()).assertIsAbelianGroup();
    }
}