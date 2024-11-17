package scaler.Adv.LinkedListThree;

import scaler.Intermediate.LinkedListBasics.ListNode;

import java.util.*;

/*Problem Description
        Implement a stack which will support following types of operations:

        Type 1: "1 x" : Push x into the stack.
        Type 2: "2 0" : Pop the top element from the stack and return it.
        Type 3: "3 0" : Return the middle element of the stack.
        Type 4: "4 0" : Delete the middle element from the stack.
        You have to perform Q operations given in a form of 2-D array A
        of size Q x 2 where A[i][0] and A[i][1] denotes the operation parameters as explained above.
        NOTE:
        You have to output only for operations of type-2 and type-3.
        If the stack is empty return -1 for operations of type-2 and type-3.
        If the stack size is even then the second middle element will be considered as middle
        element for the operations to perform.
        Try to implement each operation in O(1) time complexity.

        Problem Constraints
        1 <= Q <= 105
        1 <= x <= 103

        Input Format
        First and only argument A is and 2-D array of size Q x 2 denoting the operations.

        Output Format
        Return a 1-D array consisting the output of operations of type-2 and type-3.
        The order must be same as in input.

        Example Input
        Input 1:
        A = [
        [1, 3]
        [3, 0]
        [4, 0]
        [2 ,0]
        [1, 5]
        [1, 9]
        [3, 0]
        ]
        Input 2:
        A = [
        [1, 1]
        [1, 2]
        [1, 3]
        [3, 0]
        [4, 0]
        [3, 0]
        [4, 0]
        ]

        Example Output
        Output 1:

        [3, -1, 9]
        Output 2:
        [2, 3]
        Example Explanation
        Explanation 1:
        Initial stack S = [ ]
        Operation 1: "1 3" : Push 3 into stack so stack becomes S = [3]
        Operation 2: "3 0" : Middle element of stack is 3 so adding 3 to output array.
        Operation 3: "4 0" : Deleting the middle element i.e 3 so stack becomes S = [ ]
        Operation 4: "2 0" : Popping element from the stack but the stack is empty so adding -1 to the output array.
        Operation 5: "1 5" : Push 5 into stack so stack becomes S = [5]
        Operation 6: "1 9" : Push 9 into stack so stack becomes S = [5, 9] where 9 is the top element of the stack.
        Operation 7: "3 0" : As stack size is even so 9 will be consider as middle element and we will add 9 to output array. Stack S remains same.
        Explanation 2:
        Initial stack S = [ ]
        Operation 1: "1 1" : Push 1 into stack so stack becomes S = [1]
        Operation 2: "1 2" : Push 2 into stack so stack becomes S = [1, 2]
        Operation 3: "1 3" : Push 3 into stack so stack becomes S = [1, 2, 3]
        Operation 4: "3 0" : Middle element of stack is 2 so adding 2 to output array. Stack S remains same [1, 2, 3].
        Operation 5: "4 0" : Deleting the middle element i.e 2 so stack becomes S = [1, 3]
        Operation 6: "3 0" : Middle element of stack is 3 so adding 3 to output array. Stack S remains same [1, 3].
        Operation 6: "4 0" : Deleting the middle element i.e 3 so stack becomes S = [1]*/
public class MiddleElementFromStack {
    Stack<Integer> s;
    Deque<Integer> dq;

    MiddleElementFromStack() {
        s = new Stack<Integer>();
        dq = new ArrayDeque<Integer>();
    }

    void add(int data) {
        dq.addLast(data);
        if (dq.size() > s.size() + 1) {
            int temp = dq.pollFirst();
            s.push(temp);
        }
    }

    void pop() {
        int data = dq.pollLast();
        if (s.size() > dq.size()) {
            int temp = s.pop();
            dq.offerFirst(temp);
        }
    }

    int getMiddleElement() {
        return dq.getFirst();
    }

    void deleteMiddleElement() {
        dq.pollFirst();
        if (s.size() > dq.size()) {
            int temp = s.pop();
            dq.offerFirst(temp);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MiddleElementFromStack s = new MiddleElementFromStack();
        s.add(2);
        s.add(5);

        System.out.println("Middle element:"
                + s.getMiddleElement());
        s.add(3);
        s.add(7);
        s.add(4);
        System.out.println("Middle element:"
                + s.getMiddleElement());
        s.deleteMiddleElement();
        System.out.println("Middle element:"
                + s.getMiddleElement());
        s.deleteMiddleElement();
        System.out.println("Middle element:"
                + s.getMiddleElement());
        s.pop();
        s.pop();
        s.deleteMiddleElement();
    }
}

//Implement a stack that supports findMiddle() and deleteMiddle in O(1) time


