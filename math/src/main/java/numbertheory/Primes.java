package numbertheory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.qala.datagen.RandomElements.from;
import static io.qala.datagen.RandomShortApi.integer;
import static io.qala.datagen.RandomShortApi.sampleMultiple;
import static numbertheory.IntUtils.assertNatural;
import static numbertheory.IntUtils.product;
import static numbertheory.NumberUtils.isDivisible;

public class Primes {
    private static final int[] PRIMES = primes(1000);
    private static final List<Integer> PRIMES_LIST = toList(PRIMES);

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
    /** @return number of primes ≤ n */
    public static int π(int n) {
        return Primes.primes(n).length;
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

    private static int[] toArray(List<Integer> l) {
        int[] result = new int[l.size()];
        for (int j = 0; j < l.size(); j++)
            result[j] = l.get(j);
        return result;
    }

    public static int random() {
        return PRIMES[integer(0, PRIMES.length-1)];
    }

    public static int[] randomCoprimes(int numOfValues) {
        int[] result = new int[numOfValues];
        // this makes a random sample of the primes that we'll use for generation. We probably won't use all of these
        List<Integer> primes = sampleMultiple(numOfValues * 3, PRIMES_LIST);
        int primesUsed = 0;// so that we don't reuse the same prime for multiple values we generate
        for (int i = 0; i < numOfValues; i++) {
            int divisors = integer(1, 3);
            List<Integer> primesForCurrent = primes.subList(primesUsed, primesUsed + divisors);
            primesUsed += divisors;
            // with replacement - so that some primes could get repeated
            primesForCurrent = from(primesForCurrent).sampleWithReplacement(3);
            result[i] = product(toArray(primesForCurrent));
        }
        return result;
    }

    private static List<Integer> toList(@SuppressWarnings("SameParameterValue") int[] ints) {
        List<Integer> result = new ArrayList<>(ints.length);
        for (int anInt : ints)
            result.add(anInt);
        return result;
    }
}
