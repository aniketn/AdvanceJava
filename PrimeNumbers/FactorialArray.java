package scaler.Adv.PrimeNumbers;

import java.util.Arrays;
import java.util.HashMap;

/*Problem Description
        Groot has an array A of size N. Boring, right? Groot thought so too, so he decided to construct
        another array B of the same size and defined elements of B as:
        B[i] = factorial of A[i] for every i such that 1<= i <= N.
        factorial of a number X denotes (1 x 2 x 3 x 4......(X-1) x (X)).
        Now Groot is interested in the total number of non-empty subsequences of array B such that every
        element in the subsequence has the same non-empty set of prime factors.
        Since the number can be huge, return it modulo 109 + 7.

        NOTE: A set is a data structure having only distinct elements. E.g : the set of prime factors of Y=12
        will be {2,3} and not {2,2,3}
        Problem Constraints
        1 <= N <= 105
        1 <= A[i] <= 106
        Your code will run against a maximum of 5 test cases.

        Input Format
        Only argument is an integer array A of size N.

        Output Format
        Return an integer deonting the total number of non-empty subsequences of array B such that every
        element in the subsequence has the same set of prime factors modulo 109+7.

        Example Input
        Input 1:        A = [2, 3, 2, 3]
        Input 2:        A = [2, 3, 4]

        Example Output
        Output 1:        6
        Output 2:        4

        Example Explanation
        Explanation 1:
        Array B will be : [2, 6, 2, 6]
        The total possible subsequences are 6 : [2], [2], [2, 2], [6], [6], [6, 6].
        Input 2:
        Array B will be : [2, 6, 24]
        The total possible subsequences are 4 : [2], [6], [24], [6, 24].*/
public class FactorialArray {
    public static int solve(int[] A) {
        int max = getMax(A), ans = 0; //get max from A
        int[] spf = new int[max + 1];
        findSPF(max, spf);        // filling spf array with largest prime numbers till there
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : A) {
            if (i == 1) continue;
            hm.put(spf[i], hm.getOrDefault(spf[i], 0) + 1);
            ans += 1 << hm.get(spf[i]) - 1; // for every new occurrence, 2^count -1 subseq’s are possible
        }
        return ans;
    }

    public static void findSPF(int max, int[] spf) {
        Arrays.fill(spf, 1);
        int pre = 1, x = (int) Math.sqrt(max);
        for (int i = 2; i <= x; i++) {
            if (spf[i] == 1) {
                for (int j = i * i; j <= max; j += i) {
                    spf[j] = 0; // marking non-prime numbers
                }
            }
        }
        for (int i = 2; i <= max; i++) {
            if (spf[i] == 1) {
                pre = i; //using carry forward approach to fill the largest prime number
            }
            spf[i] = pre;
        }
    }

    public static int getMax(int[] A) {
        int max = 1 << 31;
        for (int i : A) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{2, 3, 2, 3};
        System.out.println(solve(A));
    }
}
