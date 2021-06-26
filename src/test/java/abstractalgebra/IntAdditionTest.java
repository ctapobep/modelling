package abstractalgebra;

import abstractalgebra.abstractions.GroupAssert;
import org.junit.Test;

public class IntAdditionTest {
    @Test public void isGroup() {
        new GroupAssert<>(new IntAddition(), new IntGenerator()).assertIsGroup();
    }
}