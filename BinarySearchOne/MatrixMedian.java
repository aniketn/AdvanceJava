package scaler.Adv.BinarySearchOne;

/*Problem Description
        Given a matrix of integers A of size N x M in which each row is sorted.
        Find and return the overall median of matrix A.
        NOTE: No extra memory is allowed.

        NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.

        Problem Constraints
        1 <= N, M <= 10^5
        1 <= N*M <= 10^6
        1 <= A[i] <= 10^9
        N*M is odd

        Input Format
        The first and only argument given is the integer matrix A.

        Output Format
        Return the overall median of matrix A.
        Example Input
        Input 1:
        A = [   [1, 3, 5],
        [2, 6, 9],
        [3, 6, 9]   ]
        Input 2:
        A = [   [5, 17, 100]    ]

        Example Output
        Output 1:
        5
        Output 2:
        17

        Example Explanation
        Explanation 1:
        A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
        Median is 5. So, we return 5.
        Explanation 2:
        Median is 17.*/
public class MatrixMedian {
    public static int findMedian(int[][] A) {
        int startVal = 0, endVal = 1000000000, midVal;
        int row = A.length;
        int col = A[0].length;
        int n = row * col;
        while (startVal <= endVal) {
            midVal = (endVal + startVal) / 2;
            int ans = 0;
            for (int i = 0; i < row; i++) {
                int low = 0, high = col - 1;
                while (low <= high) {
                    int m = low + (high - low) / 2;
                    if (A[i][m] <= midVal) {
                        low = m + 1;
                    } else {
                        high = m - 1;
                    }
                }
                ans += low;
            }
            if (ans <= n / 2) startVal = midVal + 1;
            else endVal = midVal - 1;
        }
        return startVal;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] A = new int[][]{{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(findMedian(A));
    }
}
