package scaler.Adv.LinkedListThree;

import scaler.Intermediate.LinkedListBasics.ListNode;

/*Problem Description
        Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting
         if it's a palindrome or not, respectively.

        Problem Constraints
        1 <= |A| <= 105

        Input Format
        The first and the only argument of input contains a pointer to the head of the given linked list.

        Output Format
        Return 0, if the linked list is not a palindrome.
        Return 1, if the linked list is a palindrome.

        Example Input
        Input 1:
        A = [1, 2, 2, 1]
        Input 2:
        A = [1, 3, 2]

        Example Output
        Output 1:
        1
        Output 2:
        0
        Example Explanation
        Explanation 1:
        The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
        Explanation 2:
        The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].*/
public class PalindromeList {
    public static int lPalin(ListNode A) {
        //Find middle list (doing this we can divide two parts)
        ListNode slow = A;
        ListNode fast = A;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second half that is after the middle list
        slow.next = reverseList(slow.next);
        // slow moves ahead to second half
        slow = slow.next;
        // comapring first half value and second half value whether they are equal or not
        while (slow != null) {
            if (A.val != slow.val) {
                return 0;
            }
            slow = slow.next;
            A = A.next;
        }
        return 1;
    }

    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(2);
        ListNode D = new ListNode(1);
        A.next = B;
        B.next = C;
        C.next = D;
        System.out.println(lPalin(A));
    }
}
