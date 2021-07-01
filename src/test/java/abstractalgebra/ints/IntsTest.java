package abstractalgebra.ints;

import abstractalgebra.abstractions.Group;
import abstractalgebra.abstractions.GroupAssert;
import org.junit.Test;

public class IntsTest {
    @Test public void formsAbelianGroupUnderAddition() {
        IntGenerator intGenerator = new IntGenerator();
        new GroupAssert<>(new Group<>(new IntAddition(), intGenerator)).assertIsAbelianGroup();
    }
}