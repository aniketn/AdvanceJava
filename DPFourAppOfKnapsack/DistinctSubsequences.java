package scaler.Adv.DPFourAppOfKnapsack;

import java.util.ArrayList;
import java.util.Arrays;

/*Problem Description
        Given two sequences A and B, count number of unique ways in sequence A,
        to form a subsequence that is identical to the sequence B.

        Subsequence : A subsequence of a string is a new string which is
        formed from the original string by deleting some (can be none) of the
        characters without disturbing the relative positions of the remaining
        characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

        Problem Constraints
        1 <= length(A), length(B) <= 700

        Input Format
        The first argument of input contains a string A.
        The second argument of input contains a string B.

        Output Format
        Return an integer representing the answer as described in the problem statement.

        Example Input
        Input 1:
        A = "abc"
        B = "abc"
        Input 2:
        A = "rabbbit"
        B = "rabbit"

        Example Output
        Output 1:
        1
        Output 2:
        3

        Example Explanation
        Explanation 1:
        Both the strings are equal.
        Explanation 2:
        These are the possible removals of characters:
        => A = "ra_bbit"
        => A = "rab_bit"
        => A = "rabb_it"
        Note: "_" marks the removed character.*/
public class DistinctSubsequences {
    public static int numDistinct(String A, String B) {
        int n = A.length(), m = B.length();
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return ways(0, 0, A, B, dp);

    }

    private static int ways(int i, int j, String A, String B, int dp[][]) {
        if (j == B.length()) return 1;
        if (i == A.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if (A.charAt(i) == B.charAt(j))
            ans = ways(i + 1, j + 1, A, B, dp);
        ans += ways(i + 1, j, A, B, dp);
        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
}
