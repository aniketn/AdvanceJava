package scaler.Adv.HashingTwo;

import java.util.HashMap;
import java.util.HashSet;

/*Problem Description
        Given a string A, find the length of the longest substring without repeating characters.
        Note: Users are expected to solve in O(N) time complexity.

        Problem Constraints
        1 <= size(A) <= 106
        String consists of lowerCase,upperCase characters and digits are also present in the string A.

        Input Format
        Single Argument representing string A.

        Output Format
        Return an integer denoting the maximum possible length of substring without repeating characters.

        Example Input
        Input 1:
        A = "abcabcbb"
        Input 2:
        A = "AaaA"

        Example Output
        Output 1:
        3
        Output 2:
        2

        Example Explanation
        Explanation 1:
        Substring "abc" is the longest substring without repeating characters in string A.
        Explanation 2:
        Substring "Aa" or "aA" is the longest substring without repeating characters in string A.*/
public class LongestSubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String A) {
        HashMap< Character, Integer > map = new HashMap < > ();
        int start = 0, end = 1, len = Integer.MIN_VALUE;
        map.put(A.charAt(0), 0);
        while (end < A.length()) {
            char ch = A.charAt(end);
            if (map.containsKey(ch) && map.get(ch) >= start) {
                len = Math.max(len, end - start);
                start = map.get(ch) + 1;
            }
            map.put(ch, end);
            end++;
        }
        len = Math.max(len, end - start);
        return len;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
