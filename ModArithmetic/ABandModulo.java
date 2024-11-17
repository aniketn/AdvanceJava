package scaler.Adv.ModArithmetic;
/*Problem Description
        Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.

        Problem Constraints
        1 <= A, B <= 109
        A != B

        Input Format
        The first argument is an integer A.
        The second argument is an integer B.

        Output Format
        Return an integer denoting the greatest possible positive M.

        Example Input
        Input 1:
        A = 1
        B = 2
        Input 2:
        A = 5
        B = 10

        Example Output
        Output 1:        1
        Output 2:        5

        Example Explanation
        Explanation 1:
        1 is the largest value of M such that A % M == B % M.
        Explanation 2:
        For M = 5, A % M = 0 and B % M = 0.
        No value greater than M = 5, satisfies the condition.*/
public class ABandModulo {
   /* => A % M = B % M
=> A % M - B % M = 0
    Adding M on both sides
=> A % M - B % M + M = M
    Taking mod of M on both sides
=> (A % M - B % M + M) % M = M % M
    We know that ( A - B ) % M = (A % M - B % M + M) % M
    Also, M % M = 0
            => (A - B) % M = 0
    The above expression says that M is dividing A - B completely which is why it is giving the remainder as 0
    That means the greatest possible value of M which satisfies the above equation would be A - B only
    Hence A - B is our answer.*/
    public static int solve(int A, int B) {
        if(A > B) {
            return A - B;
        }
        return B - A;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve(1,2));
    }
}
