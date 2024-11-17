package scaler.Adv.StackTwo;

import java.util.Arrays;
import java.util.Stack;

/*Problem Description
        Given an array of integers A.
        value of a array = max(array) - min(array).
        Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
        Problem Constraints
        1 <= |A| <= 100000
        1 <= A[i] <= 1000000

        Input Format
        The first and only argument given is the integer array A.

        Output Format
        Return the sum of values of all possible subarrays of A modulo 109+7.

        Example Input
        Input 1:
        A = [1]
        Input 2:
        A = [4, 7, 3, 8]

        Example Output
        Output 1:
        0
        Output 2:
        26

        Example Explanation
        Explanation 1:
        Only 1 subarray exists. Its value is 0.
        Explanation 2:
        value ( [4] ) = 4 - 4 = 0
        value ( [7] ) = 7 - 7 = 0
        value ( [3] ) = 3 - 3 = 0
        value ( [8] ) = 8 - 8 = 0
        value ( [4, 7] ) = 7 - 4 = 3
        value ( [7, 3] ) = 7 - 3 = 4
        value ( [3, 8] ) = 8 - 3 = 5
        value ( [4, 7, 3] ) = 7 - 3 = 4
        value ( [7, 3, 8] ) = 8 - 3 = 5
        value ( [4, 7, 3, 8] ) = 8 - 3 = 5
        sum of values % 10^9+7 = 26*/
public class MAXAndMIN {
    static int mod = (int) 1e9 + 7;

    public static int solve(int[] A) {
        int n = A.length;
        if (n == 1) return A[0];

        int nsl[] = nearestSmallerLeft(A);
        int nsr[] = nearestSmallerRight(A);
        int ngl[] = nearestGreaterLeft(A);
        int ngr[] = nearestGreaterRight(A);

        long totalMax = 0l, totalMin = 0l;

         for (int i = 0; i < n; i++) {
            //number of subarrays where A[i] will be maximum
            long maxSubarrayCount = 1l * (ngr[i] - i) * (i - ngl[i]);
            long currentMaxContri = (A[i] * maxSubarrayCount) % mod;

            //number of subarrays where A[i] will be minimum
            long minSubarrayCount = 1l * (nsr[i] - i) * (i - nsl[i]);
            long currentMinContri = (A[i] * minSubarrayCount) % mod;

            //generating total max contribution and minimum contribution
            totalMax = ((currentMaxContri % mod) + (totalMax % mod)) % mod;
            totalMin = ((currentMinContri % mod) + (totalMin % mod)) % mod;
        }

        int sum = (int) (totalMax - totalMin) % mod;
        return (sum + mod) % mod;
    }

    public static int[] nearestSmallerLeft(int[] a) {
        Stack<Integer> cl = new Stack<>();
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < a.length; i++) {
            while (!cl.isEmpty() && a[cl.peek()] >= a[i]) {
                cl.pop();
            }
            if (!cl.isEmpty()) {
                ans[i] = cl.peek();
            }
            cl.push(i);
        }

        return ans;
    }

    public static int[] nearestSmallerRight(int[] a) {
        int n = a.length;
        Stack<Integer> cl = new Stack<>();
        int[] ans = new int[a.length];
        Arrays.fill(ans, n);

        for (int i = a.length - 1; i >= 0; i--) {
            while (!cl.isEmpty() && a[cl.peek()] >= a[i]) {
                cl.pop();
            }
            if (!cl.isEmpty()) {
                ans[i] = cl.peek();
            }
            cl.push(i);
        }

        return ans;
    }

    public static int[] nearestGreaterLeft(int[] a) {
        Stack<Integer> cl = new Stack<>();
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < a.length; i++) {
            while (!cl.isEmpty() && a[cl.peek()] <= a[i]) {
                cl.pop();
            }
            if (!cl.isEmpty()) {
                ans[i] = cl.peek();
            }
            cl.push(i);
        }

        return ans;
    }

    public static int[] nearestGreaterRight(int[] a) {
        int n = a.length;
        Stack<Integer> cl = new Stack<>();
        int[] ans = new int[a.length];
        Arrays.fill(ans, n);

        for (int i = a.length - 1; i >= 0; i--) {
            while (!cl.isEmpty() && a[cl.peek()] <= a[i]) {
                cl.pop();
            }
            if (!cl.isEmpty()) {
                ans[i] = cl.peek();
            }
            cl.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {4, 7, 3, 8};
        System.out.println(solve(A));
    }
}
