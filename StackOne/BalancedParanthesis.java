package scaler.Adv.StackOne;

import java.util.Stack;

/*Problem Description
        Given an expression string A, examine whether the pairs and the orders of
        “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

        Refer to the examples for more clarity.

        Problem Constraints
        1 <= |A| <= 100

        Input Format
        The first and the only argument of input contains the string A having the parenthesis sequence.

        Output Format
        Return 0 if the parenthesis sequence is not balanced.
        Return 1 if the parenthesis sequence is balanced.

        Example Input
        Input 1:
        A = {([])}
        Input 2:
        A = (){
        Input 3:
        A = ()[]

        Example Output
        Output 1:
        1
        Output 2:
        0
        Output 3:
        1

        Example Explanation
        You can clearly see that the first and third case contain valid paranthesis.
        In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.*/
public class BalancedParanthesis {
    public static int solve(String A) {
        Stack<Character> stk = new Stack<Character>();

        int temp = 0;
        while (temp < A.length()) {
            //If its opened bracket then push it
            if (A.charAt(temp) == '(' || A.charAt(temp) == '[' || A.charAt(temp) == '{') {
                stk.push(A.charAt(temp));
            } // If closed bracket then pop top one and check the exact one and stack
            // should not be empty then pop
            else if (A.charAt(temp) == ')') {
                if (stk.empty() || stk.peek() != '(') return 0;
                stk.pop();
            } else if (A.charAt(temp) == '}') {
                if (stk.empty() || stk.peek() != '{') return 0;
                stk.pop();
            } else if (A.charAt(temp) == ']') {
                if (stk.empty() || stk.peek() != '[') return 0;
                stk.pop();
            }
            temp++;
        }

        // Stack should be empty at the end of string iteration then only it will be balanced paranthesis
        if (stk.empty()) return 1;

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solve("{([])}[]}[]"));
    }
}
