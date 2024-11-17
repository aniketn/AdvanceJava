package scaler.Adv.LinkListOne;

import scaler.Intermediate.LinkedListBasics.ListNode;

import java.util.HashMap;

/*Problem Description
        A linked list A is given such that each node contains an additional random pointer which could point to
        any node in the list or NULL.

        Return a deep copy of the list.

        Problem Constraints
        0 <= |A| <= 106

        Input Format
        The first argument of input contains a pointer to the head of linked list A.
        Output Format
        Return a pointer to the head of the required linked list.

        Example Input
        Given list
        1 -> 2 -> 3
        with random pointers going from
        1 -> 3
        2 -> 1
        3 -> 1

        Example Output
        1 -> 2 -> 3
        with random pointers going from
        1 -> 3
        2 -> 1
        3 -> 1

        Example Explanation
        You should return a deep copy of the list. The returned answer should not contain the same node as the
        original list, but a copy of them. The pointers in the returned list should not link to any node in the
        original input list.*/
public class CopyList {
    static class Node {
        int val;
        Node next;
        Node arbit;

        // Constructor
        Node(int x) {
            this.val = x;
            this.next = null;
            this.arbit = null;
        }
    }

    static Node cloneLinkedList(Node head) {
        // Map to store the mapping of
        // old nodes with new ones
        HashMap<Node, Node> mp = new HashMap<>();
        Node temp, nhead;

        // Duplicate of the first node
        temp = head;
        nhead = new Node(temp.val);
        mp.put(temp, nhead);

        // Loop to create duplicates of nodes
        // with only next pointer
        while (temp.next != null) {
            nhead.next = new Node(temp.next.val);
            temp = temp.next;
            nhead = nhead.next;
            mp.put(temp, nhead);
        }
        temp = head;

        // Loop to clone the arbit pointers
        while (temp != null) {
            mp.get(temp).arbit = mp.get(temp.arbit);
            temp = temp.next;
        }

        // Return the head of the clone
        return mp.get(head);
    }

    static void printList(Node head) {
        System.out.print(head.val + "(" + head.arbit.val
                + ")");
        head = head.next;
        while (head != null) {
            System.out.print(" -> " + head.val + "("
                    + head.arbit.val + ")");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a linked list with random pointer
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.arbit = head.next.next;
        head.next.arbit = head;
        head.next.next.arbit = head.next.next.next.next;
        head.next.next.next.arbit = head.next.next;
        head.next.next.next.next.arbit = head.next;

        // Print the original list
        System.out.println("The original linked list:");
        printList(head);

        // Function call
        Node sol = cloneLinkedList(head);

        System.out.println("The cloned linked list:");
        printList(sol);
    }
}
