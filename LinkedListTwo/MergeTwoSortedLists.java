package scaler.Adv.LinkedListTwo;

import scaler.Intermediate.LinkedListBasics.ListNode;

/*Problem Description
        Merge two sorted linked lists, A and B, and return it as a new list.
        The new list should be made by splicing together the nodes of the first two lists and should also be sorted.

        Problem Constraints
        0 <= |A|, |B| <= 105

        Input Format
        The first argument of input contains a pointer to the head of linked list A.
        The second argument of input contains a pointer to the head of linked list B.

        Output Format
        Return a pointer to the head of the merged linked list.

        Example Input
        Input 1:
        A = 5 -> 8 -> 20
        B = 4 -> 11 -> 15
        Input 2:
        A = 1 -> 2 -> 3
        B = Null

        Example Output
        Output 1:
        4 -> 5 -> 8 -> 11 -> 15 -> 20
        Output 2:
        1 -> 2 -> 3

        Example Explanation
        Explanation 1:
        Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
        Explanation 2:
        We don't need to merge as B is empty. */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode ans = null;
        ListNode temp = null;

        // Assigning the head of the ans
        if (A.val < B.val) {
            ans = A;
            temp = A;
            A = A.next;
        } else {
            ans = B;
            temp = B;
            B = B.next;
        }

        //Merge two sorted arrays
        while (A != null && B != null) {
            if (A.val < B.val) {
                temp.next = A;
                temp = temp.next;
                A = A.next;
            } else {
                temp.next = B;
                temp = temp.next;
                B = B.next;
            }
        }

        //adding the remaining elements

        if (A != null) {
            temp.next = A;
        }
        if (B != null) {
            temp.next = B;
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode A = new ListNode(13);
        ListNode B = new ListNode(24);
        ListNode C = new ListNode(36);
        ListNode D = new ListNode(48);
        ListNode E = new ListNode(51);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;

        ListNode F = new ListNode(10);
        ListNode G = new ListNode(23);
        ListNode H = new ListNode(34);
        ListNode I = new ListNode(45);
        ListNode J = new ListNode(56);
        F.next = G;
        G.next = H;
        H.next = I;
        I.next = J;
        System.out.println(mergeTwoLists(A, F));
    }
}
