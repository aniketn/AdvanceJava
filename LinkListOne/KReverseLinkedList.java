package scaler.Adv.LinkListOne;

import scaler.Intermediate.LinkedListBasics.ListNode;

/*Problem Description
        Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return
        the modified linked list.

        Problem Constraints
        1 <= |A| <= 103
        B always divides A

        Input Format
        The first argument of input contains a pointer to the head of the linked list.
        The second arugment of input contains the integer, B.

        Output Format
        Return a pointer to the head of the modified linked list.

        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5, 6]
        B = 2
        Input 2:
        A = [1, 2, 3, 4, 5, 6]
        B = 3

        Example Output
        Output 1:
        [2, 1, 4, 3, 6, 5]
        Output 2:
        [3, 2, 1, 6, 5, 4]

        Example Explanation
        Explanation 1:
        For the first example, the list can be reversed in groups of 2.
        [[1, 2], [3, 4], [5, 6]]
        After reversing the K-linked list
        [[2, 1], [4, 3], [6, 5]]
        Explanation 2:
        For the second example, the list can be reversed in groups of 3.
        [[1, 2, 3], [4, 5, 6]]
        After reversing the K-linked list
        [[3, 2, 1], [6, 5, 4]]*/
public class KReverseLinkedList {
    public static ListNode reverseList(ListNode A, int B) {
        if (A == null || B == 0) {
            return A;
        }
        ListNode current = A;
        ListNode next = null;
        ListNode prev = A;
        int tempB = B;
        while (B > 0 && current != null) {
            ListNode temp = current;
            current = current.next;
            temp.next = next;
            next = temp;
            B--;
        }
        prev.next = reverseList(current, tempB);
        return next;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(5);
        ListNode F = new ListNode(6);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;
        reverseList(A, 2);
    }
}
