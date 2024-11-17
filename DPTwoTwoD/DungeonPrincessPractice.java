package scaler.Adv.DPTwoTwoD;

public class DungeonPrincessPractice {
    public int dungeonPrincess(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int[][] dp = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = Math.min(0, A[i][j]);
                } else if (i == n - 1) {
                    dp[i][j] = Math.min(0, dp[i][j + 1] + A[i][j]);
                } else if (j == m - 1) {
                    dp[i][j] = Math.min(0, dp[i + 1][j] + A[i][j]);
                } else {
                    dp[i][j] = Math.min(0, Math.max(dp[i][j + 1] + A[i][j], dp[i][j + 1] + A[i][j]));
                }
            }
        }
        return Math.abs(dp[0][0]) + 1;
    }
}
