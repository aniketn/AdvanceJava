package scaler.Adv.StackOne;

import java.util.Arrays;
import java.util.Stack;

/*Problem Description
        Given two strings A and B. Each string represents an expression consisting of
        lowercase English alphabets, '+', '-', '(' and ')'.

        The task is to compare them and check if they are similar. If they are identical,
        return 1 else, return 0.

        NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and
        every operand appears only once.

        Problem Constraints
        1 <= length of the each String <= 100

        Input Format
        The given arguments are string A and string B.

        Output Format
        Return 1 if they represent the same expression else return 0.

        Example Input
        Input 1:
        A = "-(a+b+c)"
        B = "-a-b-c"
        Input 2:
        A = "a-b-(c-d)"
        B = "a-b-c-d"

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B.
        Explanation 2:
        Both the expression are different.*/


/*The sign before every number is considered as localOperator the sign outside the brackets
        is considered as globalOperator.
Store the signs of each character array of size 26.
For each string, traverse over each character, and determine its sign by first looking at
        localOperator and then change it based on globalOperator. if (-, -)
            then change it to +, if (-, +) or (+ -) then change it to - and + by default.
Finally compare both the arrays, there should be same sign at their respctive places.*/
public class CheckTwoBracketExpressions {
    public static int solve(String A, String B) {
        char[] strA = calculateSigns(A);
        char[] strB = calculateSigns(B);

        for (int i = 0; i < strA.length; i++) {
            if (strA[i] != strB[i]) {
                return 0;
            }
        }
        return 1;
    }

    public static char[] calculateSigns(String str) {
        Stack<Character> globalOperators = new Stack<Character>();
        char[] outArr = new char[26];
        Arrays.fill(outArr, '+');
        int n = str.length();
        char localOperator = '+';      //This is to keep track of the sign comes immediately before the number
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if (ch == '-' || ch == '+') {
                if (globalOperators.isEmpty()) {
                    localOperator = ch;
                } else {
                    localOperator = giveProperSign(globalOperators.peek(), ch);
                }
                continue;
            }

            if (ch == '(') {
                globalOperators.push(localOperator);
                continue;
            }

            if (ch == ')') {
                globalOperators.pop();
                continue;
            }

            outArr[ch - 'a'] = localOperator;
        }

        return outArr;
    }

    public static char giveProperSign(char operator1, char operator2) {
        if ((operator1 == '-' && operator2 == '+') || (operator1 == '+' && operator2 == '-')) {
            return '-';
        }
        return '+';
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve("-(a+b+c)", "-a-b-c"));
    }
}
