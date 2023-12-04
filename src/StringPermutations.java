import java.util.*;

public class StringPermutations {

    public static List<String> iterativePermutations(String str) {
        List<String> result = new ArrayList<>();
        result.add("");

        for (char c : str.toCharArray()) {
            List<String> newPermutations = new ArrayList<>();
            for (String perm : result) {
                for (int i = 0; i <= perm.length(); i++) {
                    newPermutations.add(perm.substring(0, i) + c + perm.substring(i));
                }
            }
            result = newPermutations;
        }

        return result;
    }

    public static List<String> recursivePermutations(String str) {
        List<String> result = new ArrayList<>();
        recursivePermute("", str, result);
        return result;
    }

    private static void recursivePermute(String prefix, String suffix, List<String> result) {
        if (suffix.length() == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                recursivePermute(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1), result);
            }
        }
    }

    public static boolean areArraysEqual(String[] arr1, String[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) {
        String input = "abc";
        List<String> iterativeResult = iterativePermutations(input);
        System.out.println("Iterative Permutations: " + iterativeResult);
        List<String> recursiveResult = recursivePermutations(input);
        System.out.println("Recursive Permutations: " + recursiveResult);
        boolean isEqual = areArraysEqual(iterativeResult.toArray(new String[0]), recursiveResult.toArray(new String[0]));
        System.out.println("Array Equality: " + isEqual);
    }
}
