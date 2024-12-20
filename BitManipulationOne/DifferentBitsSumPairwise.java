package scaler.Adv.BitManipulationOne;

/*Problem Description
        We define f(X, Y) as the number of different corresponding bits in the binary representation of X and Y.
        For example, f(2, 7) = 2, since the binary representation of 2 and 7 are 010 and 111, respectively.
        The first and the third bit differ, so f(2, 7) = 2.

        You are given an array of N positive integers, A1, A2,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j)
         such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

        Problem Constraints
        1 <= N <= 105
        1 <= A[i] <= 231 - 1

        Input Format
        The first and only argument of input contains a single integer array A.

        Output Format
        Return a single integer denoting the sum.

        Example Input
        Input 1:        A = [1, 3, 5]
        Input 2:        A = [2, 3]

        Example Output
        Ouptut 1:        8
        Output 2:        2

        Example Explanation
        Explanation 1:
        f(1, 1) + f(1, 3) + f(1, 5) + f(3, 1) + f(3, 3) + f(3, 5) + f(5, 1) + f(5, 3) + f(5, 5)
        = 0 + 1 + 1 + 1 + 0 + 2 + 1 + 2 + 0 = 8
        Explanation 2:
        f(2, 2) + f(2, 3) + f(3, 2) + f(3, 3) = 0 + 1 + 1 + 0 = 2*/
public class DifferentBitsSumPairwise {
    public static int cntBits(int[] A) {
        int mod = 1000000007;
        long res = 0;
        for (int i = 0; i < 32; i++) {
            int counton = 0;

            for (int val : A) {
                if ((val & (1 << i)) != 0) {
                    counton++;
                }
            }
            long countoff = A.length - counton;
            long diff = (counton % mod * countoff % mod * 2) % mod;
            res = (res % mod + diff % mod) % mod;
        }
        return (int) res % mod;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{1, 3, 5};
        System.out.println(cntBits(A));
    }
}
