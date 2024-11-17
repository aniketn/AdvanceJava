package scaler.Adv.BackTrackingOne;

import java.util.ArrayList;
import java.util.HashMap;

/*Problem Description
        Given a digit string A, return all possible letter combinations that the number could represent.
        A mapping of digit to letters (just like on the telephone buttons) is given below.

        The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
        NOTE: Make sure the returned strings are lexicographically sorted.

        Problem Constraints
        1 <= |A| <= 10

        Input Format
        The only argument is a digit string A.

        Output Format
        Return a string array denoting the possible letter combinations.

        Example Input
        Input 1:
        A = "23"
        Input 2:
        A = "012"

        Example Output
        Output 1:
        ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
        Output 2:
        ["01a", "01b", "01c"]

        Example Explanation
        Explanation 1:
        There are 9 possible letter combinations.
        Explanation 2:
        Only 3 possible letter combinations.*/
public class LetterPhone {
    public static ArrayList<String> letterCombinations(String A) {
        HashMap<Character, String> hmp = new HashMap<Character, String>();
        ArrayList<String> ans = new ArrayList<String>();
        hmp.put('0', "0");
        hmp.put('1', "1");
        hmp.put('2', "abc");
        hmp.put('3', "def");
        hmp.put('4', "ghi");
        hmp.put('5', "jkl");
        hmp.put('6', "mno");
        hmp.put('7', "pqrs");
        hmp.put('8', "tuv");
        hmp.put('9', "wxyz");
        StringBuilder str = new StringBuilder();

        helper(A, 0, ans, hmp, str);
        return ans;
    }

    static void helper(String input_str, int index, ArrayList<String> ans, HashMap<Character, String> hmp, StringBuilder str) {
        if (index == input_str.length()) {
            ans.add(str.toString());
            return;
        }

        String S = hmp.get(input_str.charAt(index));
        for (int i = 0; i < S.length(); i++) {
            str.append(S.charAt(i));
            helper(input_str, index + 1, ans, hmp, str);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> ans = letterCombinations("234");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
