package abstractalgebra.intsnonnegative;

import abstractalgebra.abstractions.CommutativeGroup;
import org.junit.Test;

public class NonNegativeIntTest {
    @Test public void modFormsCommutativeGroupUnderAddition() {
        NonNegativeIntGenerator generator = new NonNegativeIntGenerator();
        new CommutativeGroup<>(new ModAddition(generator.getModule()), generator);
    }
}