package scaler.Adv.LinkListOne;

public class CopyListPractice {
    static class Node {
        int val;
        Node next;
        Node random;

        // Constructor
        Node(int x) {
            this.val = x;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        //interwaving old and new nodes
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            //intersecting copied node between original nodes
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }
        temp = head;

        //connecting the random connection
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            } else {
                temp.next.random = null;
            }
            temp = temp.next.next;
        }
        temp = head;

        //unwinding the new copied nodes
        Node head2 = temp.next;
        Node n = head2;
        while (temp != null) {
            temp.next = temp.next.next;
            if (n.next != null) {
                n.next = n.next.next;
            } else {
                n.next = null;
            }
            temp = temp.next;
            n = n.next;
        }
        return head2;
    }
}
