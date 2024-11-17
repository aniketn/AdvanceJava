package scaler.Adv.ArrayOne;
/*
Problem Description
        Given a non-negative number represented as an array of digits, add 1 to the number
        ( increment the number represented by the digits ).

        The digits are stored such that the most significant digit is at the head of the list.

        NOTE: Certain things are intentionally left unclear in this question which you should
        practice asking the interviewer. For example: for this problem, the following are some
        good questions to ask :

        Q: Can the input have 0's before the most significant digit. Or, in other words,
        is 0 1 2 3 a valid input?
        A: For the purpose of this question, YES
        Q: Can the output have 0's before the most significant digit? Or, in other words,
        is 0 1 2 4 a valid output?
        A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


        Problem Constraints
        1 <= size of the array <= 1000000



        Input Format
        First argument is an array of digits.



        Output Format
        Return the array of digits after adding one.



        Example Input
        Input 1:

        [1, 2, 3]


        Example Output
        Output 1:

        [1, 2, 4]


        Example Explanation
        Explanation 1:

        Given vector is [1, 2, 3].
        The returned vector should be [1, 2, 4] as 123 + 1 = 124.
*/

import java.util.Arrays;

public class AddOneToNumber {
    public static int[] plusOne(int[] A) {
        int count = 0;
        // This for loop is to count the preceding no. of zeros and
        // A.length > 1 is to for edge case ex: {0}
        for (int i = 0; i < A.length && A.length > 1; i++) {
            if (A[i] == 0) {
                count++;
            } else {
                break;
            }
        }
        // This is to increase the digit by 1
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < 9) {
                A[i]++;
                return Arrays.copyOfRange(A, count, A.length);
            }
            A[i] = 0;
        }
        // This condition is for case for ex: {9,9,9,9}
        int[] ans = new int[A.length + 1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final int[] arr1 = new int[]{1,2,3};
        int[] ans = plusOne(arr1);
    }
}
