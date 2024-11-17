package scaler.Adv.DPFourAppOfKnapsack;

import java.util.ArrayList;
import java.util.Arrays;

/*Problem Description
        Given two integer arrays A and B of size N each which represent values and
        weights associated with N items respectively.

        Also given an integer C which represents knapsack capacity.
        Find out the maximum value subset of A such that sum of the weights
        of this subset is smaller than or equal to C.

        NOTE: You cannot break an item, either pick the complete item,
        or don’t pick it (0-1 property).

        Problem Constraints
        1 <= N <= 500
        1 <= C, B[i] <= 106
        1 <= A[i] <= 50

        Input Format
        First argument is an integer array A of size N denoting the values on N items.
        Second argument is an integer array B of size N denoting the weights on N items.
        Third argument is an integer C denoting the knapsack capacity.

        Output Format
        Return a single integer denoting the maximum value subset of A such
        that sum of the weights of this subset is smaller than or equal to C.

        Example Input
        Input 1:
        A = [6, 10, 12]
        B = [10, 20, 30]
        C = 50
        Input 2:
        A = [1, 3, 2, 4]
        B = [12, 13, 15, 19]
        C = 10

        Example Output
        Output 1:
        22
        Output 2:
        0

        Example Explanation
        Explanation 1:
        Taking items with weight 20 and 30 will give us the maximum value i.e 10 + 12 = 22
        Explanation 2:
        Knapsack capacity is 10 but each item has weight greater than 10 so no
        items can be considered in the knapsack therefore answer is 0.*/
public class ZeroToOneKnapsackTwo {
    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int n = A.size(), ans = 0;
        int totalWeight = 0, totalValue = 0;

        for (int i = 0; i < n; i++) {
            totalWeight += B.get(i);
            totalValue += A.get(i);
        }
        if (C >= totalWeight) {
            return totalValue;
        }

        int dp[] = new int[totalValue + 1];
        Arrays.fill(dp, -1);
        dp[0] = C;

        for (int i = 0; i < n; i++) {
            int temp[] = Arrays.copyOf(dp, totalValue + 1); //temp array to store previous dp array
            for (int v = A.get(i); v <= totalValue; v++) { //A[i] is the min value for the item under consideration
                int w = temp[v - A.get(i)] - B.get(i);
                dp[v] = Math.max(w, temp[v]);

                if (dp[v] > -1) ans = Math.max(ans, v);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(12);
        B.add(13);
        B.add(15);
        B.add(19);
        System.out.println(solve(A, B, 10));
    }
}
