package abstractalgebra.vectors;

import abstractalgebra.abstractions.GroupAssert;
import org.junit.Test;

public class VectorTest {
    @Test public void formsGroupUnderAddition() {
        VectorGenerator generator = new VectorGenerator();
        new GroupAssert<>(new VectorAddition(generator.getDims()), generator).assertIsAbelianGroup();
    }
}
