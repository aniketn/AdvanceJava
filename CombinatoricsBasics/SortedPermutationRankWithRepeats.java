package scaler.Adv.CombinatoricsBasics;

/*Problem Description
        Given a string A, find the rank of the string amongst its permutations sorted lexicographically.
        Note that the characters might be repeated. If the characters are repeated, we need to look at the
        rank in unique permutations. Look at the example for more details.

        NOTE:
        The answer might not fit in an integer, so return your answer % 1000003 where 1000003 is a prime number.
        String A can consist of both lowercase and uppercase letters. Characters with lesser ASCII values are
        considered smaller, i.e., 'a' > 'Z'.

        Problem Constraints
        1 <= len(A) <= 1000000

        Input Format
        First argument is a string A.

        Output Format
        Return an integer denoting the rank.

        Example Input
        Input 1:        A = "aba"
        Input 2:        A = "bca"

        Example Output
        Output 1:        2
        Output 2:        4

        Example Explanation
        Explanation 1:
        The order permutations with letters 'a', 'a', and 'b' :
        aab
        aba
        baa
        So, the rank is 2.
        Explanation 2:
        The order permutations with letters 'a', 'b', and 'c' :
        abc
        acb
        bac
        bca
        cab
        cba
        So, the rank is 4.*/
public class SortedPermutationRankWithRepeats {
    public static int factorial(int A, int B) {
        long ans = 1;
        for (int i = 2; i <= A; i++) {
            ans = (ans * i) % B;
        }
        return (int) ans;
    }

    public static int power(int A, int B, int C) {
        if (A == 0)
            return 1;
        if (B == 0)
            return 1;
        long ans = power(A, B / 2, C);
        if (B % 2 == 0)
            return (int) (ans % C * ans % C) % C;
        return (int) (ans % C * ans % C * A % C) % C;
    }

    public static int findRank(String A) {
        int mod = 1000003;
        //initialise total count to 1 (rank start from 1)
        long totalCount = 1;

        //Loop to calculate smaller strings at rhs
        for (int i = 0; i < A.length(); i++) {
            long lessThanCount = 0;
            for (int j = i + 1; j < A.length(); j++) {
                if (A.charAt(j) < A.charAt(i))
                    lessThanCount++;
            }

        // This array keeps track of count of repeated characters
            //Check whether character is Upper or Lower and increment the respective
            // element in Frequency array
            int[] repition = new int[52];
            for (int j = i; j < A.length(); j++) {
                if (A.charAt(j) >= 'A' && A.charAt(j) <= 'Z')
                    repition[A.charAt(j) - 'A'] += 1;
                else
                    repition[A.charAt(j) - 'a' + 26] += 1;
            }

            // repitionFact is product of factorials of repeated characters as we divide them
            long repitionFact = 1;
            for (int j : repition)
                //Compute the Product of Factorials of Frequency of Characters
                repitionFact = (repitionFact * factorial(j, mod)) % mod;
            // The inverse is nothing but (a/b) % m formula applied to b means inverse
            long inverse = power((int) repitionFact, mod - 2, mod);
            //add the number of smaller string possible from index i to total count
            long perm = (factorial(A.length() - i - 1, mod) * inverse) % mod;
            totalCount = (totalCount + (lessThanCount * perm)) % mod;
        }
        return (int) totalCount;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(findRank("settLe"));
    }
}
