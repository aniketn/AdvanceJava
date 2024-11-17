package scaler.Adv.StackTwo;

import java.util.Stack;

/*Problem Description
        Given an array of integers A.
        A represents a histogram i.e A[i] denotes the height of the ith histogram's bar.
        Width of each bar is 1.

        Find the area of the largest rectangle formed by the histogram.

        Problem Constraints
        1 <= |A| <= 100000
        1 <= A[i] <= 1000000000

        Input Format
        The only argument given is the integer array A.

        Output Format
        Return the area of the largest rectangle in the histogram.

        Example Input
        Input 1:
        A = [2, 1, 5, 6, 2, 3]
        Input 2:
        A = [2]

        Example Output
        Output 1:
        10
        Output 2:
        2

        Example Explanation
        Explanation 1:
        The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
        Explanation 2:
        Largest rectangle has area 2.*/
public class LargestRectangleInHistogram {
    public static int largestRectangleArea(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        int[] smallestLeft = nearestSmallestOnLeft(A);
        int[] smallestRight = nearestSmallestOnRight(A);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            ans = Math.max(ans, A[i] * (smallestRight[i] - smallestLeft[i] - 1));
        }
        return ans;
    }

    public static int[] nearestSmallestOnLeft(int[] A) {
        Stack<Integer> st = new Stack<Integer>();
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            while (!st.empty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            if (st.empty()) {
                ans[i] = -1; // If nothing on left is smallest than the current A[i].
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public static int[] nearestSmallestOnRight(int[] A) {
        Stack<Integer> st = new Stack<Integer>();
        int[] ans = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            while (!st.empty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            if (st.empty()) {
                ans[i] = A.length; // If nothing on right is smallest than the current A[i].
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(A));
    }
}
