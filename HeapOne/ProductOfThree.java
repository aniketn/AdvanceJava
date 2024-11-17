package scaler.Adv.HeapOne;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Problem Description
        Given an integer array A of size N.
        You have to find the product of the three largest integers in array A
        from range 1 to i, where i goes from 1 to N.

        Return an array B where B[i] is the product of the largest 3
        integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.

        Problem Constraints
        1 <= N <= 105
        0 <= A[i] <= 103

        Input Format
        First and only argument is an integer array A.

        Output Format
        Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.

        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5]
        Input 2:
        A = [10, 2, 13, 4]

        Example Output
        Output 1:
        [-1, -1, 6, 24, 60]
        Output 2:
        [-1, -1, 260, 520]

        Example Explanation
        Explanation 1:
        For i = 1, ans = -1
        For i = 2, ans = -1
        For i = 3, ans = 1 * 2 * 3 = 6
        For i = 4, ans = 2 * 3 * 4 = 24
        For i = 5, ans = 3 * 4 * 5 = 60
        So, the output is [-1, -1, 6, 24, 60].
        Explanation 2:
        For i = 1, ans = -1
        For i = 2, ans = -1
        For i = 3, ans = 10 * 2 * 13 = 260
        For i = 4, ans = 10 * 13 * 4 = 520
        So, the output is [-1, -1, 260, 520].*/
public class ProductOfThree {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {

        // Create result ArrayList
        ArrayList<Integer> result = new ArrayList<Integer>();

        // Create minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Comparator.naturalOrder());
        int count = 1;
        // Will add first 3 integers to minHeap
        for (int i = 0; i < Math.min(3, A.size()); i++) {
            minHeap.add(A.get(i));
            count = count * A.get(i);
            if (i < 2) result.add(-1);
            else result.add(count);
        }

        // Traverse from 3 to N-1
        // Remove min element if current element > min, remove min from count by dividing and add new element to count by multiplying
        if (A.size() > 3) {
            for (int i = 3; i < A.size(); i++) {
                if (A.get(i) > minHeap.peek()) {
                    int removedElement = minHeap.remove();
                    count = count / removedElement;
                    count = count * A.get(i);
                    minHeap.add(A.get(i));
                }
                result.add(count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(5);
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(1);
       /* A.add(38);
        A.add(31);
        A.add(-7);
        A.add(-28);
        A.add(-61);*/
        System.out.println(solve(A));
    }

}
