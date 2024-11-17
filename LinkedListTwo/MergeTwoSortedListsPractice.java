package scaler.Adv.LinkedListTwo;

public class MergeTwoSortedListsPractice {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode ans = null, temp = null;

        //Assigning head of the merge list
        if (A.val < B.val) {
            ans = A;
            temp = A;
            A = A.next;
        } else {
            ans = B;
            temp = B;
            B = B.next;
        }

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

        if (A != null) {
            temp.next = A;
        }

        if (B != null) {
            temp.next = B;
        }

        return ans;
    }
}
