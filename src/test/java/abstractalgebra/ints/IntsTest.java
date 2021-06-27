package abstractalgebra.ints;

import abstractalgebra.abstractions.Group;
import abstractalgebra.abstractions.GroupAssert2;
import org.junit.Test;

public class IntsTest {
    @Test public void formsAbelianGroupUnderAddition() {
        new GroupAssert2<>(new Group<>(new IntAddition()), new IntGenerator()).assertIsAbelianGroup();
    }
}