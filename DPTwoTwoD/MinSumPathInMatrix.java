package scaler.Adv.DPTwoTwoD;

import java.util.ArrayList;
import java.util.Arrays;

/*Problem Description
        Given a M x N grid A of integers, find a path from top left to bottom right
        which minimizes the sum of all numbers along its path.
        Return the minimum sum of the path.
        NOTE: You can only move either down or right at any point in time.

        Problem Constraints
        1 <= M, N <= 2000
        -1000 <= A[i][j] <= 1000

        Input Format
        First and only argument is a 2-D grid A.

        Output Format
        Return an integer denoting the minimum sum of the path.

        Example Input
        Input 1:
        A = [
        [1, 3, 2]
        [4, 3, 1]
        [5, 6, 1]
        ]
        Input 2:
        A = [
        [1, -3, 2]
        [2, 5, 10]
        [5, -5, 1]
        ]

        Example Output
        Output 1:
        8
        Output 2:
        -1

        Example Explanation
        Explanation 1:
        The path will be: 1 -> 3 -> 2 -> 1 -> 1.
        Input 2:
        The path will be: 1 -> -3 -> 5 -> -5 -> 1.*/
public class MinSumPathInMatrix {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int one = Integer.MAX_VALUE;
                int two = Integer.MAX_VALUE;
                if (i == j && i == 0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                if (i > 0) one = dp[i - 1][j] + grid[i][j];
                if (j > 0) two = dp[i][j - 1] + grid[i][j];

                dp[i][j] = Math.min(one, two);
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        /*ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 3, 2)));
        A.add(new ArrayList<Integer>(Arrays.asList(4, 3, 1)));
        A.add(new ArrayList<Integer>(Arrays.asList(5, 6, 1)));
*/
        int[][] A = new int[][]{{1, 3, 2}, {4, 3, 1}, {5, 6, 1}};
        System.out.println(minPathSum(A));
    }
}
