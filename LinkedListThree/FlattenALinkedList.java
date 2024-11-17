package scaler.Adv.LinkedListThree;


import scaler.Intermediate.LinkedListBasics.ListNode;

import java.util.PriorityQueue;

/*Problem Description
        Given a linked list where every node represents a linked list and contains two pointers of its type:

        Pointer to next node in the main list (right pointer)
        Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
        You are asked to flatten the linked list into a single list.
        Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.

        Problem Constraints
        1 <= Total nodes in the list <= 100000
        1 <= Value of node <= 109

        Input Format
        The only argument given is head pointer of the doubly linked list.

        Output Format
        Return the head pointer of the Flattened list.

        Example Input
        Input 1:
        3 -> 4 -> 20 -> 20 ->30
        |    |    |     |    |
        7    11   22    20   31
        |               |    |
        7               28   39
        |               |
        8               39
        Input 2:
        2 -> 4
        |    |
        7    11
        |
        7

        Example Output
        Output 1:
        3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39
        Output 2:
        2 -> 4 -> 7 -> 7 -> 11

        Example Explanation
        Explanation 1:
        The return linked list is the flatten sorted list.*/
public class FlattenALinkedList {
    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int data) {
            this.data = data;
            next = null;
            bottom = null;
        }
    }

    static class NodeComparator implements java.util.Comparator<Node> {
        @Override
        public int compare(Node a, Node b) {
            return a.data - b.data;
        }
    }

    public static void flatten(Node root) {
        // Priority queue to store nodes
        PriorityQueue<Node> pq
                = new PriorityQueue<Node>(new NodeComparator());

        // Adding main linked list nodes into priority queue
        while (root != null) {
            pq.add(root);
            root = root.next;
        }

        // Extracting the minimum node
        // while priority queue is not empty
        while (!pq.isEmpty()) {
            // Extracting the minimum node
            Node k = pq.poll();

            // Printing the node data
            System.out.print(k.data + " ");
            if (k.bottom != null) {
                pq.add(k.bottom);
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        Node temp = head;
        Node bt = head;

        bt.bottom = new Node(7);
        bt.bottom.bottom = new Node(8);
        bt.bottom.bottom.bottom = new Node(30);

        temp.next = new Node(10);
        temp = temp.next;

        bt = temp;
        bt.bottom = new Node(20);

        temp.next = new Node(19);
        temp = temp.next;

        bt = temp;
        bt.bottom = new Node(22);
        bt.bottom.bottom = new Node(50);

        temp.next = new Node(28);
        temp = temp.next;

        bt = temp;
        bt.bottom = new Node(35);
        bt.bottom.bottom = new Node(40);
        bt.bottom.bottom.bottom = new Node(45);

        // Calling function to flatten the linked list
        flatten(head);
    }
}
