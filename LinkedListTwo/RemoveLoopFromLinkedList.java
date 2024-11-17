package scaler.Adv.LinkedListTwo;

import scaler.Intermediate.LinkedListBasics.ListNode;

/*Problem Description
        You are given a linked list that contains a loop.
        You need to find the node, which creates a loop and break it by making the node point to NULL.

        Problem Constraints
        1 <= number of nodes <= 1000

        Input Format
        The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
        The second line of the input contains an integer which denotes the position of node where cycle starts.

        Output Format
        return the head of the updated linked list.

        Example Input
        Input 1:
        1 -> 2
        ^    |
        | - -
        Input 2:
        3 -> 2 -> 4 -> 5 -> 6
        ^         |
        |         |
        - - - - - -
        Example Output
        Output 1:
        1 -> 2 -> NULL
        Output 2:
        3 -> 2 -> 4 -> 5 -> 6 -> NULL

        Example Explanation
        Explanation 1:
        Chain of 1->2 is broken.
        Explanation 2:
        Chain of 4->6 is broken.*/
public class RemoveLoopFromLinkedList {
    // Function that detects loop in the list
    static int detectAndRemoveLoop(LinkedList.Node node) {
        LinkedList.Node slow = node, fast = node;
        while (slow != null && fast != null
                && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet at same point then loop
            // is present
            if (slow == fast) {
                removeLoop(slow, node);
                return 1;
            }
        }
        return 0;
    }

    // Function to remove loop
    static void removeLoop(LinkedList.Node loop, LinkedList.Node head) {
        LinkedList.Node ptr1 = loop;
        LinkedList.Node ptr2 = loop;

        // Count the number of nodes in loop
        int k = 1, i;
        LinkedList.Node prevNode = ptr1;
        while (ptr1.next != ptr2) {
            // keeping track beforeing moving next
            prevNode = ptr1;
            ptr1 = ptr1.next;
            k++;
        }
        prevNode.next = null;
        printList(prevNode);
    }

    // Function to print the linked list
    static void printList(LinkedList.Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new LinkedList.Node(50);
        list.head.next = new LinkedList.Node(20);
        list.head.next.next = new LinkedList.Node(15);
        list.head.next.next.next = new LinkedList.Node(4);
        list.head.next.next.next.next = new LinkedList.Node(10);

        // Creating a loop for testing
        list.head.next.next.next.next.next = list.head.next.next;
        detectAndRemoveLoop(list.head);
        System.out.println(
                "Linked List after removing loop : ");
        printList(list.head);
    }
}
