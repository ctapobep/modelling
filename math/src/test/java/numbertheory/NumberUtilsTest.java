package numbertheory;

import org.junit.Test;

import java.util.Map;

import static io.qala.datagen.RandomShortApi.integer;
import static numbertheory.NumberUtils.*;
import static org.junit.Assert.*;

public class NumberUtilsTest {

    @Test
    public void factorTest() {
        assertEquals(Map.of(1, 1), factor(1));
        assertEquals(Map.of(2, 1), factor(2));
        assertEquals(Map.of(3, 1), factor(3));
        assertEquals(Map.of(2, 2), factor(4));
        assertEquals(Map.of(5, 1), factor(5));
        assertEquals(Map.of(2, 1, 3, 1), factor(6));
        assertEquals(Map.of(7,1), factor(7));
        assertEquals(Map.of(2,3), factor(8));
        assertEquals(Map.of(3,2), factor(9));
        assertEquals(Map.of(2,1, 5,1), factor(10));
    }

    @Test
    public void primesTest() {
        assertArrayEquals(new int[]{1, 2, 3, 5, 7}, primes(10));
    }

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
    public void isPrimeTest() {
        assertTrue(isPrime(1));
        assertTrue(isPrime(2));
        assertTrue(isPrime(3));
        assertFalse(isPrime(4));
        assertTrue(isPrime(5));
        assertFalse(isPrime(6));
        assertTrue(isPrime(7));
        assertFalse(isPrime(8));
        assertFalse(isPrime(9));
        assertFalse(isPrime(10));
        assertTrue(isPrime(11));
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