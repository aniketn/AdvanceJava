package scaler.Adv.PrimeNumbers;

/*Problem Description
        Given an integer A. Find the list of all prime numbers in the range [1, A].

        Problem Constraints
        1 <= A <= 106

        Input Format
        Only argument A is an integer.

        Output Format
        Return a sorted array of prime number in the range [1, A].

        Example Input
        Input 1:        A = 7
        Input 2:        A = 12

        Example Output
        Output 1:        [2, 3, 5, 7]
        Output 2:        [2, 3, 5, 7, 11]

        Example Explanation
        For Input 1:
        The prime numbers from 1 to 7 are 2, 3, 5 and 7.
        For Input 2:
        The prime numbers from 1 to 12 are 2, 3, 5, 7 and 11.*/
public class FindAllPrimes {
    public static int[] solve(int A) {
        // Declare bool array to keep track of primes.
        boolean[] isPrime = new boolean[A + 1];

        isPrime[0] = false;   // 0 and 1 are not prime.
        isPrime[1] = false;

        // Initially, mark all elems as prime except 0 and 1.
        for (int n = 2; n <= A; n++) {
            isPrime[n] = true;
        }

        // Algo starts ->
        // for each No from 2, if we find any prime, mark all of its multiples as non-prime
        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = false;
                }
            }
        }


        // Check the count of primes so that we can create ans[]
        int count = 0;
        for (int k = 2; k <= A; k++) {
            if (isPrime[k]) {
                count++;
            }
        }

        // Populate prime numbers to ans[]
        int a = 0;
        int[] ans = new int[count];
        for (int l = 2; l <= A; l++) {
            if (isPrime[l]) {
                ans[a] = l;
                a++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] ans = solve(7);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(" " + ans[i]);
        }
    }
}
