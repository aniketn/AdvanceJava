package scaler.Adv.DPFiveString;

import java.util.ArrayList;
import java.util.Arrays;

/*Problem Description
        Given two strings A and B. Find the longest common subsequence
        ( A sequence which does not need to be contiguous), which is common in both the strings.

        You need to return the length of such longest common subsequence.

        Problem Constraints
        1 <= Length of A, B <= 1005

        Input Format
        First argument is a string A.
        Second argument is a string B.

        Output Format
        Return an integer denoting the length of the longest common subsequence.

        Example Input
        Input 1:
        A = "abbcdgf"
        B = "bbadcgf"
        Input 2:
        A = "aaaaaa"
        B = "ababab"

        Example Output
        Output 1:
        5
        Output 2:
        3

        Example Explanation
        Explanation 1:
        The longest common subsequence is "bbcgf", which has a length of 5.
        Explanation 2:
        The longest common subsequence is "aaa", which has a length of 3.*/
public class LongestCommonSubsequence {
    public static int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n][m];

        if (A.charAt(0) == B.charAt(0))
            dp[0][0] = 1;
        //filling first row
        for (int col = 1; col < m; col++) {
            if (A.charAt(0) == B.charAt(col))
                dp[0][col] = 1;
            else
                dp[0][col] = dp[0][col - 1];
        }

        //filling first col
        for (int row = 1; row < m; row++) {
            if (A.charAt(row) == B.charAt(0))
                dp[row][0] = 1;
            else
                dp[row][0] = dp[row - 1][0];
        }

        //rest of the dp
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A.charAt(i) == B.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(solve("abbcdgf", "bbadcgf"));
    }
}
