package abstractalgebra;

import abstractalgebra.abstractions.GroupTester;
import org.junit.Test;

public class IntAdditionTest {
    @Test public void isGroup() {
        new GroupTester<>(new IntAddition(), new IntGenerator()).assertIsGroup();
    }
}