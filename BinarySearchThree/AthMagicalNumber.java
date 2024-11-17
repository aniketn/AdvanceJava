package scaler.Adv.BinarySearchThree;

/*Problem Description
        You are given three positive integers, A, B, and C.
        Any positive integer is magical if divisible by either B or C.
        Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

        Problem Constraints
        1 <= A <= 109
        2 <= B, C <= 40000

        Input Format
        The first argument given is an integer A.
        The second argument given is an integer B.
        The third argument given is an integer C.

        Output Format
        Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

        Example Input
        Input 1:
        A = 1
        B = 2
        C = 3
        Input 2:
        A = 4
        B = 2
        C = 3

        Example Output
        Output 1:        2
        Output 2:        6

        Example Explanation
        Explanation 1:
        1st magical number is 2.
        Explanation 2:
        First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.*/


/*Intution: Before solving this problem lets first understand some of the concepts:
        1.) If you have to tell how many numbers less than x are divisible by n,
        then you do x/n to calculate. For example if x = 14 and n = 3 then x/n = 4
         that means there are 4 numbers less than 14 which are divisible by 3 (i.e., 3, 6, 9, 12).
        2.) So in case you are given 2 numbers n1 and n2 then you have to check for
        both the numbers similarly. For example, x = 25, n1 = 3, n2 = 4,
        then x/n1 = 8 (3, 6, 9, 12,15,18,21,24) and x/n2 = 6 (4, 8, 12,16,20,24),
        so the answer should be 8+6 = 14. But if u see then we have 12 and 24 repeated for n1 and n2
        and these are nothing but the multiples of LCM of n1 and n2. And this is obvious also,
        the common multiples will repeat in both the cases, so we need to subtract common multiples.
        3.) So now total will be x/n1 + x/n2 - x/LCM(a,b) = 25/3 + 25/4 - 25/12 = 8 + 6 - 2 = 12.
        And this is the maths for this question.
        4.) Now to find LCM we know that n1 * n2 = LCM(n1,n2) * GCD(n1,n2)
        5.) Now we just need to binary search between lowest and highest range.
        6.) Lower limit will be min(n1,n2) and higher limit n * min(n1,n2)

        Time Complexity: O(log(n*min(n1,n2))*/
public class AthMagicalNumber {
    public static int solve(int A, int B, int C) {
        long low = Math.min(B, C);
        long high = low * A;
        long greater = Math.max(B, C);
        long smallest = Math.min(B, C);
        long lcm = 0;
        for (long i = greater; ; i += greater) {
            if (i % smallest == 0) {
                lcm = i;
                break;
            }
        }

        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid / B + mid / C - mid / lcm < A)
                low = mid + 1;
            else
                high = mid - 1;
        }
            return (int) (low % 1000000007);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve(3,6,4));
    }
}
