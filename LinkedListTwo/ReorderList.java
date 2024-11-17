package scaler.Adv.LinkedListTwo;
/*Problem Description
        Given a singly linked list A
        A: A0 → A1 → … → An-1 → An
        reorder it to:
        A0 → An → A1 → An-1 → A2 → An-2 → …
        You must do this in-place without altering the nodes' values.

        Problem Constraints
        1 <= |A| <= 106

        Input Format
        The first and the only argument of input contains a pointer to the head of the linked list A.

        Output Format
        Return a pointer to the head of the modified linked list.

        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5]
        Input 2:
        A = [1, 2, 3, 4]

        Example Output
        Output 1:
        [1, 5, 2, 4, 3]
        Output 2:
        [1, 4, 2, 3]

        Example Explanation
        Explanation 1:
        The array will be arranged to [A0, An, A1, An-1, A2].
        Explanation 2:
        The array will be arranged to [A0, An, A1, An-1, A2].*/


import scaler.Intermediate.LinkedListBasics.ListNode;

//Approach
/*Here we will be using multiple LinkedList concepts to solve this in very simple way.


        Pre-requisite:
        Solve “How to find the Mid of LinkedList” first
        Solve “How to reverse a LinkedList” first
        Approach:
        If you have already solved above problems then
        it will be very easy to solve this problem even though it is categorized as “Very Hard”.
        It’s hard only because using multiple concepts together.

        If you have observed then it’s like whatever elements are there after
        middle of LinkedList those are reversed and reorder with the first half’s element consecutively.
        E.g. Input: 1->2->3->4->5
        If you find mid of this LinkedList then it will be 3. Now if you say all
        element after middle a second LinkedList and reverse it then it will become.
        L1: 1->2->3
        L2: 4->5
        Reverse the L2 LinkedList then it will become:
        L2’: 5->4
        Now rearrange in such a way that pick one element from L1 and next from L2(start picking from L1).
        L1: 1->2->3
        L2’:5->4
        Result: 1->5->2->4->3

        Time Complexity: O(N)
        Space Complexity: O(1)

        Summary Steps to solve:
        Find the middle element of given LinkedList first
        Separate next of middle element and give that element as L2 which will be head of second LinkedList
        Reverse Second LinkedList
        Merge both the LinkedList. Pick first element from first LinkedList. Next element from second LinkedList. Next element from first Linkedlist, so on…
        Return head of result LinkedList.*/
public class ReorderList {
    public static ListNode reorderList(ListNode A) {
        if (A == null) return A;

        // Find mid of a linkedlist(using slow and fast pointer)
        ListNode slow = A;
        ListNode fast = A;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next != null ? fast.next.next : fast.next;
        }

        // Seperate second list after mid to linkedlist2 and make its head as head2
        ListNode head2 = slow.next;
        slow.next = null;

        // Reverse second linkedlist
        ListNode reverseHead = null;
        ListNode temp = null;
        while (head2 != null) {
            temp = head2;
            head2 = head2.next;
            temp.next = reverseHead;
            reverseHead = temp;
        }

        // Now reverseHead is the head of reversed linkedlist, and A is the head of the first linkedlist
        ListNode resultHead = A;
        temp = resultHead;
        boolean isFirstTurn = false; // Toggle this variable and check where to fetch our next node from
        A = A.next;

        // Merge Both LinkedList
        while (A != null && reverseHead != null) {
            if (isFirstTurn) {
                temp.next = A;
                A = A.next;
                temp = temp.next;
                isFirstTurn = false;
            } else {
                temp.next = reverseHead;
                reverseHead = reverseHead.next;
                temp = temp.next;
                isFirstTurn = true;
            }
        }

        if (A != null) {
            temp.next = A;
        }
        return resultHead;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode A = new ListNode(1);
        ListNode B = new ListNode(2);
        ListNode C = new ListNode(3);
        ListNode D = new ListNode(4);
        ListNode E = new ListNode(5);
        A.next = B;
        B.next = C;
        C.next = D;
        D.next = E;
        System.out.println(reorderList(A));
    }
}
