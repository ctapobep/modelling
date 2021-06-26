package abstractalgebra.vectors;

import abstractalgebra.abstractions.GroupAssert;
import org.junit.Test;

public class VectorTest {
    @Test public void formsGroupUnderAddition() {
        new GroupAssert<>(new VectorAddition(), new VectorGenerator());
    }
}
