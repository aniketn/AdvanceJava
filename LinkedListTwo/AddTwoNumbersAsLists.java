package scaler.Adv.LinkedListTwo;

import scaler.Intermediate.LinkedListBasics.ListNode;

/*Problem Description
        You are given two linked lists, A and B, representing two non-negative numbers.
        The digits are stored in reverse order, and each of their nodes contains a single digit.
        Add the two numbers and return it as a linked list.

        Problem Constraints
        1 <= |A|, |B| <= 105

        Input Format
        The first argument of input contains a pointer to the head of linked list A.
        The second argument of input contains a pointer to the head of linked list B.

        Output Format
        Return a pointer to the head of the required linked list.

        Example Input
        Input 1:
        A = [2, 4, 3]
        B = [5, 6, 4]
        Input 2:
        A = [9, 9]
        B = [1]

        Example Output
        Output 1:
        [7, 0, 8]
        Output 2:
        [0, 0, 1]

        Example Explanation
        Explanation 1:
        A = 342 and B = 465. A + B = 807.
        Explanation 2:
        A = 99 and B = 1. A + B = 100.*/
public class AddTwoNumbersAsLists {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode A = new ListNode(3);
        ListNode B = new ListNode(4);
        ListNode C = new ListNode(2);
        A.next = B;
        B.next = C;

        ListNode F = new ListNode(4);
        ListNode G = new ListNode(6);
        ListNode H = new ListNode(5);
        F.next = G;
        G.next = H;
        System.out.println(addTwoNumbers(A, F));
    }
}
