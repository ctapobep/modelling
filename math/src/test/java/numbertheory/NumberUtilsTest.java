package numbertheory;

import org.junit.Test;

import java.util.Map;

import static io.qala.datagen.RandomShortApi.integer;
import static numbertheory.NumberUtils.*;
import static org.junit.Assert.*;

public class NumberUtilsTest {

    @Test
    public void modForPositiveIsSameAsJavaImplementation() {
        int x = integer(0, Integer.MAX_VALUE);
        int m = integer(1, Integer.MAX_VALUE);
        assertEquals(x%m, mod(x, m));
    }
    @Test
    public void modForNegative() {
        assertEquals(4, mod(-1, 5));
    }


    @Test
    public void gcdTest() {
        assertEquals(1, gcd(1, 1));
        assertEquals(1, gcd(1, 2));
        assertEquals(2, gcd(2, 2));
        assertEquals(4, gcd(4, 8));
        assertEquals(1, gcd(4, 11));
        assertEquals(2, gcd(6, 20));
    }

    @Test
    public void lcmTest() {
        assertEquals(1, lcm(1, 1));
        assertEquals(2, lcm(1, 2));
        assertEquals(2, lcm(2, 2));
        assertEquals(8, lcm(4, 8));
        assertEquals(44, lcm(4, 11));
        assertEquals(60, lcm(6, 20));
    }
}