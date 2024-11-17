package scaler.Adv.LinkListOne;
/*Problem Description
        Design and implement a Linked List data structure.
        A node in a linked list should have the following attributes -
        an integer value and a pointer to the next node. It should support the following operations:

        insert_node(position, value) - To insert the input value at the given position in the linked list.
        delete_node(position) - Delete the value at the given position from the linked list.
        print_ll() - Print the entire linked list, such that each element is followed by a single space
        (no trailing spaces).
        Note:

        If an input position does not satisfy the constraint, no action is required.
        Each print query has to be executed in a new line.*/
public class LinkListPreparation {
    public static class Node{
        int val;
        Node next;
        public Node(int a){
            val = a;
            next = null;
        }
    }
    public static Node head = null;
    public static int length = 0;
    public static void insert_node(int position, int value) {
        if(position > length+1){
            return;
        }
        if(position == 1){
            Node n = new Node(value);
            n.next = head;
            head = n;
        }else{
            Node top = head;
            for(int i = 2; i <= position-1; i++){
                top = top.next;
            }
            Node n = new Node(value);
            n.next = top.next;
            top.next = n;
        }
        length++;
    }

    public static void delete_node(int position) {
        if(position > length){
            return;
        }
        if(position == 1){
            head = head.next;
        }else{
            Node top = head;
            for(int i = 2; i <= position-1; i++){
                top = top.next;
            }
            top.next = top.next.next;
        }
        length--;
    }

    public static void print_ll() {
        if(length == 0){
            return;
        }
        Node top = head;
        while(top.next != null){
            System.out.print(top.val+" ");
            top = top.next;
        }
        System.out.print(top.val);
    }
}
