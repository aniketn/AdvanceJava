package scaler.Adv.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Problem Description
        Given an 2D integer array A of size N x 2 denoting time intervals of different meetings.

        Where:

        A[i][0] = start time of the ith meeting.
        A[i][1] = end time of the ith meeting.

        Find the minimum number of conference rooms required so that all meetings can be done.

        Note :- If a meeting ends at time t, another meeting starting at time t can use the same conference room

        Problem Constraints
        1 <= N <= 105
        0 <= A[i][0] < A[i][1] <= 2 * 109

        Input Format
        The only argument given is the matrix A.

        Output Format
        Return the minimum number of conference rooms required so that all meetings can be done.

        Example Input
        Input 1:
        A = [      [0, 30]
        [5, 10]
        [15, 20]
        ]
        Input 2:
        A =  [     [1, 18]
        [18, 23]
        [15, 29]
        [4, 15]
        [2, 11]
        [5, 13]
        ]

        Example Output
        Output 1:
        2
        Output 2:
        4

        Example Explanation
        Explanation 1:
        Meeting one can be done in conference room 1 form 0 - 30.
        Meeting two can be done in conference room 2 form 5 - 10.
        Meeting three can be done in conference room 2 form 15 - 20 as it is free in this interval.
        Explanation 2:
        Meeting one can be done in conference room 1 from 1 - 18.
        Meeting five can be done in conference room 2 from 2 - 11.
        Meeting four can be done in conference room 3 from 4 - 15.
        Meeting six can be done in conference room 4 from 5 - 13.
        Meeting three can be done in conference room 2 from 15 - 29 as it is free in this interval.
        Meeting two can be done in conference room 4 from 18 - 23 as it is free in this interval.*/
public class MeetingsRoom {
    static class Comp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        }
    }

    public static int solve(int[][] A) {
        //Find the number of intervals that can be merged together.
        if (A.length == 0)
            return 0;

        Arrays.sort(A, new Comp());
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        qu.add(A[0][1]); //end time of first function

        for (int i = 1; i < A.length; i++) {
            if (qu.peek() <= A[i][0])
                qu.poll();
            qu.add(A[i][1]);
        }
        return qu.size();
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,18},{18,23},{15,29},{4,15},{2,11},{5,13}};
        System.out.println(solve(A));
    }
}
