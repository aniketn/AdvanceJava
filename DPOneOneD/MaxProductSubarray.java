package scaler.Adv.DPOneOneD;

public class MaxProductSubarray {
    /*// Utility functions to get
    // minimum of two integers
    static int min(int x, int y) {
        return x < y ? x : y;
    }

    // Utility functions to get
    // maximum of two integers
    static int max(int x, int y) {
        return x > y ? x : y;
    }*/

    public static int maxProduct(final int[] A) {
        if (A.length == 1) return A[0];
        int mine = A[0], maxe = A[0], res = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < 0) {
                int t = maxe;
                maxe = mine;
                mine = t;
            }
            mine = Math.min(A[i], A[i] * mine);
            maxe = Math.max(A[i], A[i] * maxe);
            res = Math.max(res, Math.max(mine, maxe));
        }
        return res;
    }

    //TC:O(n)
    //SC:O(1)

    public static void main(String[] args) {
        int[] A = new int[]{-3, 0, -5, 0};
        System.out.println(maxProduct(A));
    }
}
