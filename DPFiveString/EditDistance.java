package scaler.Adv.DPFiveString;

/*Problem Description
        Given two strings A and B, find the minimum number of steps required
         to convert A to B. (each operation is counted as 1 step.)

        You have the following 3 operations permitted on a word:

        Insert a character
        Delete a character
        Replace a character

        Problem Constraints
        1 <= length(A), length(B) <= 450

        Input Format
        The first argument of input contains a string, A.
        The second argument of input contains a string, B.

        Output Format
        Return an integer, representing the minimum number of steps required.

        Example Input
        Input 1:
        A = "abad"
        B = "abac"
        Input 2:
        A = "Anshuman"
        B = "Antihuman

        Example Output
        Output 1:
        1
        Output 2:
        2

        Example Explanation
        Exlanation 1:
        A = "abad" and B = "abac"
        After applying operation: Replace d with c. We get A = B.
        Explanation 2:
        A = "Anshuman" and B = "Antihuman"
        After applying operations: Replace s with t and insert i before h. We get A = B.*/
public class EditDistance {
    public static int minDistance(String A, String B) {
        int m = A.length();
        int n = B.length();

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("Anshuman", "Antihuman"));
    }
}
