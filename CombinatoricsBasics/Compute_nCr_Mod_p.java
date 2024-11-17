package scaler.Adv.CombinatoricsBasics;

/*Problem Description
        Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is
        a prime number greater than equal to n, find and return the
        value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
        x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

        NOTE: For this problem, we are considering 1 as a prime.

        Problem Constraints
        1 <= A <= 106
        1 <= B <= A
        A <= C <= 109+7

        Input Format
        The first argument given is the integer A ( = n).
        The second argument given is the integer B ( = r).
        The third argument given is the integer C ( = p).

        Output Format
        Return the value of nCr % p.
        Example Input
        Input 1:
        A = 5
        B = 2
        C = 13
        Input 2:
        A = 6
        B = 2
        C = 13

        Example Output
        Output 1:
        10
        Output 2:
        2

        Example Explanation
        Explanation 1:
        nCr( n=5 and r=2) = 10.
        p=13. Therefore, nCr%p = 10.*/
public class Compute_nCr_Mod_p {
    public static int solve(int A, int B, int C) {
        long numerator = factorial(A, C);
        long denominator = (factorial(B, C) * factorial(A - B, C)) % C;

        //By Applying Fermat's Little Theorem to calculate the inverse modulo
        long result = (numerator * pow(denominator, C - 2, C)) % C;
        return (int) result;
    }

    private static long factorial(long A, long C) {
        long result = 1;
        for (long i = 2; i <= A; i++) {
            result = (result * i) % C;
        }
        return result;
    }

    private static long pow(long A, long B, long C) {
        long A_new = (A + C) % C;
        if (A_new == 0) {
            return 0;
        }
        if (B == 0) {
            return 1;
        }

        long calculatedResult = pow(A_new, B / 2, C);

        if (B % 2 == 0) {
            return ((calculatedResult * calculatedResult) % C);
        } else {
            return (((calculatedResult * calculatedResult) % C * A_new) % C);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve(5, 2, 13));
    }
}
