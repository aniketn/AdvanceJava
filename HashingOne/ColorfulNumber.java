package scaler.Adv.HashingOne;

import java.util.HashSet;

/*Problem Description
        Given a number A, find if it is COLORFUL number or not.
        If number A is a COLORFUL number return 1 else, return 0.
        What is a COLORFUL Number:
        A number can be broken into different consecutive sequence of digits.
        The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324 and 245.
        This number is a COLORFUL number, since the product of every consecutive sequence of digits is different

        Problem Constraints
        1 <= A <= 2 * 109
        Input Format
        The first and only argument is an integer A.

        Output Format
        Return 1 if integer A is COLORFUL else return 0.

        Example Input
        Input 1:
        A = 23
        Input 2:
        A = 236

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        Possible Sub-sequences: [2, 3, 23] where
        2 -> 2
        3 -> 3
        23 -> 6  (product of digits)
        This number is a COLORFUL number since product of every digit of a sub-sequence are different.
        Explanation 2:
        Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
        2 -> 2
        3 -> 3
        6 -> 6
        23 -> 6  (product of digits)
        36 -> 18  (product of digits)
        236 -> 36  (product of digits)
        This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.*/
public class ColorfulNumber {
    public static int colorful(int A) {
        HashSet<Integer> hs = new HashSet<>();
        String s = String.valueOf(A);
        for (int i = 0; i < s.length(); i++) {
            int k = 1;
            for (int j = i; j < s.length(); j++) {
                k = k * (s.charAt(j) - '0');
                if (hs.contains(k)) return 0;
                else hs.add(k);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(colorful(236));
    }
}
