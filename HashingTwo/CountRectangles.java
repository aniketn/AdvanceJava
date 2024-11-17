package scaler.Adv.HashingTwo;

import java.util.HashMap;
import java.util.HashSet;

/*Problem Description
        Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents
        a unique point (x, y) in a 2-D Cartesian plane.

        Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]),
        (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to
        either x-axis or y-axis.

        Problem Constraints
        1 <= N <= 2000
        0 <= A[i], B[i] <= 109

        Input Format
        The first argument given is the integer array A.
        The second argument given is the integer array B.

        Output Format
        Return the number of unordered quadruplets that form a rectangle.

        Example Input
        Input 1:
        A = [1, 1, 2, 2]
        B = [1, 2, 1, 2]
        Input 1:
        A = [1, 1, 2, 2, 3, 3]
        B = [1, 2, 1, 2, 1, 2]

        Example Output
        Output 1:
        1
        Output 2:
        3

        Example Explanation
        Explanation 1:
        All four given points make a rectangle. So, the answer is 1.
        Explanation 2:
        3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
        (1, 1), (3, 1), (3, 2), (1, 2)
        (2, 1), (3, 1), (3, 2), (2, 2)*/
public class CountRectangles {
    public static int solve(int[] A, int[] B) {
        int n = A.length;
        // 1. add all coordinates into a HashSet in form of String
        HashSet<String> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st.add(A[i] + "*" + B[i]);
        }
        // 2. we are checking for every possible diagonal pair and searching for other diagonal pair
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (A[i] < A[j] && B[i] > B[j]) {
                        String p1 = A[i] + "*" + B[j];
                        String p2 = A[j] + "*" + B[i];
                        if (st.contains(p1) && st.contains(p2)) cnt++;
                    }
                }
            }
        }
        return cnt;
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{1, 1, 2, 2, 3, 3};
        int[] B = new int[]{1, 2, 1, 2, 1, 2};
        System.out.println(solve(A, B));
    }
}
