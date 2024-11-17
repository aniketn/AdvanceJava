package scaler.Adv.BackTrackingOne;

import java.util.*;

/*Problem Description
        Given a string A consisting of lowercase English alphabets and parentheses '(' and ')'.
        Remove the minimum number of invalid parentheses in order to make the input string valid.

        Return all possible results.
        You can return the results in any order.

        Problem Constraints
        1 <= length of the string <= 20

        Input Format
        The only argument given is string A.

        Output Format
        Return all possible strings after removing the minimum number of invalid parentheses.

        Example Input
        Input 1:
        A = "()())()"
        Input 2:
        A = "(a)())()"

        Example Output
        Output 1:
        ["()()()", "(())()"]
        Output 2:
        ["(a)()()", "(a())()"]

        Example Explanation
        Explanation 1:
        By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 4 then string becomes : "()()()"
        2. Remove the parentheses at index 2 then string becomes : "(())()"
        Explanation 2:
        By removing 1 parentheses we can make the string valid.
        1. Remove the parentheses at index 5 then string becomes : "(a)()()"
        2. Remove the parentheses at index 2 then string becomes : "(a())()"*/
public class RemoveInvalidParentheses {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<String>();
        int minBracket = removeBracket(s);
        getAns(s, minBracket, set, ans);
        return ans;
    }

    public static void getAns(String s, int minBracket, HashSet<String> set, List<String> ans) {
        if (set.contains(s))
            return;
        set.add(s);
        if (minBracket == 0) {
            int remove = removeBracket(s);
            if (remove == 0)
                ans.add(s);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')')
                continue;
            String L = s.substring(0, i);
            String R = s.substring(i + 1);
            if (!set.contains(L + R))
                getAns(L + R, minBracket - 1, set, ans);
        }
    }

    public static int removeBracket(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == '(')
                stack.push(x);
            else if (x == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(x);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        List<String> ans = removeInvalidParentheses("()())()");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
