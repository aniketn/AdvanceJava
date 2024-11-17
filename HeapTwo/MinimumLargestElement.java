package scaler.Adv.HeapTwo;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*Problem Description
        Given an array A of N numbers, you have to perform B operations.
        In each operation, you have to pick any one of the N elements and add
        the original value(value stored at the index before we did any operations)
        to its current value. You can choose any of the N elements in each operation.

        Perform B operations in such a way that the largest element of the modified array(after B operations)
        is minimized.
        Find the minimum possible largest element after B operations.

        Problem Constraints
        1 <= N <= 106
        0 <= B <= 105
        -105 <= A[i] <= 105

        Input Format
        The first argument is an integer array A.
        The second argument is an integer B.

        Output Format
        Return an integer denoting the minimum possible largest element after B operations.

        Example Input
        Input 1:
        A = [1, 2, 3, 4]
        B = 3
        Input 2:
        A = [5, 1, 4, 2]
        B = 5

        Example Output
        Output 1:
        4
        Output 2:
        5

        Example Explanation
        Explanation 1:
        Apply operation on element at index 0, the array would change to [2, 2, 3, 4]
        Apply operation on element at index 0, the array would change to [3, 2, 3, 4]
        Apply operation on element at index 0, the array would change to [4, 2, 3, 4]
        Minimum possible largest element after 3 operations is 4.
        Explanation 2:
        Apply operation on element at index 1, the array would change to [5, 2, 4, 2]
        Apply operation on element at index 1, the array would change to [5, 3, 4, 2]
        Apply operation on element at index 1, the array would change to [5, 4, 4, 2]
        Apply operation on element at index 1, the array would change to [5, 5, 4, 2]
        Apply operation on element at index 3, the array would change to [5, 5, 4, 4]
        Minimum possible largest element after 5 operations is 5.*/
public class MinimumLargestElement {
    public static int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> ((a[0] + a[1]) - (b[0] + b[1])));
        for (int i = 0; i < A.size(); i++)
            pq.add(new int[]{
                    A.get(i), A.get(i)
            });
        while (B > 0) {
            int[] poll = pq.poll();
            pq.add(new int[]{
                    poll[0] + poll[1], poll[1]
            });
            B--;
        }
        int max = Integer.MIN_VALUE;
        while (pq.size() != 0)
            max = Math.max(max, pq.poll()[0]);
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        //A.add(3);
        System.out.println(solve(A, 3));
    }

}
