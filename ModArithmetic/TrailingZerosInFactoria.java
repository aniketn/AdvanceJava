package scaler.Adv.ModArithmetic;

/*Problem Description
        Given an integer A, return the number of trailing zeroes in A! i.e., factorial of A.
        Note: Your solution should run in logarithmic time complexity.

        Problem Constraints
        1 <= A <= 109

        Input Format
        First and only argument is a single integer A.

        Output Format
        Return a single integer denoting number of zeroes.

        Example Input
        Input 1        A = 5
        Input 2:        A = 6

        Example Output
        Output 1:        1
        Output 2:        1

        Example Explanation
        Explanation 1:
        A! = 120.
        Number of trailing zeros = 1. So, return 1.
        Explanation 2:
        A! = 720
        Number of trailing zeros = 1. So, return 1.*/
public class TrailingZerosInFactoria {
    public static int trailingZeros(int n) {
        // basically to get how many time 5 is present in given number since 5 *2 contribute to zero
        // and 2 is mostly present we need count of 5
        // so keep dividing number by powers of 5
        int count = 0;
        while (n > 0) {
            n = n / 5;
            count = count + n;
        }
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(trailingZeros(5));
    }
}
