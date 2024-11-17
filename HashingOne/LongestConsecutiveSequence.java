package scaler.Adv.HashingOne;

import java.util.HashSet;

/*Problem Description
        Given an unsorted integer array A of size N.
        Find the length of the longest set of consecutive elements from array A.

        Problem Constraints
        1 <= N <= 106
        -106 <= A[i] <= 106

        Input Format
        First argument is an integer array A of size N.

        Output Format
        Return an integer denoting the length of the longest set of consecutive elements from the array A.

        Example Input
        Input 1:
        A = [100, 4, 200, 1, 3, 2]
        Input 2:
        A = [2, 1]

        Example Output
        Output 1:
        4
        Output 2:
        2

        Example Explanation
        Explanation 1:
        The set of consecutive elements will be [1, 2, 3, 4].
        Explanation 2:
        The set of consecutive elements will be [1, 2].*/
public class LongestConsecutiveSequence {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int longestConsecutive(final int[] A) {
        HashSet<Integer> seq = new HashSet<>();
        int result = 0;
        //Populate the Set with Array values.
        for (Integer i : A) {
            seq.add(i);
        }

        //For each element in the set set a counter
        //check if has its next number present using a while loop
        //Store the value to result if its the current max
        for (int i = 0; i < A.length; i++) {
            if (seq.contains(A[i] - 1)) {
                continue;
            }
            if (seq.contains(A[i])) {
                int count = 0;
                int temp = A[i];
                while (seq.contains(temp)) {
                    count++;
                    temp++;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(A));
    }
}
