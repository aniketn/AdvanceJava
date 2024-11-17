package scaler.Adv.PrimeNumbers;

/*Problem Description
        Given an array of integers A, find and return the count of divisors of each element of the array.
        NOTE: The order of the resultant array should be the same as the input array.

        Problem Constraints
        1 <= length of the array <= 100000
        1 <= A[i] <= 106

        Input Format
        The only argument given is the integer array A.

        Output Format
        Return the count of divisors of each element of the array in the form of an array.

        Example Input
        Input 1:
        A = [2, 3, 4, 5]
        Input 2:
        A = [8, 9, 10]

        Example Output
        Output 1:
        [2, 2, 3, 2]
        Output 1:
        [4, 3, 4]

        Example Explanation
        Explanation 1:
        The number of divisors of 2 : [1, 2], 3 : [1, 3], 4 : [1, 2, 4], 5 : [1, 5]
        So the count will be [2, 2, 3, 2].
        Explanation 2:
        The number of divisors of 8 : [1, 2, 4, 8], 9 : [1, 3, 9], 10 : [1, 2, 5, 10]
        So the count will be [4, 3, 4].*/
public class CountOfDivisors {
    public static int[] solve(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++)
            max = Math.max(max, A[i]);
        int[] sieve_arr = new int[max + 1];
        int[] result_arr = new int[A.length];
        for (int i = 2; i * i <= max; i++)
            for (int j = i * i; j <= max; j = j + i)
                sieve_arr[j] = (j == i * i) ? sieve_arr[j] + 1 : sieve_arr[j] + 2;
        for (int i = 0; i < A.length; i++)
            result_arr[i] = (A[i] == 1) ? 1 : sieve_arr[A[i]] + 2;
        return result_arr;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{2, 3, 4, 5};
        int[] ans = solve(A);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(" " + ans[i]);
        }
    }
}
