package scaler.Adv.DPFiveString;

import java.util.Arrays;

/*Problem Description
        Given A, B, C find whether C is formed by the interleaving of A and B.

        Problem Constraints
        1 <= length(A), length(B) <= 100
        1 <= length(C) <= 200

        Input Format
        The first argument of input contains a string, A.
        The second argument of input contains a string, B.
        The third argument of input contains a string, C.

        Output Format
        Return 1 if string C is formed by interleaving of A and B else 0.

        Example Input
        Input 1:
        A = "aabcc"
        B = "dbbca"
        C = "aadbbcbcac"
        Input 2:
        A = "aabcc"
        B = "dbbca"
        C = "aadbbbaccc"

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
        Explanation 2:
        It is not possible to get C by interleaving A and B.*/
public class InterleavingStrings {
    static int[][] dpArr;

    public static int isInterleave(String A, String B, String C) {
        if (A.length() + B.length() != C.length()) {
            return 0;
        }

        dpArr = new int[A.length() + 1][B.length() + 1];
        for (int[] x : dpArr) {
            Arrays.fill(x, -1);
        }
        return recursion(A, B, C, 0, 0, 0);
    }

    static int recursion(String A, String B, String C, int i, int j, int k) {
        if (k == C.length()) {
            return 1;
        }

        if (i == A.length()) {
            if (B.substring(j).equals(C.substring(k))) {
                return 1;
            } else {
                return 0;
            }
        }

        if (j == B.length()) {
            if (A.substring(i).equals(C.substring(k))) {
                return 1;
            } else {
                return 0;
            }
        }

        char aTemp = A.charAt(i);
        char bTemp = B.charAt(j);
        char cTemp = C.charAt(k);

        if (dpArr[i][j] != -1) {
            return dpArr[i][j];
        }

        if (aTemp == cTemp && bTemp == cTemp) {
            dpArr[i][j] = recursion(A, B, C, i + 1, j, k + 1) | recursion(A, B, C, i, j + 1, k + 1);
        } else if (aTemp == cTemp) {
            dpArr[i][j] = recursion(A, B, C, i + 1, j, k + 1);
        } else if (bTemp == cTemp) {
            dpArr[i][j] = recursion(A, B, C, i, j + 1, k + 1);
        } else {
            dpArr[i][j] = 0;
        }

        return dpArr[i][j];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
