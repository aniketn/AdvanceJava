package scaler.Adv.HashingTwo;

import java.util.HashMap;

/*Problem Description
        You are given two strings, A and B, of size N and M, respectively.
        You have to find the count of all permutations of A present in B as a substring.
        You can assume a string will have only lowercase letters.

        Problem Constraints
        1 <= N < M <= 105

        Input Format
        Given two arguments, A and B of type String.

        Output Format
        Return a single integer, i.e., number of permutations of A present in B as a substring.

        Example Input
        Input 1:
        A = "abc"
        B = "abcbacabc"
        Input 2:
        A = "aca"
        B = "acaa"

        Example Output
        Output 1:
        5
        Output 2:
        2

        Example Explanation
        Explanation 1:
        Permutations of A that are present in B as substring are:
        1. abc
        2. cba
        3. bac
        4. cab
        5. abc
        So ans is 5.
        Explanation 2:
        Permutations of A that are present in B as substring are:
        1. aca
        2. caa*/
public class PermutationsOfAInB {
    public static int solve(String A, String B) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (hm.get(ch) == null) {
                hm.put(ch, 1);
            } else {
                hm.put(ch, hm.get(ch) + 1);
            }
        }
        int window = A.length();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        int count = 0;
        for (int i = 0; i < window; i++) {
            char ch = B.charAt(i);
            if (hm2.get(ch) == null) {
                hm2.put(ch, 1);
            } else {
                hm2.put(ch, hm2.get(ch) + 1);
            }
        }
        if (hm.equals(hm2)) {
            count++;
        }
        for (int i = window; i < B.length(); i++) {
            char ch = B.charAt(i);
            if (hm2.get(ch) == null) {
                hm2.put(ch, 1);
            } else {
                hm2.put(ch, hm2.get(ch) + 1);
            }
            char prev = B.charAt(i - window);
            if (hm2.get(prev) == 1) {
                hm2.remove(prev);
            } else {
                hm2.put(prev, hm2.get(prev) - 1);
            }
            if (hm.equals(hm2)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve("abc", "abcbacabc"));
    }
}
