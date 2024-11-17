package scaler.Adv.ArrayThree;

/*Problem Description
        Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

        Problem Constraints
        1 <= |A| <= 100000

        Input Format
        First and only argument is the vector A

        Output Format
        Return one integer, the answer to the question
        Example Input
        Input 1:        A = [0, 1, 0, 2]
        Input 2:        A = [1, 2]

        Example Output
        Output 1:        1
        Output 2:        0

        Example Explanation
        Explanation 1:        1 unit is trapped on top of the 3rd element.
        Explanation 2:        No water is trapped.*/
public class RainWaterTrapped {
    public static int trap(final int[] A) {
        int units = 0;
        int N = A.length;
        int[] lmax = new int[N];
        lmax[0] = 0;
        int[] rmax = new int[N];
        rmax[A.length - 1] = 0;
// Finding max height of building on left side of selected building ---------------- T.C = O(N)
        for (int i = 1; i < N; i++) {
            lmax[i] = Math.max(lmax[i - 1], A[i - 1]);
        }
// Finding max height of building on right side of selected building ---------------- T.C = O(N)
        for (int i = N - 2; i >= 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], A[i + 1]);
        }
// Find the no. of units of water will be stored between buildings
        for (int i = 1; i < N; i++) {
// We will be checking the minimun height of building between left max and right max building height of current building in order to find
// the amount of water it can store then will be subtracting the current height of building as water will be store on top of the building
            int wunit = Math.min(lmax[i], rmax[i]) - A[i];
// checking for +ve units to avoid those buildings where water cannot be stored.
            if (wunit > 0) {
                units += wunit;
            }
        }
// Final T.C = O(N), S.C = O(N)
        return units;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{0, 1, 0, 2};
        System.out.println(trap(A));
    }
}
