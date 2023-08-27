package functions;

import abstractalgebra.reals.Real;
import abstractalgebra.reals.Reals;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SinTest {
    @Test
    public void acceptRealsAndProducesOnlyValuesWithinRange() {
        Sin sin = new Sin();
        Set<Real> reals = new Reals();
        Real result = sin.apply(reals.random());
        assertTrue(reals.contains(result));
    }
}