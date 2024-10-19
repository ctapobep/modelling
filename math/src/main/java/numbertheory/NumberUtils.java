package numbertheory;

import static numbertheory.IntUtils.assertNatural;

public class NumberUtils {

    /** Greatest Common Divisor */
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

}
