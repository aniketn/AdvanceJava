package scaler.Adv.DPSevenFamousProbTwo;

/*Problem Description
        Say you have an array, A, for which the ith element is the
        price of a given stock on day i.

        Design an algorithm to find the maximum profit.

        You may complete as many transactions as you like (i.e.,
        buy one and sell one share of the stock multiple times).

        However, you may not engage in multiple transactions at the
        same time (ie, you must sell the stock before you buy again).

        Problem Constraints
        0 <= len(A) <= 1e5
        1 <= A[i] <= 1e7

        Input Format
        The first and the only argument is an array of integer, A.

        Output Format
        Return an integer, representing the maximum possible profit.

        Example Input
        Input 1:
        A = [1, 2, 3]
        Input 2:
        A = [5, 2, 10]

        Example Output
        Output 1:
        2
        Output 2:
        8

        Example Explanation
        Explanation 1:
        => Buy a stock on day 0.
        => Sell the stock on day 1. (Profit +1)
        => Buy a stock on day 1.
        => Sell the stock on day 2. (Profit +1)

        Overall profit = 2
        Explanation 2:
        => Buy a stock on day 1.
        => Sell the stock on on day 2. (Profit +8)
        Overall profit = 8*/
public class BestTimeToBuyAndSellStocksII {
   /* public static int maxProfit(final int[] A) {
        int n = A.length;
        int dp[][] = new int[n+1][2];

//Base Case: after n u can't do anything right
        dp[n][0] = dp[n][1] = 0;

        for(int idx = n-1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                if(buy == 0){
                    dp[idx][buy] = Math.max(dp[idx+1][0], A[idx]+dp[idx+1][1]);
                }
                else{
                    dp[idx][buy] = Math.max(dp[idx+1][0] - A[idx], dp[idx+1][1]);
                }
            }
        }

        return dp[0][1];

    }*/

    public static int maxProfit(final int[] A) {
        int sellIndex = 0;
        int buyIndex = 0;
        int profit = 0;
        if (A.length == 0)
            return 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] >= A[i - 1]) {
                sellIndex++;
            } else {
                profit += A[sellIndex] - A[buyIndex];
                sellIndex = buyIndex = i;
            }
        }
        profit += A[sellIndex] - A[buyIndex];
        return profit;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        System.out.println(maxProfit(A));
    }
}
