package scaler.Adv.ModArithmetic;

/*Problem Description
        Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
        "^" means power,
        "%" means "mod", and
        "!" means factorial.

        Problem Constraints
        1 <= A, B <= 5e5

        Input Format
        First argument is the integer A
        Second argument is the integer B

        Output Format
        Return one integer, the answer to the problem

        Example Input
        Input 1:
        A = 1
        B = 1
        Input 2:
        A = 2
        B = 2

        Example Output
        Output 1:
        1
        Output 2:
        4

        Example Explanation
        Explanation 1:
        1! = 1. Hence 1^1 = 1.
        Explanation 2:
        2! = 2. Hence 2^2 = 4.*/
public class VeryLargePower {
    static long check(long A, long B) {
        if (B == 0)
            return 1;
        long ans = check(A, B / 2);

        if (B % 2 == 0) {
            return (ans * ans) % 1000000007;
        } else {
            return ((ans * ans) % 1000000007 * (A % 1000000007)) % 1000000007;
        }

    }

    public static int solve(int A, int B) {
        long ans = A;
        for (int i = B; i >= 1; i--) {
            ans = check(ans, i);//ex:2^6=2^(3*2)=8^2=64
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve(1,1));
    }
}
