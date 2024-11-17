package scaler.Adv.QueueOne;

import java.util.Deque;
import java.util.LinkedList;

/*Problem Description
        Given an array A of both positive and negative integers.
        Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
        NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.

        Problem Constraints
        1 <= size of array A <= 105
        -109 <= A[i] <= 109
        1 <= B <= size of array

        Input Format
        The first argument denotes the integer array A.
        The second argument denotes the value B

        Output Format
        Return an integer that denotes the required value.

        Example Input
        Input 1:
        A = [2, 5, -1, 7, -3, -1, -2]
        B = 4
        Input 2:
        A = [2, -1, 3]
        B = 2

        Example Output
        Output 1:
        18
        Output 2:
        3

        Example Explanation
        Explanation 1:
        Subarrays of size 4 are :
        [2, 5, -1, 7],   min + max = -1 + 7 = 6
        [5, -1, 7, -3],  min + max = -3 + 7 = 4
        [-1, 7, -3, -1], min + max = -3 + 7 = 4
        [7, -3, -1, -2], min + max = -3 + 7 = 4
        Sum of all min & max = 6 + 4 + 4 + 4 = 18
        Explanation 2:
        Subarrays of size 2 are :
        [2, -1],   min + max = -1 + 2 = 1
        [-1, 3],   min + max = -1 + 3 = 2
        Sum of all min & max = 1 + 2 = 3*/
public class SumOfMinAndMax {
    public static int solve(int[] A, int B) {
        Deque<Integer> maxq = new LinkedList<>();//will be in decreasing order
        Deque<Integer> minq = new LinkedList<>();//will be in increasing order
        int n = A.length;
        long min = 0l;
        long max = 0l;
        int mod = 1000000007;

        //implementing 1st window
        for (int i = 0; i < B; i++) {
            while (!maxq.isEmpty() && maxq.getLast() < A[i])
                maxq.removeLast();
            maxq.addLast(A[i]);

            while (!minq.isEmpty() && minq.getLast() > A[i])
                minq.removeLast();
            minq.addLast(A[i]);
        }

        //clculate contri of first window
        min = (min + minq.getFirst()) % mod;
        max = (max + maxq.getFirst()) % mod;

        int i = B;
        while (i < n) {
            int outgoing = A[i - B];
            int incoming = A[i];
            //removing the outgoing element from minq if exists
            if (minq.getFirst() == outgoing)
                minq.removeFirst();
            //removing the outgoing element from maxq if exists
            if (maxq.getFirst() == outgoing)
                maxq.removeFirst();

            //inserting incoming element in maxq
            while (!maxq.isEmpty() && maxq.getLast() < incoming)
                maxq.removeLast();
            maxq.addLast(incoming);
            //inserting incoming element in minq
            while (!minq.isEmpty() && minq.getLast() > incoming)
                minq.removeLast();
            minq.addLast(incoming);

            min = (min + minq.getFirst()) % mod;
            max = (max + maxq.getFirst()) % mod;
            i++;
        }

        return (int) (min % mod + max % mod + mod) % mod;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {2, 5, -1, 7, -3, -1, -2};
        System.out.println(solve(A, 4));
    }
}
