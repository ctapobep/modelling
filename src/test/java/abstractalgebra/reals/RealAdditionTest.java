package abstractalgebra.reals;

import abstractalgebra.abstractions.GroupAssert;
import org.junit.Test;

public class RealAdditionTest {
    @Test public void isGroup() {
        new GroupAssert<>(new RealAddition(), new RealGenerator()).assertIsGroup();
    }
}