package scaler.Adv.LinkedListTwo;

import scaler.Intermediate.LinkedListBasics.ListNode;

/*Problem Description
        Sort a linked list, A in O(n log n) time using constant space complexity.

        Problem Constraints
        0 <= |A| = 105

        Input Format
        The first and the only arugment of input contains a pointer to the head of the linked list, A.

        Output Format
        Return a pointer to the head of the sorted linked list.

        Example Input
        Input 1:
        A = [3, 4, 2, 8]
        Input 2:
        A = [1]

        Example Output
        Output 1:
        [2, 3, 4, 8]
        Output 2:
        [1]

        Example Explanation
        Explanation 1:
        The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
        Explanation 2:
        The sorted form of [1] is [1].*/
public class SortList {
    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) return A;
        ListNode mid = solve(A);
        ListNode A1 = A, B1 = mid.next;
        mid.next = null;
        A1 = sortList(A1);
        B1 = sortList(B1);
        return mergeTwoLists(A1, B1);
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(-1);
        ListNode tempA = A, tempB = B, current = dummy;
        while (tempA != null && tempB != null) {
            if (tempA.val <= tempB.val) {
                current.next = tempA;
                tempA = tempA.next;
            } else {
                current.next = tempB;
                tempB = tempB.next;
            }
            current = current.next;
        }
        if (tempA != null) current.next = tempA;
        if (tempB != null) current.next = tempB;
        return dummy.next;
    }

    public ListNode solve(ListNode A) {
        ListNode fast = A, slow = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
