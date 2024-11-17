package scaler.Adv.DPFiveString;

/*Problem Description
        Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

        ' . ' : Matches any single character.
        ' * ' : Matches zero or more of the preceding element.
        The matching should cover the entire input string (not partial).

        Problem Constraints
        1 <= length(A), length(B) <= 104

        Input Format
        The first argument of input contains a string A.
        The second argument of input contains a string B denoting the pattern.

        Output Format
        Return 1 if the patterns match else return 0.

        Example Input
        Input 1:
        A = "aab"
        B = "c*a*b"
        Input 2:
        A = "acz"
        B = "a.a"

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        'c' can be repeated 0 times, 'a' can be repeated 1 time. Therefore, it matches "aab".
        So, return 1.
        Explanation 2:
        '.' matches any single character. First two character in string A will be match.
        But the last character i.e 'z' != 'a'. Return 0.*/
public class RegularExpressionII {
    // DO NOT MODIFY THE ARGUMENTS WITH “final” PREFIX. IT IS READ ONLY
    // DO NOT MODIFY THE LIST. IT IS READ ONLY


    public static boolean matchRegex(String text, String pattern) {
        boolean T[][] = new boolean[text.length() + 1][pattern.length() + 1];

        T[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern.charAt(i - 1) == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern.charAt(j - 1) == '.' || pattern.charAt(j - 1) == text.charAt(i - 1)) {
                    T[i][j] = T[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    T[i][j] = T[i][j - 2];
                    if (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == text.charAt(i - 1)) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length()][pattern.length()];
    }


    public static void main(String[] args) {
        System.out.println(matchRegex("acz*y", "a.a*y"));
    }
}
