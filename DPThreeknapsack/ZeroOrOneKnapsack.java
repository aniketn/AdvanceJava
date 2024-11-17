package scaler.Adv.DPThreeknapsack;

import java.util.ArrayList;
import java.util.Arrays;

/*Problem Description
        Given two integer arrays A and B of size N each which represent
        values and weights associated with N items respectively.

        Also given an integer C which represents knapsack capacity.
        Find out the maximum value subset of A such that sum of the weights
        of this subset is smaller than or equal to C.

        NOTE:
        You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

        Problem Constraints
        1 <= N <= 103
        1 <= C <= 103
        1 <= A[i], B[i] <= 103

        Input Format
        First argument is an integer array A of size N denoting the values on N items.
        Second argument is an integer array B of size N denoting the weights on N items.
        Third argument is an integer C denoting the knapsack capacity.

        Output Format
        Return a single integer denoting the maximum value subset of A such
        that sum of the weights of this subset is smaller than or equal to C.

        Example Input
        Input 1:
        A = [60, 100, 120]
        B = [10, 20, 30]
        C = 50
        Input 2:
        A = [10, 20, 30, 40]
        B = [12, 13, 15, 19]
        C = 10

        Example Output
        Output 1:
        220
        Output 2:
        0

        Example Explanation
        Explanation 1:
        Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
        Explanation 2:
        Knapsack capacity is 10 but each item has weight greater than 10 so
        no items can be considered in the knapsack therefore answer is 0.*/
public class ZeroOrOneKnapsack {
    public static int solve(int[] wt, int[] val, int knapsack) {
        int n = wt.length;
        int w = knapsack;

        //Populate base case
        int[][] mat = new int[n + 1][w + 1];
        for (int r = 0; r < w + 1; r++) {
            mat[0][r] = 0;
        }
        for (int c = 0; c < n + 1; c++) {
            mat[c][0] = 0;
        }

        //Main Logic
        for (int item = 1; item <= n; item++) {
            for (int capacity = 1; capacity <= w; capacity++) {
                int maxValWithoutCurrent = mat[item - 1][capacity]; //This is guranteed that it exists
                int maxValWithCurrent = 0; //We initialise this value 0 with Current

                int wtOfCurrent = wt[item - 1]; // We use item -1 to account for the extra row at the top
                if (capacity >= wtOfCurrent) {
                    maxValWithCurrent = val[item - 1];// If so, maxValWithCurr is at least the value of the current item
                    int remainingCapacity = capacity - wtOfCurrent;// remainingCapacity must be at least 0
                    maxValWithCurrent += mat[item - 1][remainingCapacity];// Add the maximum value obtainable with the remaining capacity
                }
                mat[item][capacity] = Math.max(maxValWithoutCurrent, maxValWithCurrent);// Pick the larger of the two
            }
        }
        System.out.println(Arrays.deepToString(mat));
        return mat[n][w];

    }


    public static void main(String[] args) {
        int[] weights = new int[]{3, 4, 5, 6};
        int[] values = new int[]{50, 40, 10, 30};
        int knapsack = 10;
        System.out.println(solve(weights, values, knapsack));
    }
}
