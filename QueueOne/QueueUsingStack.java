package scaler.Adv.QueueOne;

import java.util.Stack;

/*Implement a first in first out (FIFO) queue using only two stacks.
The implemented queue should support all the functions of a
normal queue (push, peek, pop, and empty).

        Implement the MyQueue class:
        void push(int x) Pushes element x to the back of the queue.
        int pop() Removes the element from the front of the queue and returns it.
        int peek() Returns the element at the front of the queue.
        boolean empty() Returns true if the queue is empty, false otherwise.
        Notes:

        You must use only standard operations of a stack, which means only push to top,
        peek/pop from top, size, and is empty operations are valid.
        Depending on your language, the stack may not be supported natively.
        You may simulate a stack using a list or deque (double-ended queue)
        as long as you use only a stack's standard operations.


        Example 1:
        Input
        ["MyQueue", "push", "push", "peek", "pop", "empty"]
        [[], [1], [2], [], [], []]
        Output
        [null, null, null, 1, 1, false]
        Explanation
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false*/
public class QueueUsingStack {
    public Stack<Integer> stk1 = new Stack<>();
    public Stack<Integer> stk2 = new Stack<>();

    public QueueUsingStack() {

    }

    public void push(int x) {
        while(!stk1.isEmpty())
        {
            stk2.push(stk1.pop());
        }
        stk1.push(x);
        while(!stk2.isEmpty())
        {
            stk1.push(stk2.pop());
        }
    }

    public int pop() {
        if(!stk1.isEmpty())
        {
            return stk1.pop();
        }
        return -1;
    }

    public int peek() {
        if(!stk1.isEmpty())
        {
            return stk1.peek();
        }
        return -1;
    }

    public boolean empty() {
        return stk1.isEmpty();
    }


    // Driver code
    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.push(1);
        q.push(2);
        q.peek();
        q.pop();
        q.empty();
    }
}
