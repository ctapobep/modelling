package abstractalgebra.ints;

import abstractalgebra.abstractions.Group;
import abstractalgebra.abstractions.GroupAssert;
import org.junit.Test;

public class IntsTest {
    @Test public void formsAbelianGroupUnderAddition() {
        new GroupAssert<>(new Group<>(new IntAddition()), new IntGenerator()).assertIsAbelianGroup();
    }
}