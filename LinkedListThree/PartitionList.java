package scaler.Adv.LinkedListThree;

import scaler.Intermediate.LinkedListBasics.ListNode;

/*Problem Description
        Given a linked list A and a value B, partition it such that all nodes less than B come
        before nodes greater than or equal to B.
        You should preserve the original relative order of the nodes in each of the two partitions.

        Problem Constraints
        1 <= |A| <= 106
        1 <= A[i], B <= 109

        Input Format
        The first argument of input contains a pointer to the head to the given linked list.
        The second argument of input contains an integer, B.

        Output Format
        Return a pointer to the head of the modified linked list.

        Example Input
        Input 1:
        A = [1, 4, 3, 2, 5, 2]
        B = 3
        Input 2:
        A = [1, 2, 3, 1, 3]
        B = 2

        Example Output
        Output 1:
        [1, 2, 2, 4, 3, 5]
        Output 2:
        [1, 1, 2, 3, 3]

        Example Explanation
        Explanation 1:
        [1, 2, 2] are less than B wheread [4, 3, 5] are greater than or equal to B.
        Explanation 2:
        [1, 1] are less than B wheread [2, 3, 3] are greater than or equal to B.*/
public class PartitionList {
    public static ListNode partition(ListNode A, int B) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode temp = A, prev1 = dummy1, prev2 = dummy2;
        while (temp != null) {
            if (temp.val < B) {
                prev1.next = temp;
                prev1 = prev1.next;
            } else {
                prev2.next = temp;
                prev2 = prev2.next;
            }
            temp = temp.next;
        }
        prev2.next = null;
        prev1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(4);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(2);
        ListNode E = new ListNode(5);
        ListNode F = new ListNode(2);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        E.next = F;
        System.out.println(partition(A,3));
    }
}
