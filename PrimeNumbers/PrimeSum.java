package scaler.Adv.PrimeNumbers;

import java.util.Arrays;

/*Problem Description
        Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to
        the given number.

        If there is more than one solution possible, return the lexicographically smaller solution.

        If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
        [a, b] < [c, d], If a < c OR a==c AND b < d.
        NOTE: A solution will always exist. Read Goldbach's conjecture.

        Problem Constraints
        4 <= A <= 2*107

        Input Format
        First and only argument of input is an even number A.

        Output Format
        Return a integer array of size 2 containing primes whose sum will be equal to given number.

        Example Input
        4
        Example Output
        [2, 2]

        Example Explanation
        There is only 1 solution for A = 4.*/
public class PrimeSum {
    public static int[] primesum(int A) {
        int[] outPut = new int[2];

        boolean[] isPrime = new boolean[A + 1];
        isPrime = sieve(isPrime, A);

        for (int i = 2; i < isPrime.length; i++) {
            int a = A - i, b = i;
            if (isPrime[a] && isPrime[b]) {
                outPut[0] = a;
                outPut[1] = b;
            }
        }
        return outPut;
    }

    static boolean[] sieve(boolean[] isPrime, int A) {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] ans = primesum(4);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(" " + ans[i]);
        }
    }
}
