package scaler.Adv.QueueOne;

import java.util.HashMap;
import java.util.Stack;

/*Problem Description
        You are given a matrix A of size N x 2 which represents different operations.
        Assume initially you have a stack-like data structure you have to perform operations on it.

        Operations are of two types:
        1 x: push an integer x onto the stack and return -1.
        2 0: remove and return the most frequent element in the stack.
        If there is a tie for the most frequent element, the element closest to the top of the
        stack is removed and returned.

        A[i][0] describes the type of operation to be performed.
        A[i][1] describe the element x or 0 corresponding to the operation performed.

        Problem Constraints
        1 <= N <= 100000
        1 <= A[i][0] <= 2
        0 <= A[i][1] <= 109

        Input Format
        The only argument given is the integer array A.

        Output Format
        Return the array of integers denoting the answer to each operation.

        Example Input
        Input 1:
        A = [
        [1, 5]
        [1, 7]
        [1, 5]
        [1, 7]
        [1, 4]
        [1, 5]
        [2, 0]
        [2, 0]
        [2, 0]
        [2, 0]  ]
        Input 2:
        A =  [
        [1, 5]
        [2, 0]
        [1, 4]   ]

        Example Output
        Output 1:
        [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
        Output 2:
        [-1, 5, -1]

        Example Explanation
        Explanation 1:
        Just simulate given operations.
        Explanation 2:
        Just simulate given operations.*/
public class MaximumFrequencyStack {
    public static int[] solve(int[][] A) {
        int arr[] = new int[A.length];
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        HashMap<Integer, Stack<Integer>> freqmap = new HashMap<Integer, Stack<Integer>>();
        int maxfreq = 0;
        for (int i = 0; i < A.length; i++) {
            int x = A[i][0];
            if (x == 1) {
                int y = A[i][1];
                arr[i] = -1;
                int freq = hmap.getOrDefault(y, 0) + 1;
                hmap.put(y, freq);
                maxfreq = Math.max(freq, maxfreq);
                if (!freqmap.containsKey(freq)) {
                    freqmap.put(freq, new Stack<Integer>());
                }
                freqmap.get(freq).add(y);
            } else if (x == 2) {
                arr[i] = freqmap.get(maxfreq).peek();
                freqmap.get(maxfreq).pop();
                hmap.put(arr[i], hmap.get(arr[i]) - 1);
                if (freqmap.get(maxfreq).size() == 0) {
                    maxfreq--;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] A = {
                {1, 5},
                {1, 7},
                {1, 5},
                {1, 7},
                {1, 4},
                {1, 5},
                {2, 0},
                {2, 0},
                {2, 0},
                {2, 0}
        };
        System.out.println(solve(A));
    }
}
