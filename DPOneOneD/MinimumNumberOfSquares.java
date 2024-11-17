package scaler.Adv.DPOneOneD;

/*Problem Description
        Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.

        Problem Constraints
        1 <= A <= 105

        Input Format
        First and only argument is an integer A.

        Output Format
        Return an integer denoting the minimum count.

        Example Input
        Input 1:
        A = 6
        Input 2:
        A = 5

        Example Output
        Output 1:
        3
        Output 2:
        2

        Example Explanation
        Explanation 1:
        Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
        Minimum count of numbers, sum of whose squares is 6 is 3.
        Explanation 2:
        We can represent 5 using only 2 numbers i.e. 12 + 22 = 5*/
public class MinimumNumberOfSquares {
    public static int countMinSquares(int A) {
        int n = A;
        // We need to add a check
        // here for n. If user enters
        // 0 or 1 or 2
        // the below array creation
        // will go OutOfBounds.
        if (n <= 3)
            return n;

        // Create a dynamic programming
        // table
        // to store sq
        int dp[] = new int[n + 1];

        // getMinSquares table for
        // base case entries
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        // getMinSquares rest of the
        // table using recursive
        // formula
        for (int i = 4; i <= n; i++) {
            // max value is i as i can
            // always be represented
            // as 1*1 + 1*1 + ...
            dp[i] = i;
            // Go through all smaller numbers to
            // to recursively find minimum
            for (int x = 1; x <= Math.ceil(Math.sqrt(i)); x++) {
                int temp = x * x;
                if (temp > i)
                    break;
                else
                    dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
            }
        }
        // Store result and free dp[]
        int res = dp[n];
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countMinSquares(6));
    }
}
