package scaler.Adv.LinkedListThree;
/*Design and implement a data structure for Least Recently Used (LRU) cache.
It should support the following operations: get and set.

        get(key) - Get the value (will always be positive)
        of the key if the key exists in the cache, otherwise return -1.
        set(key, value) - Set or insert the value if the key
        is not already present. When the cache reaches its capacity,
        it should invalidate the least recently used item before inserting the new item.
        The LRUCache will be initialized with an integer corresponding
        to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

        Definition of "least recently used" : An access to an item is defined as a
        get or a set operation of the item. "Least recently used" item is the one with the oldest access time.

        NOTE: If you are using any global variables, make sure to clear them in the constructor.
        Example :
        Input :
        capacity = 2
        set(1, 10)
        set(5, 12)
        get(5)        returns 12
        get(1)        returns 10
        get(10)       returns -1
        set(6, 14)    this pushes out key = 5 as LRU is full.
        get(5)        returns -1*/

import java.util.HashMap;

public class LRUCache {
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);


    private int capacity;
    private int currentCapacity = 0;

    private HashMap<Integer, ListNode> nodeRefernce = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //If Key is not present return -1
        if (!nodeRefernce.containsKey(key)) {
            return -1;
        }

        /*   Key is present, so there will be 2 Steps
         *   1. Get the Node reference for the current Key. To return the corresponding Value.
         *   2. Detele the Current Node and Add new Node with same Key and Value as this Key is the latest one which is used.
         */
        ListNode node = nodeRefernce.get(key);
        int value = node.val;
        //Delete the node
        deleteNode(node);
        //Insert the with same Key and Value
        set(key, value);
        //Return the Value for the Key
        return value;
    }

    public void set(int key, int value) {
        ListNode node = new ListNode(key, value);

        /*   If Key is present, so there will be 2 Steps
         *   1. Get the Node reference for the current Key. To return the corresponding Value.
         *   2. Detele the Current Node and Add new Node with same Key and New Value as this Key is the latest one which is used.
         */
        if (nodeRefernce.containsKey(key)) {
            //Delete the node
            deleteNode(nodeRefernce.get(key));
            //Insert the with same Key and New Value
            insertNode(node);
        }
        /*  If capacity is not full add it else delete the Least recently Used and Add new one.
         */
        else {
            if (currentCapacity < capacity) {
                insertNode(node);
            } else {
                deleteNode(head.next);
                insertNode(node);
            }
        }
    }

    /*   1. Takeout the Last Node [tail.prev]
     *   2. Point Current Node’s next to tail
     *   3. Previous of Tail to Current Node
     *   4. Last Node’s next to Current Node & Current Node’s Previous to Last Node
     *   5. Add the current Node reference in the Map`
     */
    private void insertNode(ListNode node) {
        ListNode lastNode = tail.prev;
        node.next = tail;
        tail.prev = node;
        node.prev = lastNode;
        lastNode.next = node;
        nodeRefernce.put(node.key, node);
        currentCapacity++;
    }

    private void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        nodeRefernce.remove(node.key);
        //System.out.println("Removing Key: “+node.val+” removed: "+nodeRefernce.containsKey(node.key));
        currentCapacity--;
    }

    class ListNode {
        public int key;
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int key, int val) {
            this.val = val;
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

   /* public void main(String[] args) {
        // TODO Auto-generated method stub
        LRUCache.ListNode A = new LRUCache.ListNode(1,1);
        LRUCache.ListNode B = new LRUCache.ListNode(1,1);
        LRUCache.ListNode C = new LRUCache.ListNode(1,1);
        A.next = B;
        B.next = C;
        C.next = D;
        System.out.println(solve(A));
    }*/
}
