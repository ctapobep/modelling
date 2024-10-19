package numbertheory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NumberUtils {

    /**
     * Aka prime factorization or prime decomposition
     */
    public static Map<Integer, Integer> factor(int n) {
        assertNatural(n);
        int v = n;
        Map<Integer/*divisor*/, Integer/*power*/> divisors = new LinkedHashMap<>();
        for(int i = 2; i <= n; i++) {
            while (isDivisible(v, i)) {
                v /= i;
                int power = divisors.getOrDefault(i, 0) + 1;
                divisors.put(i, power);
                if(v == 1)
                    return Map.copyOf(divisors);
                if(v == 0)
                    break;
            }
        }
        return Map.of(n, 1);
    }

    /**
     * @return primes (including 1 and n) up to (and including) n
     */
    public static int[] primes(int n) {
        assertNatural(n);
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= n; i++)
            if(isPrime(i))
                result.add(i);
        return toArray(result);
    }

    public static boolean isPrime(int n) {
        assertNatural(n);
        // we don't need to go beyond sqrt, because if the divisor is greater than that, then the result of the division
        // is less than sqrt(n)
        int sqrt = (int) Math.sqrt(n);
        for(int i = 2; i <= sqrt; i++)
            if(isDivisible(n, i))
                return false;
        return true;
    }

    /**
     * Greatest Common Divisor
     */
    public static int gcd(int a, int b) {
        assertNatural(a);
        assertNatural(b);
        int i = Math.max(a, b);
        int j = Math.min(a, b);
        while(true) {//Euclidean algorithm
            int multiple = i / j;
            int remainder = i - multiple*j;
            if(remainder == 0)
                return j;
            i = j;
            j = remainder;
        }
    }

    /**
     * Least Common Multiple
     */
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static boolean isDivisible(int n, int divisor) {
        return mod(n, divisor) == 0;
    }

    public static int mod(int x, int m) {
        assertNatural(m);
        int result = x % m;
        if(result < 0)// in Java mod isn't mathematical and can be negative if x was negative
            result += m;
        return result;
    }

    public static int assertWhole(int n){
        if(n < 0)
            throw new IllegalArgumentException("Must be whole: " + n);
        return n;
    }
    public static int assertNatural(int n){
        if(n < 1)
            throw new IllegalArgumentException("Must be natural: " + n);
        return n;
    }

    private static int[] toArray(List<Integer> l) {
        int[] result = new int[l.size()];
        for (int j = 0; j < l.size(); j++)
            result[j] = l.get(j);
        return result;
    }
}
