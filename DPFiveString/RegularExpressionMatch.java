package scaler.Adv.DPFiveString;
/*
Problem Description
        Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

        ' ? ' : Matches any single character.
        ' * ' : Matches any sequence of characters (including the empty sequence).
        The matching should cover the entire input string (not partial).

        Problem Constraints
        1 <= length(A), length(B) <= 104

        Input Format
        The first argument of input contains a string A.
        The second argument of input contains a string B.

        Output Format
        Return 1 if the patterns match else return 0.

        Example Input
        Input 1:
        A = "aaa"
        B = "a*"
        Input 2:
        A = "acz"
        B = "a?a"

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
        So, the pattern matches we return 1.
        Explanation 2:
        '?' matches any single character. First two character in string A will be match.
        But the last character i.e 'z' != 'a'. Return 0.
*/

//Explanation about the Code

// If current characters match, result is same as
// result for lengths minus one. Characters match
// in two cases:
// a) If pattern character is '?' then it matches
//    with any character of text.
// b) If current characters in both match
/*if ( pattern[j – 1] == ‘?’) ||
        (pattern[j – 1] == text[i - 1])
        T[i][j] = T[i-1][j-1]*/

import java.util.Arrays;

// If we encounter ‘*’, two choices are possible-
// a) We ignore ‘*’ character and move to next
//    character in the pattern, i.e., ‘*’
//    indicates an empty sequence.
// b) '*' character matches with ith character in
//     input
       /* else if (pattern[j – 1] == ‘*’)
        T[i][j] = T[i][j-1] || T[i-1][j]

        else // if (pattern[j – 1] != text[i - 1])
        T[i][j]  = false*/
public class RegularExpressionMatch {
    public static boolean isMatch(String str, String pattern) {
        int n = str.length();
        int m = pattern.length();

        // empty pattern can only match with
        // empty string
        if (m == 0)
            return (n == 0);

        // lookup table for storing results of
        // subproblems
        boolean[][] dp = new boolean[n + 1][m + 1];

        // initialize lookup table to false
        for (int i = 0; i < n + 1; i++)
            Arrays.fill(dp[i], false);

        // empty pattern can match with empty string
        dp[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)
            if (pattern.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                else if (pattern.charAt(j - 1) == '?' || str.charAt(i - 1) == pattern.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = false;
            }
        }

        return dp[n][m];
    }


    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "a?a"));
    }
}
