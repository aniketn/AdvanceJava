package scaler.Adv.QueueOne;

import java.util.Deque;
import java.util.LinkedList;

/*Problem Description
        Given an array of integers A. There is a sliding window of size B,
        moving from the very left of the array to the very right.
        You can only see the B numbers in the window. Each time the sliding window moves
        rightwards by one position. You have to find the maximum for each window.

        Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
        Refer to the given example for clarity.
        NOTE: If B > length of the array, return 1 element with the max of the array.

        Problem Constraints
        1 <= |A|, B <= 106

        Input Format
        The first argument given is the integer array A.
        The second argument given is the integer B.

        Output Format
        Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].

        Example Input
        Input 1:
        A = [1, 3, -1, -3, 5, 3, 6, 7]
        B = 3
        Input 2:
        A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
        B = 6

        Example Output
        Output 1:
        [3, 3, 5, 5, 6, 7]
        Output 2:
        [7, 7, 7, 7]

        Example Explanation
        Explanation 1:
        Window position     | Max
        --------------------|-------
        [1 3 -1] -3 5 3 6 7 | 3
        1 [3 -1 -3] 5 3 6 7 | 3
        1 3 [-1 -3 5] 3 6 7 | 5
        1 3 -1 [-3 5 3] 6 7 | 5
        1 3 -1 -3 [5 3 6] 7 | 6
        1 3 -1 -3 5 [3 6 7] | 7
        Explanation 2:
        Window position     | Max
        --------------------|-------
        [1 2 3 4 2 7] 1 3 6 | 7
        1 [2 3 4 2 7 1] 3 6 | 7
        1 2 [3 4 2 7 1 3] 6 | 7
        1 2 3 [4 2 7 1 3 6] | 7*/
public class SlidingWindowMaximum {
    public static int[] slidingMaximum(final int[] A, int k) {
        int n = A.length;
        int[] ans = new int[n - k + 1];
        //need double ended queue in this beacuse need to insert element from end and remove from end and front both
        Deque<Integer> q = new LinkedList<>();

        //1st window
        for (int i = 0; i < k; i++) {
            if (q.isEmpty())
                q.add(A[i]);
            else {
                if (q.getLast() >= A[i])
                    q.addLast(A[i]);
                else {
                    while (!q.isEmpty() && q.getLast() < A[i])
                        q.removeLast();
                    q.add(A[i]);
                }
            }
        }
        int index = 0;
        ans[index++] = q.peek();
        int i = k;

        //rest of the windows
        while (i < n) {
            int outgoing = A[i - k];
            int incoming = A[i];
            if (q.getFirst() == outgoing)
                q.removeFirst();
            while (!q.isEmpty() && q.getLast() < incoming)
                q.removeLast();
            q.add(incoming);
            ans[index++] = q.peek();
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(slidingMaximum(A, 3));
    }
}
