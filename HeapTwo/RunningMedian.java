package scaler.Adv.HeapTwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Problem Description
        Given an array of integers, A denoting a stream of integers.
        New arrays of integer B and C are formed.
        Each time an integer is encountered in a stream,
        append it at the end of B and append the median of array B at the C.

        Find and return the array C.
        NOTE:
        If the number of elements is N in B and N is odd,
        then consider the median as B[N/2] ( B must be in sorted order).
        If the number of elements is N in B and N is even,
        then consider the median as B[N/2-1]. ( B must be in sorted order).

        Problem Constraints
        1 <= length of the array <= 100000
        1 <= A[i] <= 109

        Input Format
        The only argument given is the integer array A.

        Output Format
        Return an integer array C, C[i] denotes the median of the first i elements.

        Example Input
        Input 1:
        A = [1, 2, 5, 4, 3]
        Input 2:
        A = [5, 17, 100, 11]

        Example Output
        Output 1:
        [1, 1, 2, 2, 3]
        Output 2:
        [5, 5, 17, 11]*/
public class RunningMedian {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < A.size(); i++) {
            // Add element to minHeap or maxHeap based on the value of last element of MaxHeap
            if (maxHeap.isEmpty() || A.get(i) < maxHeap.peek())
                maxHeap.add(A.get(i));
            else minHeap.add(A.get(i));

            // If maxHeap size exceeds more than 1 of the difference with minHeap
            // then transfter element from maxHeap to minHeap
            if (maxHeap.size() - minHeap.size() > 1)
                minHeap.add(maxHeap.remove());

            // If minHeap size is exceeds the size of maxHeap transfter the element from minHeap to maxHeap
            if (minHeap.size() - maxHeap.size() >= 1)
                maxHeap.add(minHeap.remove());

            // Last element of maxHeap will always be our median, don’t need to check odd/even elements
            res.add(maxHeap.peek());
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(5);
        A.add(17);
        A.add(100);
        A.add(11);
        //A.add(3);
        System.out.println(solve(A));
    }
}
