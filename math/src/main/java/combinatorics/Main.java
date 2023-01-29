package combinatorics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> alphabet = new ArrayList<>(10);
        for (int i = 0; i <= 9; i++)
            alphabet.add(String.valueOf(i));

        int wordLength = 3;
        List<String> combinations = combinations(wordLength, () -> alphabet).stream()
                .filter((s)-> s.charAt(0) != '0')
                .filter((s) -> numOfEven(s) == 0)
                .toList();

        Set<String> uniq = new HashSet<>(combinations);
        System.out.println(combinations.size() + " combinations: " + combinations);
        System.out.println(uniq.size() + " unique: " + uniq);
    }
    public static List<String> combinations(int steps, Supplier<List<String>> f) {
        List<String> result = f.get();
        for (int i = 1; i < steps; i++)
            result = cartesianConcat(result, f.get());
        return result;
    }

    public static List<String> cartesianConcat(List<String> a, List<String> b) {
        List<String> result = new ArrayList<>(a.size() * b.size());
        for (String s : a)
            for (String value : b)
                result.add(s + value);
        return result;
    }
    public static int numOfEven(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++)
            if((s.charAt(i) & 1) == 0)
                result++;
        return result;
    }
}
