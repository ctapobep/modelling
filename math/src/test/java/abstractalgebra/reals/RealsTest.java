package abstractalgebra.reals;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class RealsTest {
    @Test
    public void containsOnlyValuesInsideBoundaries() {
        Reals reals = new Reals(new Real(-1), new Real(1));
        assertTrue(reals.contains(new Real(-1)));
        assertTrue(reals.contains(Real.ONE));
        assertTrue(reals.contains(Real.ZERO));
        assertFalse(reals.contains(new Real(-1.000000001)));
        assertFalse(reals.contains(new Real(1.000000001)));
    }
    @Test
    public void doesNotContainExcludedValues() {
        Reals reals = new Reals(new Real(-1), new Real(1), Set.of(new Real(.5), Real.ZERO));
        assertFalse(reals.contains(new Real(.5)));
        assertFalse(reals.contains(new Real(0)));
    }
    @Test
    public void generatesOnlyValuesWithinBoundariesAndNotExcluded() {
        Reals reals = new Reals(
                new Real(-1), new Real(1), Set.of(new Real(-1), new Real(.5), Real.ZERO)
        );
        assertTrue(reals.contains(reals.random()));
    }
}