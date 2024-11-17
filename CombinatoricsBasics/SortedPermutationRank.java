package scaler.Adv.CombinatoricsBasics;

/*Problem Description
        Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
        Assume that no characters are repeated.
        Note: The answer might not fit in an integer, so return your answer % 1000003

        Problem Constraints
        1 <= |A| <= 1000

        Input Format
        First argument is a string A.

        Output Format
        Return an integer denoting the rank of the given string.

        Example Input
        Input 1:        A = "acb"
        Input 2:        A = "a"
        Example Output
        Output 1:       2
        Output 2:       1

        Example Explanation
        Explanation 1:
        Given A = "acb".
        The order permutations with letters 'a', 'c', and 'b' :
        abc
        acb
        bac
        bca
        cab
        cba
        So, the rank of A is 2.
        Explanation 2:
        Given A = "a".
        Rank is clearly 1.*/
public class SortedPermutationRank {
    public static int findRank(String A) {
        int len = A.length(), mod = 1000003;
        long count = 0, permutationsAfterCur = 1;
        for (int i = len - 1; i >= 0; i--) {
            char curChar = A.charAt(i);
            int rightCharsLessThanCur = 0;
            for (int j = i + 1; j < len; j++) {
                if (curChar > A.charAt(j))
                    rightCharsLessThanCur++;
            }
            if (i < len - 1) // excluding (0!) for element at length-1 position
                permutationsAfterCur = (permutationsAfterCur * (len - i - 1)) % mod;
            count = (count + (permutationsAfterCur * rightCharsLessThanCur) % mod) % mod;
        }
        return (int) (count + 1); // (+1) for handling element at length-1 position
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(findRank("acb"));
    }
}
