package scaler.Adv.StackOne;

import java.util.HashMap;
import java.util.Stack;

/*Problem Description
        Given string A denoting an infix expression.Convert the infix expression into a postfix expression.
        String A consists of^,/,*,+,-,(,)and lowercase English alphabets where
        lowercase English alphabets are operands and^,/,*,+,-are operators.

        Find and return the postfix expression of A.

        NOTE:
        ^has the highest precedence.
        /and*have equal precedence but greater than+and-.
        +and-have equal precedence and lowest precedence among given operators.

        Problem Constraints
        1<=length of the string<=500000

        Input Format
        The only argument given is string A.

        Output Format
        Return a string denoting the postfix conversion of A.

        Example Input
        Input 1:
        A="x^y/(a*z)+b"
        Input 2:

        A="a+b*(c^d-e)^(f+g*h)-i"


        Example Output
        Output 1:

        "xy^az*'/b+"
        Output 2:

        "abcd^e-fgh*+^*+i-"


        Example Explanation
        Explanation 1:

        Ouput dentotes the postfix expression of the given input.*/
public class InfixToPostfix {
    public static String solve(String A) {
        HashMap<Character, Integer> prec = new HashMap<>();
        prec.put('(', -1);
        prec.put('+', 1);
        prec.put('-', 1);
        prec.put('*', 2);
        prec.put('/', 2);
        prec.put('^', 3);

        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char inp = A.charAt(i);
            if (Character.isAlphabetic(inp)) {
                output.append(inp);
            } else if (inp == '(') {
                stack.push(inp);
            } else if (inp == ')') {
                while (stack.peek() != '(') {
                    output.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            } else {
                if (stack.size() == 0) {
                    stack.push(inp);
                } else {
                    int peekPrec = prec.get(stack.peek());
                    int curPrec = prec.get(inp);
                    while (peekPrec >= curPrec) {
                        output.append(stack.peek());
                        stack.pop();

                        if (stack.size() == 0) {
                            peekPrec = -1;
                        } else {
                            peekPrec = prec.get(stack.peek());
                        }
                    }
                    stack.push(inp);
                }
            }
        }
        while (stack.size() != 0) {
            output.append(stack.peek());
            stack.pop();
        }
        return output.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve("x^y/(a*z)+b"));
    }
}
