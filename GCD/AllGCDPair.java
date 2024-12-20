package scaler.Adv.GCD;

/*Problem Description
        Given an array of integers A of size N containing GCD of every possible pair of elements of another array.
        Find and return the original numbers used to calculate the GCD array in any order. For example,
        if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.

        Problem Constraints
        1 <= N <= 10000
        1 <= A[i] <= 109

        Input Format
        The first and only argument given is the integer array A.

        Output Format
        Find and return the original numbers which are used to calculate the GCD array in any order.

        Example Input
        Input 1:
        A = [2, 2, 2, 2, 8, 2, 2, 2, 10]
        Input 2:
        A = [5, 5, 5, 15]

        Example Output
        Output 1:
        [2, 8, 10]
        Output 2:
        [5, 15]

        Example Explanation
        Explanation 1:
        Initially, array A = [2, 2, 2, 2, 8, 2, 2, 2, 10].
        2 is the gcd between 2 and 8, 2 and 10.
        8 and 10 are the gcds pair with itself.
        Therefore, [2, 8, 10] is the original array.
        Explanation 2:
        Initially, array A = [5, 5, 5, 15].
        5 is the gcd between 5 and 15.
        15 is the gcds pair with itself.
        Therefore, [5, 15] is the original array.*/
public class AllGCDPair {
    public static int[] solve(int[] A) {
        int orignalN = (int) Math.sqrt(A.length);//size of original array
        int[] ans = new int[orignalN]; // original array to return
        int max = 0;
        int j = 0;
        for (int i = 0; i < orignalN; i++) {
            for (; j < (i + 1) * orignalN; j++) {
                max = Math.max(max, A[j]);
            }
            ans[i] = max;
            max = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{2, 2, 2, 2, 8, 2, 2, 2, 10};
        int[] ans = solve(A);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(" " + ans[i]);
        }
    }

}
