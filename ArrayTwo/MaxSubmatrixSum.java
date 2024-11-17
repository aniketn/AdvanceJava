package scaler.Adv.ArrayTwo;

/*Problem Description
Given a row-wise and column-wise sorted matrix A of size N * M.
Return the maximum non-empty submatrix sum of this matrix.

Problem Constraints
1 <= N, M <= 1000
-109 <= A[i][j] <= 109

Input Format
The first argument is a 2D integer array A.

Output Format
Return a single integer that is the maximum non-empty submatrix sum of this matrix.

Example Input
Input 1:-
    -5 -4 -3
A = -1  2  3
     2  2  4
Input 2:-
    1 2 3
A = 4 5 6
    7 8 9

Example Output
Output 1:-
12
Output 2:-
45

Example Explanation
Expanation 1:-
The submatrix with max sum is
-1 2 3
 2 2 4
 Sum is 12.
Explanation 2:-
The largest submatrix with max sum is
1 2 3
4 5 6
7 8 9
The sum is 45.
*/
public class MaxSubmatrixSum {
    public static long solve(int[][] A) {
        long maxsum = Integer.MIN_VALUE;
        int N = A.length;
        int M = A[0].length;
        int row = N - 1;
        int col = M - 1;
        if (A[row][col] < 0)
            return A[row][col];
        long[][] pf = new long[N + 1][M + 1];

        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                long s = (long) A[i][j] + pf[i + 1][j] + pf[i][j + 1] - pf[i + 1][j + 1];
                maxsum = Math.max(s, maxsum);
                pf[i][j] = s;
            }
        }
        return maxsum;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] A = new int[][]{{-5,-4,-3}, {-1,2,3}, {2,2,4}};
        System.out.println(solve(A));
    }
}
