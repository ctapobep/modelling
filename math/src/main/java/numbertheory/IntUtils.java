package numbertheory;

public class IntUtils {

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

    public static int sum(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum = assertWhole(n+sum);
        return sum;
    }
    public static int product(int[] nums){
        int result = 1;
        for (int num : nums)
            result = assertWhole(num * result);
        return result;
    }

    public static int[] pow(int[] n, int exponent) {
        int[] result = new int[n.length];
        for (int i = 0; i < result.length; i++)
            result[i] = pow(n[i], exponent);
        return result;
    }
    public static int pow(int n, int exponent) {
        assertWhole(n);
        int result = 1;
        for (int i = 0; i < exponent; i++)
            result = assertWhole(result * n);
        return result;
    }
}
