package scaler.Adv.LinkedListThree;
/*
Problem Description

        Write a program to find the node at which the intersection of two singly linked lists,
        A and B, begins. For example, the following two linked lists:

        A:          a1 → a2
                            ↘
                            c1 → c2 → c3
                            ↗
        B:     b1 → b2 → b3
        NOTE:

        If the two linked lists have no intersection at all, return null.
        The linked lists must retain their original structure after the function returns.
        You may assume there are no cycles anywhere in the entire linked structure.
        Your code should preferably run in O(n) time and use only O(1) memory.
        The custom input to be given is different than the one explained in the examples. Please be careful.

        Problem Constraints
        0 <= |A|, |B| <= 106

        Input Format
        The first argument of input contains a pointer to the head of the linked list A.
        The second argument of input contains a pointer to the head of the linked list B.

        Output Format
        Return a pointer to the node after which the linked list is intersecting.

        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5]
        B = [6, 3, 4, 5]
        Input 2:
        A = [1, 2, 3]
        B = [4, 5]

        Example Output
        Output 1:
        [3, 4, 5]
        Output 2:
        []

        Example Explanation
        Explanation 1:
        In the first example, the nodes have the same values after 3rd node in A and 2nd node in B.
        Thus, the linked lists are intersecting after that point.
        Explanation 2:
        In the second example, the nodes don't have the same values, thus we can return None/Null.
*/

import scaler.Intermediate.LinkedListBasics.ListNode;

public class IntersectionOfLinkedLists {
    public static ListNode getIntersectionNode(ListNode A, ListNode B) {
        if (A == null || B == null) return null;
        ListNode tempB = B, tempA = A, slow = A, fast = A, prev = null;
        while (tempA.next != null) tempA = tempA.next;
        tempA.next = tempB;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) {
            tempA.next = null;
            return null;
        }
        slow = A;
        while (fast != slow) {
            prev = fast;
            fast = fast.next;
            slow = slow.next;
        }
        tempA.next = null;
        return fast;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(5);

        ListNode F = new ListNode(6);
        ListNode G = new ListNode(3);
        ListNode H = new ListNode(4);
        ListNode I = new ListNode(5);

        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;

        F.next = G;
        G.next = H;
        H.next = I;
        System.out.println(getIntersectionNode(A, F));
    }
}
