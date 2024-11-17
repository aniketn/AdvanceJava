package scaler.Adv.LinkedListTwo;

import scaler.Intermediate.LinkedListBasics.ListNode;

/*Problem Description
        Given a linked list A, swap every two adjacent nodes and return its head.
        NOTE: Your algorithm should use only constant space. You may not modify the values in the list;
        only nodes themselves can be changed.

        Problem Constraints
        1 <= |A| <= 106

        Input Format
        The first and the only argument of input contains a pointer to the head of the given linked list.
        Output Format
        Return a pointer to the head of the modified linked list.

        Example Input
        Input 1:
        A = 1 -> 2 -> 3 -> 4
        Input 2:
        A = 7 -> 2 -> 1

        Example Output
        Output 1:
        2 -> 1 -> 4 -> 3
        Output 2:
        2 -> 7 -> 1

        Example Explanation
        Explanation 1:
        In the first example (1, 2) and (3, 4) are the adjacent nodes. Swapping them will result in 2 -> 1 -> 4 -> 3
        Explanation 2:
        In the second example, 3rd element i.e. 1 does not have an adjacent node, so it won't be swapped. */
public class SwapListNodesInPairs {
    public static ListNode swapPairs(ListNode A) {
        if(A!=null && A.next!=null)
        {
            /* Swap the node's data with data of next node */
            int temp = A.val;
            A.val = A.next.val;
            A.next.val = temp;

            swapPairs(A.next.next);
        }
        return A;
       /* if (A.next == null) return A;
        ListNode p1 = A, p2 = A.next;
        ListNode head1 = p1, head2 = p2;
        while (p2.next != null && p2.next.next != null) {
            p1.next = p1.next.next;
            p2.next = p2.next.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p2.next == null) {
            p1.next = null;
        } else {
            p1.next = p1.next.next;
            p1 = p1.next;
            p1.next = null;
            p2.next = null;
        }
        ListNode temp1 = head2, temp2 = head1, prev = null;
        ListNode dummy = new ListNode(-1);
        prev = dummy;
        while (temp1 != null && temp2 != null) {
            prev.next = temp1;
            prev = prev.next;
            temp1 = temp1.next;
            prev.next = temp2;
            prev = prev.next;
            temp2 = temp2.next;
        }
        if (temp1 != null) prev.next = temp1;
        if (temp2 != null) prev.next = temp2;

        return dummy.next;*/
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        A.next = B;
        B.next = C;
        C.next = D;
        System.out.println(swapPairs(A));
    }
}

