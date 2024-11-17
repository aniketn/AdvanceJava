package scaler.Adv.BitManipulationTwo;

/*Problem Description
        Given an array of integers A and an integer B, find and return the maximum value K such that there is no
        subarray in A of size K with the sum of elements greater than B.

        Problem Constraints
        1 <= |A| <= 100000
        1 <= A[i] <= 10^9
        1 <= B <= 10^9

        Input Format
        The first argument given is the integer array A.
        The second argument given is integer B.

        Output Format
        Return the maximum value of K (sub array length).

        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5]
        B = 10
        Input 2:
        A = [5, 17, 100, 11]
        B = 130

        Example Output
        Output 1:        2
        Output 2:        3

        Example Explanation
        Explanation 1:
        Constraints are satisfied for maximal value of 2.
        Explanation 2:
        Constraints are satisfied for maximal value of 3.*/
public class SpecialInteger {
    public int solve(int[] A, int B) {
        int start = 1, end = A.length, mid, ans = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            boolean flag = checkWindow(A, B, mid);
            if (flag) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private boolean checkWindow(int[] A, int B, int window) {
        long sum = 0;
        for (int i = 0; i < window; i++) sum += A[i];
        long max = sum;
        for (int i = window; i < A.length; i++) {
            sum = sum + A[i] - A[i - window];
            max = Math.max(max, sum);
        }
        if (max <= B) return true;
        return false;
    }
}
