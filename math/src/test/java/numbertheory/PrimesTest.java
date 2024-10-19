package numbertheory;

import org.junit.Test;

import java.util.Map;

import static numbertheory.NumberUtils.gcd;
import static numbertheory.Primes.*;
import static org.junit.Assert.*;

@SuppressWarnings("NonAsciiCharacters")
public class PrimesTest {
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
        assertArrayEquals(new int[]{1}, primes(1));
        assertArrayEquals(new int[]{1, 2}, primes(2));
        assertArrayEquals(new int[]{1, 2, 3, 5, 7}, primes(10));
    }
    @Test
    public void piTest() {
        assertEquals(1, π(1));
        assertEquals(2, π(2));
        assertEquals(3, π(3));
        assertEquals(3, π(4));
        assertEquals(4, π(5));
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
    public void randomPrimeIsPrime(){
        assertTrue(isPrime(Primes.random()));
    }

    @Test
    public void randomCoprimesHaveGcd1(){
        int[] coprimes = randomCoprimes(2);
        assertEquals(1, gcd(coprimes[0], coprimes[1]));
    }
}