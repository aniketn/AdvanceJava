package scaler.Adv.ModArithmetic;

import java.util.Arrays;

/*Problem Description
        Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is
        divisible by B.
        Since the answer may be large, return the answer modulo (109 + 7).

        Problem Constraints
        1 <= length of the array <= 100000
        1 <= A[i] <= 109
        1 <= B <= 106

        Input Format
        The first argument given is the integer array A.
        The second argument given is the integer B.

        Output Format
        Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).

        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5]
        B = 2
        Input 2:
        A = [5, 17, 100, 11]
        B = 28

        Example Output
        Output 1:        4
        Output 2:        1

        Example Explanation
        Explanation 1:
        All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5).
        So total 4 pairs.*/
public class PairSumDivisibleByM {
    public static int solve(int[] A, int B) {
        int N = A.length;
        //Step 1 Create the count array and store the frequency of A[i]%m in count array
        long[] count = new long[B];
        for (int i = 0; i < N; i++) {
            int rem = A[i] % B;
            count[rem]++;
        }

        //Step 2 find the number of pairs and handle edge cases
        //Edge Case for rem =0
        long ans = 0;
        long x = count[0];
        ans += (x * (x - 1)) / 2;

        //Edge case for rem = B/2 only valid if B is even in odd case not valid
        if (B % 2 == 0) {
            long y = count[B / 2];
            ans += (y * (y - 1)) / 2;
        }

        //normal cases
        int i = 1;
        int j = B - 1;

        while (i < j) {
            ans += count[i] * count[j];
            i++;
            j--;
        }
        return (int) (ans % 1000000007);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {5, 17, 100, 11};
        System.out.println(solve(A, 28));
    }
}
