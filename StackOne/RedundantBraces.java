package scaler.Adv.StackOne;

import java.util.Stack;

/*Problem Description
        Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
        Check whether A has redundant braces or not.
        NOTE: A will be always a valid expression and will not contain any white spaces.


        Problem Constraints
        1 <= |A| <= 105

        Input Format
        The only argument given is string A.

        Output Format
        Return 1 if A has redundant braces else, return 0.

        Example Input
        Input 1:
        A = "((a+b))"
        Input 2:
        A = "(a+(a+b))"

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        ((a+b)) has redundant braces so answer will be 1.
        Explanation 2:
        (a+(a+b)) doesn't have have any redundant braces so answer will be 0.*/
public class RedundantBraces {
    public static int braces(String A) {
        char ch[] = A.toCharArray();
        Stack<Character> st = new Stack<>();//stack need character so converting the String into character array

        //example-.(a+(a+(b))) ->redundant (so not using characters(A-Z) in stack )
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '*' || ch[i] == '+' || ch[i] == '-' || ch[i] == '/') {
                st.push(ch[i]);     //push all the symbols

            } else if (ch[i] == ')') {
                if (st.peek() == '(') {
                    return 1;   //if we found ')' immediately after '(' then return 1
                }
                while (!(st.peek().equals('(')) && !(st.isEmpty())) {
                    st.pop();   //pop till we get '('
                }
                st.pop();       //popping the '(' for next comparison of ()
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(braces("(a+(a+b))"));
    }
}
