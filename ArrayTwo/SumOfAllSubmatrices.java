package scaler.Adv.ArrayTwo;

/*Problem Description
Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.

Problem Constraints
1 <= N <=30
0 <= A[i][j] <= 10

Input Format
Single argument representing a 2-D array A of size N x N.
Output Format
Return an integer denoting the sum of all possible submatrices in the given matrix.

Example Input
Input 1:
A = [ [1, 1]
      [1, 1] ]
Input 2:
A = [ [1, 2]
      [3, 4] ]

Example Output
Output 1:
16
Output 2:
40


Example Explanation
Example 1:
Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4 * 1 = 4
Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4 * 2 = 8
Number of submatrices with 3 elements = 0
Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
Total Sum = 4+8+4 = 16
Example 2:
The submatrices are [1], [2], [3], [4], [1, 2], [3, 4], [1, 3], [2, 4] and [[1, 2], [3, 4]].
Total sum = 40*/
public class SumOfAllSubmatrices {
    public static int solve(int[][] A) {
        int allSubArrSum = 0, n = A[0].length, m = A.length;
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                // calculating occurance of each element
                int occurance = (i + 1) * (n - i) * (j + 1) * (m - j);
                // multiplying occurance with the element value and adding to
                // Sum
                allSubArrSum += occurance * A[i][j];
            }
        }
        return allSubArrSum;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] A = new int[][]{{1, 1}, {1, 1}};
        System.out.println(solve(A));
    }
}
