package scaler.Adv.HashingTwo;

import java.util.ArrayList;
import java.util.HashMap;

/*Problem Description
        Given two strings A and B, determine if they are isomorphic.

        A and B are called isomorphic strings if all occurrences of each character in A can be replaced with
        another character to get B and vice-versa.

        Problem Constraints
        1 <= |A| <= 100000
        1 <= |B| <= 100000
        A and B contain only lowercase characters.

        Input Format
        The first Argument is string A.
        The second Argument is string B.

        Output Format
        Return 1 if strings are isomorphic, 0 otherwise.

        Example Input
        Input 1:
        A = "aba"
        B = "xyx"
        Input 2:
        A = "cvv"
        B = "xyx"
        Example Output
        Output 1:
        1
        Output 2:
        0
        Example Explanation
        Explanation 1:
        Replace 'a' with 'x', 'b' with 'y'.
        Explanation 2:

        A cannot be converted to B.*/
public class IsomorphicStrings {
    public static int solve(String A, String B) {
        if (A.length() == 0 || B.length() == 0) return 1;
        if (A.length() != B.length()) return 0;
        HashMap< Character, ArrayList< Integer >> hmA = new HashMap < > ();
        HashMap < Character, ArrayList < Integer >> hmB = new HashMap < > ();
        for (int i = 0; i < A.length(); i++) {
            if (hmA.containsKey(A.charAt(i))) {
                hmA.get(A.charAt(i)).add(i);
            } else {
                hmA.put(A.charAt(i), new ArrayList < > ());
                hmA.get(A.charAt(i)).add(i);
            }
        }
        for (int i = 0; i < B.length(); i++) {
            if (hmB.containsKey(B.charAt(i))) {
                hmB.get(B.charAt(i)).add(i);
            } else {
                hmB.put(B.charAt(i), new ArrayList < > ());
                hmB.get(B.charAt(i)).add(i);
            }
        }
        for (int i = 0; i < A.length(); i++)
            if (!hmA.get(A.charAt(i)).equals(hmB.get(B.charAt(i)))) return 0;
        return 1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve("cvv","xyx"));
    }
}
