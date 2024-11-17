package scaler.Adv.DPThreeknapsack;

import java.util.Arrays;

/*Problem Description

        You are trying to send signals to aliens using a linear array of A laser lights.
         You don't know much about how the aliens are going to percieve the signals,
          but what you know is that if two consecutive lights are on then the aliens
          might take it as a sign of danger and destroy the earth.

        Find and return the total number of ways in which you can send a signal without
        compromising the safty of the earth. Return the ans % 109 + 7.

        Problem Constraints
        1 <= A <= 105

        Input Format
        The only argument given is integer A.

        Output Format
        Return the ans%(109+7).

        Example Input
        Input 1:
        A = 2
        Input 2:
        A = 3

        Example Output
        Output 1:
        3
        Output 2:
        5

        Example Explanation
        Explanation 1:
        OFF OFF
        OFF ON
        ON OFF
        All lights off is also a valid signal which probably means 'bye'
        Explanation 2:
        OFF OFF OFF
        OFF OFF ON
        OFF ON OFF
        ON OFF OFF
        ON OFF ON*/
public class WaysToSendTheSignal {
    static int mod = 1000000007;
    public static int solve(int A) {
        int dp[][] = new int[A + 1][3];
        for (int i = 0; i <= A; i++) Arrays.fill(dp[i], -1);
        return ways(A, dp, 2);
    }
    private static int ways(int n, int[][] dp, int flag) {
        if (n == 0) return 1;
        long ans = 0;
        if (dp[n][flag] != -1) return dp[n][flag];
        if (flag == 1) {
            ans = ans % mod + ways(n - 1, dp, 0);
        } else {
            ans = ans % mod + ways(n - 1, dp, 1);
            ans = ans % mod + ways(n - 1, dp, 0);
        }
        return dp[n][flag] = (int)(ans % mod);
    }

    public static void main(String[] args) {
        System.out.println(solve(2));
    }
}
