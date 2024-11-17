package scaler.Adv.HeapTwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/*Problem Description
        N people having different priorities are standing in a queue.
        The queue follows the property that each person is standing
        at most B places away from its position in the sorted queue.
        Your task is to sort the queue in the increasing order of priorities.

        NOTE:
        No two persons can have the same priority.
        Use the property of the queue to sort the queue with complexity O(NlogB).

        Problem Constraints
        1 <= N <= 100000
        0 <= B <= N

        Input Format
        The first argument is an integer array A representing the priorities and initial order of N persons.
        The second argument is an integer B.

        Output Format
        Return an integer array representing the sorted queue.

        Example Input
        Input 1:
        A = [1, 40, 2, 3]
        B = 2
        Input 2:
        A = [2, 1, 17, 10, 21, 95]
        B = 1

        Example Output
        Output 1:
        [1, 2, 3, 40]
        Output 2:
        [1, 2, 10, 17, 21, 95]

        Example Explanation
        Explanation 1:
        Given array A = [1, 40, 2, 3]
        After sorting, A = [1, 2, 3, 40].
        We can see that difference between initial position of elements amd the final position <= 2.
        Explanation 2:
        After sorting, the array becomes [1, 2, 10, 17, 21, 95].*/
public class KPlacesApart {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Comparator.naturalOrder());

        for (int i = 0; i < A.size(); i++) {
            minHeap.add(A.get(i));
        }
        A.clear();
        while (!minHeap.isEmpty()) {
            A.add(minHeap.remove());
        }
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(40);
        A.add(2);
        A.add(3);
        //A.add(3);
        System.out.println(solve(A, 2));
    }
}
