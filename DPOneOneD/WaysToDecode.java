package scaler.Adv.DPOneOneD;

/*Problem Description
        A message containing letters from A-Z is being encoded to
        numbers using the following mapping:
        'A' -> 1
        'B' -> 2
        ...
        'Z' -> 26
        Given an encoded message denoted by string A containing digits, determine
        the total number of ways to decode it modulo 109 + 7.

        Problem Constraints
        1 <= length(A) <= 105

        Input Format
        The first and the only argument is a string A.

        Output Format
        Return an integer, representing the number of ways to decode the string modulo 109 + 7.

        Example Input
        Input 1:
        A = "12"
        Input 2:
        A = "8"

        Example Output
        Output 1:
        2
        Output 2:
        1

        Example Explanation
        Explanation 1:
        Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
        The number of ways decoding "12" is 2.
        Explanation 2:
        Given encoded message "8", it could be decoded as only "H" (8).
        The number of ways decoding "8" is 1.*/
public class WaysToDecode {

    public static int CountWays(String A) {
        int[] dp = new int[A.length()];
        dp[0] = 1;

        int mod = 1000 * 1000 * 1000 + 7;
        if (A.length() == 1 && A.charAt(0) == '0') return 0;

        for (int i = 1; i < dp.length; i++) {
            if (i == 1 && A.charAt(i - 1) == '0') {    //check for 1st place zero
                dp[i] = 0;
            } else if (A.charAt(i - 1) == '0' && A.charAt(i) == '0') {     // both zero check
                dp[i] = 0;
            } else if (A.charAt(i - 1) == '0' && A.charAt(i) != '0') {   //first  zero and second non zero check
                dp[i] = dp[i - 1] % mod;
            } else if (A.charAt(i - 1) != '0' && A.charAt(i) == '0') {   //if first non zero and 2nd is zero then check if they are exceeding 26
                //12-20 is valid but 122-0 or 12-30 will be invalid
                if (A.charAt(i - 1) == '1' || A.charAt(i - 1) == '2') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 1) % mod;           //if you are usig i-2 then check for exception cuz we are starting from 1
                } else {
                    dp[i] = 0;
                }
            } else {
                if ((Integer.parseInt(A.substring(i - 1, i + 1)) <= 26)) {        //if both are non zero check iff they are less than 26 then check for 123-4 and 12-34
                    dp[i] = (dp[i - 1] + (i >= 2 ? dp[i - 2] : 1)) % mod;       //if you are usig i-2 then check for exception cuz we are starting from 1
                } else {
                    dp[i] = dp[i - 1] % mod;
                }
            }
        }
        return dp[A.length() - 1] % mod;
    }

    public static void main(String[] args) {
        System.out.println(CountWays("a"));
    }

}
