package scaler.Adv.DPSixFamousProbOne;

import java.util.ArrayList;

/*Problem Description
        Given a number A, return number of ways you can draw A chords
        in a circle with 2 x A points such that no 2 chords intersect.

        Two ways are different if there exists a chord which is present
        in one way and not in other.
        Return the answer modulo 109 + 7.

        Problem Constraints
        1 <= A <= 103

        Input Format
        The first and the only argument contains the integer A.

        Output Format
        Return an integer answering the query as described in the problem statement.

        Example Input
        Input 1:
        A = 1
        Input 2:
        A = 2

        Example Output
        Output 1:
        1
        Output 2:
        2

        Example Explanation
        Explanation 1:
        If points are numbered 1 to 2 in clockwise direction,
        then different ways to draw chords are: {(1-2)} only. So, we return 1.
        Explanation 2:
        If points are numbered 1 to 4 in clockwise direction,
        then different ways to draw chords are:{(1-2), (3-4)} and {(1-4), (2-3)}.
        So, we return 2.*/
public class IntersectingChordsInACircle {
   /* Intuition - To have non intersecting chords, we must need even number
   of points present on both the sides of a chord. Eg : for n = 2, we have 4 points say
   . 1,2,3,4 . To make non-intersecting chords, we can join either 1-2, 3-4 or 1-4, 2-3.
    Note : points are numbered from 1 to 4, starting from 1,2,3,4 in the circular manner on circle.
    Here we can't have 1-3,2-4 since they are intersecting. For intersecting chords there
     will be odd number of points present on either side of chord, which we should avoid.

    So having n chords with 2 * n , we have following options for a single chord
- having 0 points on its left, 2 * (n - 1) on its right ,
            - having 2 point on left, 2 * (n - 2) on its right.
..
        - having  2 * (n - 1) points on left, 2 points on right.
            Here for 2 points represent 1 chord, then we get below recurrence relationship.
    Recurrence relation - T(n) = T(0) * T(n - 1) + T(1) * T(n - 2) ....T(n - 1) * T(0).*/

    public static int chordCnt(int A) {
        // n = no of points required
        int n = 2 * A;

        // dp array containing the sum
        int[] dpArray = new int[n + 1];
        dpArray[0] = 1;
        dpArray[2] = 1;
        for (int i = 4; i <= n; i += 2) {
            for (int j = 0; j < i - 1; j += 2)
            {
                dpArray[i] += (dpArray[j] *
                        dpArray[i - 2 - j]);
            }
        }

        // returning the required number
        return dpArray[n];
    }

    public static void main(String[] args) {
        System.out.println(chordCnt(4));
    }
}
