package scaler.Adv.StackTwo;

import java.util.ArrayList;
import java.util.Stack;

/*Problem Description
        Given a stack of integers A, sort it using another stack.
        Return the array of integers after sorting the stack using another stack.

        Problem Constraints
        1 <= |A| <= 5000
        0 <= A[i] <= 109

        Input Format
        The only argument is a stack given as an integer array A.

        Output Format
        Return the array of integers after sorting the stack using another stack.

        Example Input
        Input 1:
        A = [5, 4, 3, 2, 1]
        Input 2:
        A = [5, 17, 100, 11]

        Example Output
        Output 1:
        [1, 2, 3, 4, 5]
        Output 2:
        [5, 11, 17, 100]

        Example Explanation
        Explanation 1:
        Just sort the given numbers.
        Explanation 2:
        Just sort the given numbers.*/
public class SortStackUsingAnotherStack {
    public static int[] solve(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(A[0]);
        for (int i = 1; i < N; i++) {
            if (A[i] <= stack.peek())
                stack.push(A[i]);
            else stack = insert(stack, A[i]);
        }

        for (int i = 0; i < N; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }

    static Stack<Integer> insert(Stack<Integer> stack, int x) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        while (stack.size() >= 0) {
            if (stack.size() == 0 || stack.peek() >= x) {
                stack.push(x);
                break;
            } else
                l.add(stack.pop());
        }
        for (int i = l.size() - 1; i >= 0; i--) {
            stack.push(l.get(i));
        }
        return stack;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {5, 17, 100, 11};
        int[] ans = solve(A);
        {
            for (int i = 0; i < ans.length; i++) {
                System.out.println("" + ans[i]);
            }
        }
    }
}
