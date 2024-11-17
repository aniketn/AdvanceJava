package scaler.Adv.HeapOne;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*Problem Description
        Given a list containing head pointers of N sorted linked lists.
        Merge these given sorted linked lists and return them as one sorted list.

        Problem Constraints
        1 <= total number of elements in given linked lists <= 100000

        Input Format
        The first and only argument is a list containing N head pointers.

        Output Format
        Return a pointer to the head of the sorted linked list after merging all the given linked lists.

        Example Input
        Input 1:
        1 -> 10 -> 20
        4 -> 11 -> 13
        3 -> 8 -> 9
        Input 2:
        10 -> 12
        13
        5 -> 6

        Example Output
        Output 1:
        1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
        Output 2:
        5 -> 6 -> 10 -> 12 ->13

        Example Explanation
        Explanation 1:
        The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
        Explanation 2:
        The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.*/
public class MergeKSortedLists {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((c, b) -> c.val - b.val);
        for (ListNode node : a) pq.add(node);
        ListNode head = pq.poll();
        ListNode temp = head;
        if (head.next != null)
            pq.add(head.next);
        while (!pq.isEmpty()) {
            temp.next = pq.poll();
            temp = temp.next;
            if (temp.next != null)
                pq.add(temp.next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode A = new ListNode(10);
        ListNode B = new ListNode(12);
        ListNode C = new ListNode(13);
        ListNode D = new ListNode(5);
        ListNode E = new ListNode(6);
        A.next = B;
        B.next = null;
        C.next = null;
        D.next = E;
        E.next = null;
        ArrayList<ListNode> arr = new ArrayList<>();
        arr.add(A);
        arr.add(C);
        arr.add(D);
        mergeKLists(arr);
    }
}
