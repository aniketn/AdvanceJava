package scaler.Adv.LinkListOne;

import java.util.HashMap;

/*Problem Description

        Given a linked list **A**, remove the **B-th** node from the end of the list and return its head.
        For example, Given linked list: `1->2->3->4->5`, and `B = 2`.
        After removing the second node from the end, the linked list becomes `1->2->3->5`.
        **NOTE:** If **B** is greater than the size of the list, remove the first node of the list.
        **NOTE:** Try doing it using constant additional space.

        Problem Constraints
        1 <= |A| <= 106
        Input Format
        The first argument of input contains a pointer to the head of the linked list.
        The second argument of input contains the integer B.
        Output Format
        Return the head of the linked list after deleting the B-th element from the end.
        Example Input
        Input 1:
        A = 1->2->3->4->5
        B = 2
        Input 2:
        A = 1
        B = 1
        Example Output
        Output 1:
        1->2->3->5
        Output 2:
        Example Explanation
        Explanation 1:
        In the first example, 4 is the second last element.
        Explanation 2:
        In the second example, 1 is the first and the last element.*/
public class RemoveNthNodeFromListEnd {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
    }
    public static ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode start = new ListNode();
        start.next = A;
        ListNode fast = start;
        ListNode slow = start;

        for(int i = 1; i <= B; ++i)
            fast = fast.next;

        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return start.next;
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
        removeNthFromEnd(A, 2);
    }
}
