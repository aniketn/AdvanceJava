package scaler.Adv.LinkedListThree;

import scaler.Intermediate.LinkedListBasics.ListNode;

/*Problem Description
        Given a linked list of integers. Find and return the length of the longest palindrome
        list that exists in that linked list.
        A palindrome list is a list that reads the same backward and forward.
        Expected memory complexity : O(1)

        Problem Constraints
        1 <= length of the linked list <= 2000
        1 <= Node value <= 100

        Input Format
        The only argument given is head pointer of the linked list.

        Output Format
        Return the length of the longest palindrome list.

        Example Input
        Input 1:
        2 -> 3 -> 3 -> 3
        Input 2:
        2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2

        Example Output
        Output 1:
        3
        Output 2:
        5

        Example Explanation
        Explanation 1:
        3 -> 3 -> 3 is largest palindromic sublist
        Explanation 2:
        2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.*/
public class LongestPalindromicList {
    static int countCommon(ListNode a, ListNode b) {
        int count = 0;

        // loop to count common in the list starting
        // from node a and b
        for (; a != null && b != null;
             a = a.next, b = b.next)

            // increment the count for same values
            if (a.val == b.val)
                ++count;
            else
                break;

        return count;
    }

    // Returns length of the longest palindrome
// sublist in given list
    static int maxPalindrome(ListNode head) {
        int result = 0;
        ListNode prev = null, curr = head;

        // loop till the end of the linked list
        while (curr != null) {
            // The sublist from head to current
            // reversed.
            ListNode next = curr.next;
            curr.next = prev;

            // check for odd length
            // palindrome by finding
            // longest common list elements
            // beginning from prev and
            // from next (We exclude curr)
            result = Math.max(result,
                    2 * countCommon(prev, next) + 1);

            // check for even length palindrome
            // by finding longest common list elements
            // beginning from curr and from next
            result = Math.max(result,
                    2 * countCommon(curr, next));

            // update prev and curr for next iteration
            prev = curr;
            curr = next;
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(15);
        System.out.println(maxPalindrome(head));
    }
}
