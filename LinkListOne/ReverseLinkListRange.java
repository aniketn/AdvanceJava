package scaler.Adv.LinkListOne;
/*Problem Description
        Reverse a linked list A from position B to C.
        NOTE: Do it in-place and in one-pass.

        Problem Constraints
        1 <= |A| <= 106
        1 <= B <= C <= |A|

        Input Format
        The first argument contains a pointer to the head of the given linked list, A.
        The second arugment contains an integer, B.
        The third argument contains an integer C.

        Output Format
        Return a pointer to the head of the modified linked list.

        Example Input
        Input 1:
        A = 1 -> 2 -> 3 -> 4 -> 5
        B = 2
        C = 4
        Input 2:
        A = 1 -> 2 -> 3 -> 4 -> 5
        B = 1
        C = 5

        Example Output
        Output 1:
        1 -> 4 -> 3 -> 2 -> 5
        Output 2:
        5 -> 4 -> 3 -> 2 -> 1

        Example Explanation
        Explanation 1:
        In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
        Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
        Explanation 2:
        In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
        Thus, the output is 5 -> 4 -> 3 -> 2 -> 1*/

import scaler.Intermediate.LinkedListBasics.ListNode;

public class ReverseLinkListRange {
    public static ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null || A.next == null || B == C)
            return A;
        ListNode curr = A, p1 = null, p2 = null, temp, prev = null;

        for (int i = 1; i < B; i++) {
            p1 = curr;      //just previous Node to B
            curr = curr.next;
        }

        p2 = curr;      //end of reversedList

        while (B <= C) {          //reversing the sublist
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            B++;
        }

        if (p1 != null)      //some elems before B are present
            p1.next = prev;
        else
            A = prev;

        p2.next = curr;

        return A;
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
        reverseBetween(A, 2,4);
    }
}
