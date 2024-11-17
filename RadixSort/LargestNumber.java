package scaler.Adv.RadixSort;

import java.util.Arrays;
import java.util.Comparator;

/*Problem Description
        Given an array A of non-negative integers, arrange them such that they form the largest number.
        Note: The result may be very large, so you need to return a string instead of an integer.

        Problem Constraints
        1 <= len(A) <= 100000
        0 <= A[i] <= 2*109

        Input Format
        The first argument is an array of integers.
        Output Format
        Return a string representing the largest number.

        Example Input
        Input 1:
        A = [3, 30, 34, 5, 9]
        Input 2:
        A = [2, 3, 9, 0]

        Example Output
        Output 1:
        "9534330"
        Output 2:
        "9320"

        Example Explanation
        Explanation 1:
        Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
        Explanation 2:
        Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.*/
public class LargestNumber {
    public static String largestNumber(final int[] A) {
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        Arrays.sort(B, comparator);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < B.length; i++) {
            sb.append(B[i]);
        }

        // Remove leading zeros
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i++;
        }

        return sb.substring(i);
    }

    static Comparator<Integer> comparator = new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            String ab = String.valueOf(a) + String.valueOf(b);
            String ba = String.valueOf(b) + String.valueOf(a);
            return ba.compareTo(ab);
        }
    };

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{0, 30, 34, 5, 9};
        System.out.println(largestNumber(A));
    }
}
