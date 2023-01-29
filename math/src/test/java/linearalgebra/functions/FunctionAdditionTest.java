package linearalgebra.functions;

import abstractalgebra.reals.Real;
import org.junit.Test;

import static org.junit.Assert.*;

public class FunctionAdditionTest {
    @Test public void canAddFunctions() {
        assertEquals(new Real(0), new FunctionAddition().calc(new Sin(), new Sin()).get(new Real(0)));
        assertEquals(new Real(2), new FunctionAddition().calc(new Sin(), new Sin()).get(new Real(Math.PI/2)));
        assertEquals(new Real(1), new FunctionAddition().calc(new Sin(), Constant.ZERO).get(new Real(Math.PI / 2)));
    }
}