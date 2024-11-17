package scaler.Adv.DPSevenFamousProbTwo;

/*Problem Description
        Given a string A. Find the longest palindromic subsequence
        (A subsequence which does not need to be contiguous and is a palindrome).

        You need to return the length of longest palindromic subsequence.

        Problem Constraints
        1 <= length of(A) <= 103

        Input Format
        First and only integer is a string A.

        Output Format
        Return an integer denoting the length of longest palindromic subsequence.

        Example Input
        Input 1:
        A = "bebeeed"
        Input 2:
        A = "aedsead"

        Example Output
        Output 1:
        4
        Output 2:
        5

        Example Explanation
        Explanation 1:
        The longest palindromic subsequence is "eeee", which has a length of 4.
        Explanation 2:
        The longest palindromic subsequence is "aedea", which has a length of 5.*/
public class LongestPalindromicubsequence {
    public static int solve(String A) {
        int[][] dp = new int[A.length()][A.length()];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++)
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = A.charAt(i) == A.charAt(j) ? 2 : 1;
                } else {
                    if (A.charAt(i) == A.charAt(j)) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
        }
        return dp[0][A.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(solve("bebeeed"));
    }
}
