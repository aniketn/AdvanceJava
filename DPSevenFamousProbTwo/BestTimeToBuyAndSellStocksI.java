package scaler.Adv.DPSevenFamousProbTwo;

/*Problem Description
        Say you have an array, A, for which the ith element is the price of a given stock on day i.
        If you were only permitted to complete at most one transaction
        (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

        Return the maximum possible profit.

        Problem Constraints
        0 <= A.size() <= 700000
        1 <= A[i] <= 107

        Input Format
        The first and the only argument is an array of integers, A.

        Output Format
        Return an integer, representing the maximum possible profit.

        Example Input
        Input 1:
        A = [1, 2]
        Input 2:
        A = [1, 4, 5, 2, 4]

        Example Output
        Output 1:        1
        Output 2:        4

        Example Explanation
        Explanation 1:
        Buy the stock on day 0, and sell it on day 1.
        Explanation 2:
        Buy the stock on day 0, and sell it on day 2.*/
public class BestTimeToBuyAndSellStocksI {
    public static int maxProfit(final int[] A) {
        int profit = 0;

        // Corner case when size of the array is <= equal to 1, we will return 0.
        if (A.length <= 1) return 0;

        //Lets take 1st element as Minimun and Proceed
        int minCost = A[0];
        for (int i = 1; i < A.length; i++) {
            if (minCost > A[i]) minCost = A[i];
            if (profit < A[i] - minCost) {
                profit = A[i] - minCost;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 5, 2, 4};
        System.out.println(maxProfit(A));
    }
}
