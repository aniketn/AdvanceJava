package scaler.Adv.GCD;

import java.util.ArrayList;

/*Problem Description
        Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common
        divisor) of the remaining array is maximum.
        Find the maximum value of GCD.

        Problem Constraints
        2 <= N <= 105
        1 <= A[i] <= 109

        Input Format
        First argument is an integer array A.
        Output Format
        Return an integer denoting the maximum value of GCD.

        Example Input
        Input 1:        A = [12, 15, 18]
        Input 2:        A = [5, 15, 30]

        Example Output
        Output 1:        6
        Output 2:        15

        Example Explanation
        Explanation 1:
        If you delete 12, gcd will be 3.
        If you delete 15, gcd will be 6.
        If you delete 18, gcd will 3.
        Maximum vallue of gcd is 6.
        Explanation 2:
        If you delete 5, gcd will be 15.
        If you delete 15, gcd will be 5.
        If you delete 30, gcd will be 5.*/
public class DeleteOne {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int solve(int[] A) {
        int n = A.length;
        int suffixGcdArray[] = new int[n];
        int maxGCD = Integer.MIN_VALUE;

        //calculating suffixGcdArray
        suffixGcdArray[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixGcdArray[i] = gcd(suffixGcdArray[i + 1], A[i]);
        }

        //computing prefix gcd using carry forward approach and fincing maxGCD
        //edge case for deleting 0th index
        maxGCD = Math.max(maxGCD, gcd(0, suffixGcdArray[1]));

        //computing for rest of the array
        int prefixGCD = A[0];
        for (int i = 1; i < n - 1; i++) {
            maxGCD = Math.max(maxGCD, gcd(prefixGCD, suffixGcdArray[i + 1]));
            prefixGCD = gcd(prefixGCD, A[i]);
        }

        //edge case of last index
        maxGCD = Math.max(maxGCD, gcd(prefixGCD, 0));
        return maxGCD;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{12, 15, 18};
        System.out.println(solve(A));

    }
}
