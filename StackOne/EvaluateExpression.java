package scaler.Adv.StackOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*Problem Description
        An arithmetic expression is given by a string array A of size N.
        Evaluate the value of an arithmetic expression in Reverse Polish Notation.

        Valid operators are +, -, *, /. Each string may be an integer or an operator.

        Problem Constraints
        1 <= N <= 105

        Input Format
        The only argument given is string array A.

        Output Format
        Return the value of arithmetic expression formed using reverse Polish Notation.

        Example Input
        Input 1:
        A =   ["2", "1", "+", "3", "*"]
        Input 2:
        A = ["4", "13", "5", "/", "+"]

        Example Output
        Output 1:
        9
        Output 2:
        6

        Example Explanation
        Explaination 1:
        starting from backside:
        * : () * ()
        3 : () * (3)
        + : (() + ()) * (3)
        1 : (() + (1)) * (3)
        2 : ((2) + (1)) * (3)
        ((2) + (1)) * (3) = 9
        Explaination 2:
        + : () + ()
        / : () + (() / ())
        5 : () + (() / (5))
        13 : () + ((13) / (5))
        4 : (4) + ((13) / (5))
        (4) + ((13) / (5)) = 6*/
public class EvaluateExpression {
    public static int evalRPN(ArrayList<String> A) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            String s = A.get(i);
            if (s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")) {
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                int evl = s.equals("+") ? (op1 + op2) : s.equals("-") ? (op1 - op2) : s.equals("*") ? (op1 * op2) : (op1 / op2);
                stack.push(String.valueOf(evl));
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("2");
        arr1.add("1");
        arr1.add("+");
        arr1.add("3");
        arr1.add("*");
        System.out.println(evalRPN(arr1));
    }
}
