package scaler.Adv.StackTwo;

import java.util.ArrayList;
import java.util.Stack;

/*Problem Description
        Given an integer array A of size N. You have to generate it's all subarrays having a
        size greater than 1.

        Then for each subarray, find Bitwise XOR of its maximum and second maximum element.
        Find and return the maximum value of XOR among all subarrays.

        Problem Constraints
        2 <= N <= 105
        1 <= A[i] <= 107

        Input Format
        The only argument is an integer array A.

        Output Format
        Return an integer, i.e., the maximum value of XOR of maximum and 2nd maximum element among all subarrays.

        Example Input
        Input 1:
        A = [2, 3, 1, 4]
        Input 2:
        A = [1, 3]

        Example Output
        Output 1:
        7
        Outnput 2:
        2

        Example Explanation
        Explanation 1:
        All subarrays of A having size greater than 1 are:
        Subarray            XOR of maximum and 2nd maximum no.
        1. [2, 3]           1
        2. [2, 3, 1]        1
        3. [2, 3, 1, 4]     7
        4. [3, 1]           2
        5. [3, 1, 4]        7
        6. [1, 4]           5
        So maximum value of Xor among all subarrays is 7.
        Explanation 2:
        Only subarray is [1, 3] and XOR of maximum and 2nd maximum is 2.*/
public class AllSubarrays {
    /**
     * The approach used in this solution is to first find the prevGreater and nextGreater arrays for the given A array.
     * The prevGreater array stores, for each element in A, the index of the previous greater element in the array.
     * The nextGreater array stores, for each element in A, the index of the next greater element in the array.
     * These arrays can be found by using two stacks and iterating over the elements in A from both the left and right sides.
     * Once we have the prevGreater and nextGreater arrays, we can calculate the maximum bitwise XOR of the maximum
     * and second maximum elements of all subarrays of A. This is done by iterating over each element in A and checking if
     * both the previous greater and next greater elements exist. If they both exist, the maximum bitwise XOR of the maximum
     * and second maximum elements is calculated as the maximum of (A.get(i) ^ A.get(prevGreater[i])) and
     * (A.get(i) ^ A.get(nextGreater[i])). If only the previous greater element exists,
     * then the maximum bitwise XOR is (A.get(i) ^ A.get(prevGreater[i])). If only the next greater element exists,
     * then the maximum bitwise XOR is (A.get(i) ^ A.get(nextGreater[i])).
     * The final answer is the maximum of all the calculated bitwise XOR values.
     * The time complexity of this solution is O(n), where n is the number of elements in the given A array.
     */

    public static int solve(int[] A) {
        int n = A.length;
        int maxXor = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(A[0]);

        for (int i = 1; i < n; i++) {
            if (!stack.isEmpty() && A[i] > stack.peek()) {
                while (!stack.isEmpty() && A[i] > stack.peek()) {
                    maxXor = Math.max(maxXor, A[i] ^ stack.pop());
                }
            }
            if (!stack.isEmpty() && A[i] < stack.peek()) {
                maxXor = Math.max(maxXor, A[i] ^ stack.peek());
            }
            stack.push(A[i]);
        }
        return maxXor;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(3);
        A.add(1);
        A.add(4);*/
        int[] A = new int[]{2, 3, 1, 4};
        System.out.println(solve(A));
    }
}
