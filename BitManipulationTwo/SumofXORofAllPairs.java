package scaler.Adv.BitManipulationTwo;

/*Problem Description
        Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.
        Since the answer can be large, return the remainder after the dividing the answer by 109+7.

        Problem Constraints
        1 <= N <= 105
        1 <= A[i] < 109

        Input Format
        Only argument A is an array of integers
        Output Format
        Return an integer denoting the sum of xor of all pairs of number in the array.

        Example Input
        Input 1:        A = [1, 2, 3]
        Input 2:        A = [3, 4, 2]

        Example Output
        Output 1:        6
        Output 2:        14

        Example Explanation
        For Input 1:
        Pair    Xor
        {1, 2}  3
        {1, 3}  2
        {2, 3}  1
        Sum of xor of all pairs = 3 + 2 + 1 = 6.
        For Input 2:
        Pair    Xor
        {3, 4}  7
        {3, 2}  1
        {4, 2}  6
        Sum of xor of all pairs = 7 + 1 + 6 = 14.*/
public class SumofXORofAllPairs {
    public static int solve(int[] A) {
        long xorSum = 0;
        int mod = 1000000007;

        for (int i = 0; i < 32; i++) {
            long cntSet = 0;
            long cntUnset = 0;
            for (int j = 0; j < A.length; j++) {
                //Find the number of set bits and the unset bits at the specific index.
                if ((A[j] & (1 << i)) != 0) {
                    cntSet++;
                } else {
                    cntUnset++;
                }
            }
            //The number of pairs of the digits which can make the final bit as 1 is the product of the
            //the number of 0s and the 1s at the specific index. Because in XOR both bits have to be different
            //for the bit to be set.
            long pairs = cntSet * cntUnset;
            xorSum += pairs * (1 << i);
            xorSum = xorSum % mod;
        }
        return (int) xorSum % mod;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{1, 2, 3};
        System.out.println(solve(A));
    }
}
