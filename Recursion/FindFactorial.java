package scaler.Adv.Recursion;
/*Problem Description
        Write a program to find the factorial of the given number A using recursion.

        Problem Constraints
        0 <= A <= 12

        Input Format
        First and only argument is an integer A.

        Output Format
        Return an integer denoting the factorial of the number A.

        Example Input
        Input 1:        A = 4
        Input 2:        A = 1

        Example Output
        Output 1:        24
        Output 2:        1

        Example Explanation
        Explanation 1:
        Factorial of 4 = 4 * 3 * 2 * 1 = 24
        Explanation 2:
        Factorial of 1 = 1*/
public class FindFactorial {
    public static int solve(int A) {
        int ans = 0;
        if(A==1) return 1;
        ans = solve(A-1)*A;
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve(5));
    }
}
