package scaler.Adv.DPFiveString;

import java.util.Arrays;

/*Problem Description
        Given a string A, find if there is any subsequence that repeats itself.

        A subsequence of a string is defined as a sequence of characters
        generated by deleting some characters in the string without
        changing the order of the remaining characters.

        NOTE:
        1. Subsequence length should be greater than or equal to 2.
        2. The repeating subsequence should be disjoint that is in
        both the sequence no character in the same order and position
        should be taken from the same index of the original string.

        Problem Constraints
        1 <= length(A) <= 100

        Input Format
        The first and the only argument of input contains a string A.

        Output Format
        Return an integer, 1 if there is any subsequence which repeat itself else return 0.

        Example Input
        Input 1:
        A = "abab"
        Input 2:
        A = "abba"

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        "ab" is repeated.
        Explanation 2:
        There is no repeating subsequence.*/
public class RepeatingSubsequence {
    public static int anytwo(String A) {
        int m = A.length();

        int dp[][] = new int[m + 1][m + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        if (LCS(m, m, A, A, dp) >= 2)
            return 1;
        return 0;
    }


    public static int LCS(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0 || j == 0) return dp[i][j] = 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if ((s1.charAt(i - 1) == s2.charAt(j - 1)) && (i != j)) {
            dp[i][j] = 1 + LCS(i - 1, j - 1, s1, s2, dp);
        } else {
            dp[i][j] = Math.max(LCS(i - 1, j, s1, s2, dp), LCS(i, j - 1, s1, s2, dp));
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        System.out.println(anytwo("abab"));
    }
}
