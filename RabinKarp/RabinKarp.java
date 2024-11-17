package scaler.Adv.RabinKarp;

/*Problem Description
        Given two string A and B of length N and M respectively consisting of lowercase letters.
        Find the number of occurrences of B in A.

        Problem Constraints
        1 <= M <= N <= 105

        Input Format
        Two argument A and B are strings

        Output Format
        Return an integer denoting the number of occurrences of B in A

        Example Input
        Input 1:
        A = "acbac"
        B = "ac"
        Input 2:
        A = "aaaa"
        B = "aa"

        Example Output
        Output 1:
        2
        Output 2:
        3

        Example Explanation
        For Input 1:
        The string "ac" occurs twice in "acbac".
        For Input 2:
        The string "aa" occurs thrice in "aaaa".*/
public class RabinKarp {
    public final static int d = 10;

    public static int rabinKarpAlgo(String A, String B) {
        int n = A.length();
        int m = B.length();
        int prime = 31;
        long mod = (long) Math.pow(10, 9) + 7;
        long[] power = new long[n];
        long[] hashA = new long[n];
        long hashB = 0;
        int count = 0;
// Precompute powers of prime
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * prime) % mod;
        }
// Compute hash values for A and B
        for (int i = 0; i < n; i++) {
            hashA[i] = ((i > 0 ? hashA[i - 1] : 0) + (A.charAt(i) - 'a' + 1) * power[i]) % mod;
            if (i < m) {
                hashB = (hashB + (B.charAt(i) - 'a' + 1) * power[i]) % mod;
            }
        }
// Traverse text and compare hash values
        for (int i = 0; i <= n - m; i++) {
            long currHash = (hashA[i + m - 1] - (i > 0 ? hashA[i - 1] : 0) + mod) % mod;
            if (currHash == hashB * power[i] % mod) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(rabinKarpAlgo("aaaa", "aa"));
    }
}

