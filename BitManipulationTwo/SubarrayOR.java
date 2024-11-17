package scaler.Adv.BitManipulationTwo;

/*Problem Description
        You are given an array of integers A of size N.
        The value of a subarray is defined as BITWISE OR of all elements in it.
        Return the sum of value of all subarrays of A % 109 + 7.

        Problem Constraints
        1 <= N <= 105
        1 <= A[i] <= 108

        Input Format
        The first argument given is the integer array A.
        Output Format
        Return the sum of Value of all subarrays of A % 109 + 7.

        Example Input
        Input 1:        A = [1, 2, 3, 4, 5]
        Input 2:        A = [7, 8, 9, 10]

        Example Output
        Output 1:        71
        Output 2:        110

        Example Explanation
        Explanation 1:
        Value([1]) = 1
        Value([1, 2]) = 3
        Value([1, 2, 3]) = 3
        Value([1, 2, 3, 4]) = 7
        Value([1, 2, 3, 4, 5]) = 7
        Value([2]) = 2
        Value([2, 3]) = 3
        Value([2, 3, 4]) = 7
        Value([2, 3, 4, 5]) = 7
        Value([3]) = 3
        Value([3, 4]) = 7
        Value([3, 4, 5]) = 7
        Value([4]) = 4
        Value([4, 5]) = 5
        Value([5]) = 5
        Sum of all these values = 71
        Explanation 2:

        Sum of value of all subarray is 110.*/
public class SubarrayOR {
    public static int solve(int[] A) {
        long ans = 0, n = A.length, tot_subArray = (n * (n + 1)) / 2;
        for (int b = 0; b < 32; b++) {
            long anszero = 0, cnt = 0;
            for (int i = 0; i < A.length; i++) {
                if (((A[i] >> b) & 1) != 1)
                    cnt++;
                else {
                    anszero += ((cnt * (cnt + 1)) / 2);
                    cnt = 0;
                }
            }
            anszero += ((cnt * (cnt + 1)) / 2);
            anszero = (tot_subArray - anszero);
            ans = (ans + (anszero * (1 << b))) % 1000000007;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(A));
    }
}
