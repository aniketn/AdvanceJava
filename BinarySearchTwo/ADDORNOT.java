package scaler.Adv.BinarySearchTwo;

import java.util.Arrays;

/*Problem Description
        Given an array of integers A of size N and an integer B.
        In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B
        such operations.

        Find the number with the maximum number of occurrences and return an array C of size 2, where C[0]
        is the number of occurrences, and C[1] is the number with maximum occurrence.
        If there are several such numbers, your task is to find the minimum one.

        Problem Constraints
        1 <= N <= 105
        -109 <= A[i] <= 109
        0 <= B <= 109

        Input Format
        The first argument given is the integer array A.
        The second argument given is the integer B.

        Output Format
        Return an array C of size 2, where C[0] is number of occurence and C[1] is the number with
        maximum occurence.

        Example Input
        Input 1:
        A = [3, 1, 2, 2, 1]
        B = 3
        Input 2:
        A = [5, 5, 5]
        B = 3

        Example Output
        Output 1:
        [4, 2]
        Output 2:
        [3, 5]

        Example Explanation
        Explanation 1:
        Apply operations on A[2] and A[4]
        A = [3, 2, 2, 2, 2]
        Maximum occurence =  4
        Minimum value of element with maximum occurence = 2
        Explanation 2:
        A = [5, 5, 5]
        Maximum occurence =  3
        Minimum value of element with maximum occurence = 5*/
public class ADDORNOT {
    public static int[] solve(int[] A, int B) {
        // To do the prefix sum
        long prefix[] = new long[A.length + 1];
        Arrays.sort(A);
        int n = A.length;
        // Make prefix array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] += A[i] + prefix[i];
        }
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        for (int i = 0; i < n; i++) {
            int lo = 1, hi = i + 1;
            int mx = 0;
            // Binary search to find the value of cnt for each i
            while (lo <= hi) {
                int cnt = (lo + hi) / 2;
                if ((long) A[i] * cnt - (prefix[i + 1] - prefix[i - cnt + 1]) <= B) {
                    mx = cnt;
                    lo = cnt + 1;
                } else {
                    hi = cnt - 1;
                }
            }
            // Update ans
            if (ans[0] < mx) {
                ans[0] = mx;
                ans[1] = A[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{3, 1, 2, 2, 1};
        int[] ans = solve(A, 3);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("" + ans[i]);
        }
    }
}
