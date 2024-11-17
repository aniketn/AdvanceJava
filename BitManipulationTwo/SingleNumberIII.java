package scaler.Adv.BitManipulationTwo;

/*Problem Description
        Given an array of positive integers A, two integers appear only once, and all the other integers
        appear twice.
        Find the two integers that appear only once.

        Note: Return the two numbers in ascending order.

        Problem Constraints
        2 <= |A| <= 100000
        1 <= A[i] <= 109

        Input Format
        The first argument is an array of integers of size N.

        Output Format
        Return an array of two integers that appear only once.

        Example Input
        Input 1:        A = [1, 2, 3, 1, 2, 4]
        Input 2:        A = [1, 2]

        Example Output
        Output 1:       [3, 4]
        Output 2:       [1, 2]


        Example Explanation
        Explanation 1:       3 and 4 appear only once.
        Explanation 2:       1 and 2 appear only once.*/
public class SingleNumberIII {
    public static int[] solve(int[] A) {
        int sum = 0, sum1 = 0, sum2 = 0;
        int[] result = new int[2];
        for (int i = 0; i < A.length; i++) {
            sum = A[i] ^ sum;
        }
        sum = (sum & -sum);
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & sum) > 0)
                sum1 = sum1 ^ A[i];
            else
                sum2 = sum2 ^ A[i];
        }
        result[0] = Math.min(sum1, sum2);
        result[1] = Math.max(sum1, sum2);
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{1, 2, 3, 1, 2, 4};
        int[] ans = solve(A);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("" + ans[i]);
        }
    }
}
