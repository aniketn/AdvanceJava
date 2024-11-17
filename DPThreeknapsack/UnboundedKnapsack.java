package scaler.Adv.DPThreeknapsack;

import java.util.ArrayList;

/*Problem Description
        Given a knapsack weight A and a set of items with certain value B[i] and weight C[i],
         we need to calculate maximum amount that could fit in this quantity.

        This is different from classical Knapsack problem, here we are allowed to
        use unlimited number of instances of an item.

        Problem Constraints
        1 <= A <= 1000
        1 <= |B| <= 1000
        1 <= B[i] <= 1000
        1 <= C[i] <= 1000

        Input Format
        First argument is the Weight of knapsack A
        Second argument is the vector of values B
        Third argument is the vector of weights C

        Output Format
        Return the maximum value that fills the knapsack completely

        Example Input
        Input 1:
        A = 10
        B = [5]
        C = [10]
        Input 2:
        A = 10
        B = [6, 7]
        C = [5, 5]

        Example Output
        Output 1:
        5
        Output 2:
        14

        Example Explanation
        Explanation 1:
        Only valid possibility is to take the given item.
        Explanation 2:
        Take the second item twice.*/
public class UnboundedKnapsack {
  /*  Time Complexity: O(W*N) where W is the total weight(capacity) and N is the total number of items.
    Auxiliary Space: O(W) where W is the total weight.*/
    private static int max(int i, int j) {
        return (i > j) ? i : j;
    }

    // Returns the maximum value with knapsack of W capacity
    private static int unboundedKnapsack(int W, int n, int[] val, int[] wt) {
        // dp[i] is going to store maximum value with knapsack capacity i.
        int dp[] = new int[W + 1];

        // Fill dp[] using above recursive formula
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i) {
                    dp[i] = max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        return dp[W];
    }

    // Driver program
    public static void main(String[] args) {
        int W = 100;
        int val[] = {10, 30, 20};
        int wt[] = {5, 10, 15};
        int n = val.length;
        System.out.println(unboundedKnapsack(W, n, val, wt));
    }

}
