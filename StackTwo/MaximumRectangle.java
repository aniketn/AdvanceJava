package scaler.Adv.StackTwo;

import java.util.Stack;

/*Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
        Find the largest rectangle containing only 1's and return its area.
        Note: Rows are numbered from top to bottom and columns are numbered from left to right.

        Input Format
        The only argument given is the integer matrix A.
        Output Format
        Return the area of the largest rectangle containing only 1's.
        Constraints
        1 <= N, M <= 1000
        0 <= A[i] <= 1
        For Example

        Input 1:
        A = [   [0, 0, 1]
                [0, 1, 1]
                [1, 1, 1]   ]
        Output 1:
        4
        Input 2:
        A = [   [0, 1, 0, 1]
                [1, 0, 1, 0]    ]
        Output 2:
        1*/
public class MaximumRectangle {
    public static int solve(int[][] A) {
        int n = A.length, m = A[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = A[i][j] == 0 ? 0 : A[i][j] + A[i - 1][j];
            }
        }
        int ans = 0;
        for (int[] arr : A) {
            ans = Math.max(ans, largestRectangleArea(arr));
        }
        return ans;
    }

    private static int largestRectangleArea(int[] A) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        int n = A.length, j, k;
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || A[st.peek()] > A[i])) {
                j = st.pop();
                k = st.isEmpty() ? -1 : st.peek();
                ans = Math.max(ans, A[j] * (i - k - 1));
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] A = {{0, 0, 1}, {0, 1, 1}, {1, 1, 1}};
        System.out.println(solve(A));
    }
}
