package scaler.Adv.DPThreeknapsack;

/*Problem Description
        Rishik likes candies a lot. So, he went to a candy-shop to buy candies.
        The shopkeeper showed him N packets each containg A[i] candies
        for cost of C[i] nibbles, each candy in that packet has a sweetness B[i].
        The shopkeeper puts the condition that Rishik can buy as many complete
         candy-packets as he wants but he can't buy a part of the packet.

        Rishik has D nibbles, can you tell him the maximum amount of sweetness
         he can get from candy-packets he will buy?

        Problem Constraints
        1 <= N <= 700
        1 <= A[i] <= 1000
        1 <= B[i] <= 1000
        1 <= C[i],D <= 1000

        Input Format
        First argument of input is an integer array A
        Second argument of input is an integer array B
        Third argument of input is an integer array C
        Fourth argument of input is an integer D

        Output Format
        Return a single integer denoting maximum sweetness of the candies that he can buy

        Example Input
        Input 1:
        A = [1, 2, 3]
        B = [2, 2, 10]
        C = [2, 3, 9]
        D = 8
        Input 2:
        A = [2]
        B = [5]
        C = [10]
        D = 99
        Example Output
        Output 1:
        10
        Output 2:
        90

        Example Explanation
        Explanation 1:
        Choose 1 Packet of kind 1 = 1 Candy of 2 Sweetness = 2 Sweetness
        Choose 2 Packet of kind 2 = 2 Candy of 2 Sweetness = 8 Sweetness
        Explanation 2:
        Buy 9 Packet of kind 1. 18 Candy each of 5 Sweetness = 90 Sweetness*/
public class BuyingCandies {
    static int[][] dp;

    public static int solve(int[] A, int[] B, int[] C, int D) {
        dp = new int[A.length][D + 1];

        getMaxSweetness(A.length - 1, D, A, C, B);
        return dp[A.length - 1][D];
    }

    //This method returns the max sweetness we can buy using given money
    private static int getMaxSweetness(int itemIndex, int remainingMoney, int A[], int[] C, int[] B) {
        //If already solved then use the value directory from dp array
        if (dp[itemIndex][remainingMoney] != 0) {
            return dp[itemIndex][remainingMoney];
        }
//If no money is left then 0 sweetness can be bought
        else if (remainingMoney == 0) {
            dp[itemIndex][remainingMoney] = 0;
        }
//In case of last item remaining check how many packets we can buy of this
        else if (itemIndex == 0) {
            // If cost of packet is less than the remaining money then as many packets as you can buy
            if (C[itemIndex] <= remainingMoney)
                dp[itemIndex][remainingMoney] = (remainingMoney / C[itemIndex]) * A[itemIndex] * B[itemIndex];
            else {
                dp[itemIndex][remainingMoney] = 0;
            }
        }
//If given packet costs more than the remaining money then we can't buy it so leave the current packet and continue
        else if (C[itemIndex] > remainingMoney)
            dp[itemIndex][remainingMoney] = getMaxSweetness(itemIndex - 1, remainingMoney, A, C, B);
        else
//If given packet costs less than the remaining money then we can buy it and continue with remaining packets
            dp[itemIndex][remainingMoney] = Math.max(getMaxSweetness(itemIndex - 1, remainingMoney, A, C, B),
                    getMaxSweetness(itemIndex, remainingMoney - C[itemIndex], A, C, B) + (A[itemIndex] * B[itemIndex]));

        return dp[itemIndex][remainingMoney];
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {2, 2, 10};
        int[] C = {2, 3, 9};
        int D = 8;
        System.out.println(solve(A, B, C, 8));
    }
}
