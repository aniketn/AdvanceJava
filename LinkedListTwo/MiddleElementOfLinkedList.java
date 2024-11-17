package scaler.Adv.LinkedListTwo;

import scaler.Intermediate.LinkedListBasics.ListNode;

/*Problem Description
        Given a linked list of integers, find and return the middle element of the linked list.
        NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.

        Problem Constraints
        1 <= length of the linked list <= 100000
        1 <= Node value <= 109

        Input Format
        The only argument given head pointer of linked list.

        Output Format
        Return the middle element of the linked list.

        Example Input
        Input 1:
        1 -> 2 -> 3 -> 4 -> 5
        Input 2:
        1 -> 5 -> 6 -> 2 -> 3 -> 4

        Example Output
        Output 1:        3
        Output 2:        2


        Example Explanation
        Explanation 1:
        The middle element is 3.
        Explanation 2:
        The middle element in even length linked list of length N is ((N/2) + 1)th element which is 2.*/
public class MiddleElementOfLinkedList {
    public static int solve(ListNode A) {
        ListNode head = A;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next == null){
            return slow.val;
        }
        return slow.next.val;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(5);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        System.out.println(solve(A));
    }
}
