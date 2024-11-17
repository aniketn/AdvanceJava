package scaler.Adv.DPSevenFamousProbTwo;

/*Problem Description
        Given an array of integers A representing chain of 2-D matices
         such that the dimensions of ith matrix is A[i-1] x A[i].

        Find the most efficient way to multiply these matrices together.
         The problem is not actually to perform the multiplications,
         but merely to decide in which order to perform the multiplications.

        Return the minimum number of multiplications needed to multiply the chain.

        Problem Constraints
        1 <= length of the array <= 1000
        1 <= A[i] <= 100

        Input Format
        The only argument given is the integer array A.

        Output Format
        Return an integer denoting the minimum number of multiplications
        needed to multiply the chain.

        Example Input
        Input 1:
        A = [40, 20, 30, 10, 30]
        Input 2:
        A = [10, 20, 30]

        Example Output
        Output 1:
        26000
        Output 2:
        6000

        Example Explanation
        Explanation 1:
        Dimensions of A1 = 40 x 20
        Dimensions of A2 = 20 x 30
        Dimensions of A3 = 30 x 10
        Dimensions of A4 = 10 x 30
        First, multiply A2 and A3 ,cost = 20*30*10 = 6000
        Second, multilpy A1 and (Matrix obtained after multilying A2 and A3) =  40 * 20 * 10 = 8000
        Third, multiply (Matrix obtained after multiplying A1, A2 and A3) and A4 =  40 * 10 * 30 = 12000
        Total Cost = 12000 + 8000 + 6000 =26000
        Explanation 2:
        Cost to multiply two matrices with dimensions 10 x 20 and 20 x 30 = 10 * 20 * 30 = 6000.*/
public class MatrixChainMultiplication {
    public static int solve(int[] A) {
        int[][] dp = new int[A.length - 1][A.length - 1];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++)
                if (g == 0) {
                    dp[i][j] = 0;
                } else if (g == 1) {
                    dp[i][j] = A[i] * A[j] * A[j + 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int lc = dp[i][k];
                        int rc = dp[k + 1][j];
                        int mc = A[i] * A[k + 1] * A[j + 1];
                        int tc = lc + rc + mc;
                        if (tc < min) {
                            min = tc;
                        }
                    }
                    dp[i][j] = min;
                }
        }
        return dp[0][dp.length - 1];
       /* int dp[][] = new int[A.length][A.length];
        for (int x = 0; x < A.length; x++) {
            for (int y = 0; y < A.length; y++) {
                dp[x][y] = -1;
            }
        }
        return mincost(A, 1, A.length - 1, dp);
    }

    static int mincost(int A[], int i, int j, int dp[][]) {
        if (i == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int l = mincost(A, i, k, dp);
            int r = mincost(A, k + 1, j, dp);
            int cost = A[i - 1] * A[k] * A[j];

            dp[i][j] = Math.min(dp[i][j], l + r + cost);
        }
        return dp[i][j];*/
    }

    public static void main(String[] args) {
        int[] A = {40, 20, 30, 10, 30};
        System.out.println(solve(A));
    }
}
