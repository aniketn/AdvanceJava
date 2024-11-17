package scaler.Adv.PrimeNumbers;
/*Problem Description
        A lucky number is a number that has exactly 2 distinct prime divisors.
        You are given a number A, and you need to determine the count of lucky numbers between the
        range 1 to A (both inclusive).

        Problem Constraints
        1 <= A <= 50000

        Input Format
        The first and only argument is an integer A.

        Output Format
        Return an integer i.e the count of lucky numbers between 1 and A, both inclusive.

        Example Input
        Input 1:        A = 8
        Input 2:        A = 12

        Example Output
        Output 1:        1
        Output 2:        3*/
public class LuckyNumbers {
    public static int solve(int A) {
        //Modification of Sieve of Erastothenes Algorithm
        int[] isPrimeSieve = new int[A + 1];
        for (int p = 2; p <= A; p++) {
            //Only Prime
            if (isPrimeSieve[p] == 0) {
                //This will give an array consisting of number of prime divisors for each number
                for (int i = p; i <= A; i += p) {
                    isPrimeSieve[i] += 1;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= A; i++) {
            if (isPrimeSieve[i] == 2) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve(8));
    }

}
