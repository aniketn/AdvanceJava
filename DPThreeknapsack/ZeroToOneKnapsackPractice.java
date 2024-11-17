package scaler.Adv.DPThreeknapsack;

import java.security.DrbgParameters;

public class ZeroToOneKnapsackPractice {
    public static int solve(int[] weights, int[] values, int knapsack) {
        int n = weights.length;
        int w = knapsack;

        int mat[][] = new int[n + 1][w + 1];

        for (int r = 0; r <= n + 1; r++) {
            mat[r][0] = 0;
        }
        for (int c = 0; c <= w + 1; c++) {
            mat[0][c] = 0;
        }

        for (int item = 1; item <= n; item++) {
            for (int capacity = 1; capacity <= w; capacity++) {
                int maxValWithoutCurrent = mat[item - 1][capacity];
                int maxValWithCurrent = 0;

                int wtofCurrent = weights[item - 1];
                if (capacity >= wtofCurrent) {
                    maxValWithCurrent = values[item - 1];
                    int remainCapacity = capacity - wtofCurrent;
                    maxValWithCurrent += mat[item - 1][remainCapacity];
                }
                mat[item][capacity] = Math.max(maxValWithCurrent, maxValWithoutCurrent);
            }
        }

        return mat[n][w];

    }

    public static void main(String[] args) {
        int[] wt = new int[]{3, 4, 5, 6};
        int[] values = new int[]{50, 40, 10, 30};
        int knapsack = 10;
        System.out.println(solve(wt, values, knapsack));
    }
}
