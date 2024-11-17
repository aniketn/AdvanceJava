package scaler.Adv.ArrayTwo;
/*Problem Description
Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1, such that the sum
of all the elements in the submatrix is maximum.

Problem Constraints
1 <= N <= 103.
1 <= B <= N
-102 <= A[i][j] <= 102.

Input Format
First arguement is an 2D integer matrix A.
Second argument is an integer B.

Output Format
Return a single integer denoting the maximum sum of submatrix of size B x B.

Example Input
Input 1:
 A = [
        [1, 1, 1, 1, 1]
        [2, 2, 2, 2, 2]
        [3, 8, 6, 7, 3]
        [4, 4, 4, 4, 4]
        [5, 5, 5, 5, 5]
     ]
 B = 3
Input 2:

 A = [
        [2, 2]
        [2, 2]
    ]
 B = 2


Example Output
Output 1: 48
Output 2: 8

Example Explanation
Explanation 1:
    Maximum sum 3 x 3 matrix is
    8 6 7
    4 4 4
    5 5 5
    Sum = 48
Explanation 2:
 Maximum sum 2 x 2 matrix is
  2 2
  2 2
  Sum = 8*/
public class MaxSumSquareSubMatrix {
    public static int solve(int[][] A, int B) {
        int row = A.length, col = A[0].length;
        int[][] dp = new int[row + 1][col + 1];
        int maxsum = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = A[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int sum = Integer.MIN_VALUE;
                if (i - B >= 0 && j - B >= 0) {
                    sum = dp[i][j] - dp[i - B][j] - dp[i][j - B] + dp[i - B][j - B];
                    maxsum = Math.max(sum, maxsum);
                }
            }
        }
        return maxsum;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] A = new int[][]{{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 8, 6, 7, 3}, {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5}};
        int B = 3;
        System.out.println(solve(A, B));
    }
}
