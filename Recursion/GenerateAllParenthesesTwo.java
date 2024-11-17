package scaler.Adv.Recursion;

import java.util.ArrayList;

/*Problem Description
        Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed
        parentheses of length 2*A.

        Problem Constraints
        1 <= A <= 10

        Input Format
        First and only argument is integer A.

        Output Format
        Return a sorted list of all possible parenthesis.

        Example Input
        Input 1:        A = 3
        Input 2:        A = 1

        Example Output
        Output 1:
        [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
        Output 2:
        [ "()" ]


        Example Explanation
        Explanation 1:
        All paranthesis are given in the output list.
        Explanation 2:
        All paranthesis are given in the output list.*/
public class GenerateAllParenthesesTwo {
    static ArrayList<String> respList = new ArrayList<>();

    public static ArrayList<String> generateParenthesis(int A) {
        int open = 0, close = 0;
        generate(A, "", open, close);
        return respList;
    }

    public static void generate(int A, String s, int open, int close) {
        // happy case where s = 2* A means contains equal number of brackets
        if (s.length() == 2 * A) {
            respList.add(s);
            return;
        }

// Conditions to continue
        // open count is less than A - we can keep on adding open brackets
        if (open < A) generate(A, s + "(", open + 1, close);
        // close count is less than open  - we can keep on adding close brackets
        if (close < open) generate(A, s + ")", open, close + 1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<String> ans = generateParenthesis(3);
        for (String i : ans
        ) {
            System.out.println(i);
        }
    }
}
