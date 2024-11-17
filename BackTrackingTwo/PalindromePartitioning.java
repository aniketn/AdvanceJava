package scaler.Adv.BackTrackingTwo;

import java.util.ArrayList;

/*Problem Description
        Given a string A, partition A such that every string of the partition is a palindrome.

        Return all possible palindrome partitioning of A.
        Ordering the results in the answer : Entry i will come before Entry j if :
        len(Entryi[0]) < len(Entryj[0]) OR
        (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *
        (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))

        Problem Constraints
        1 <= len(A) <= 15

        Input Format
        First argument is a string A of lowercase characters.

        Output Format
        Return a list of all possible palindrome partitioning of s.

        Example Input
        Input 1:
        A = "aab"
        Input 2:
        A = "a"

        Example Output
        Output 1:
        [
        ["a","a","b"]
        ["aa","b"],
        ]
        Output 2:
        [
        ["a"]
        ]

        Example Explanation
        Explanation 1:

        In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
        Explanation 2:

        In the given example, only partition possible is "a" .*/
public class PalindromePartitioning {
    static ArrayList<ArrayList<String>> ans = new ArrayList<>();

    private static void helper(int start, String str, ArrayList<String> list, boolean[][] palindrome) {
        if (start == str.length()) {
            ans.add(new ArrayList(list));
            return;
        }
        for (int ind = start; ind < str.length(); ind++) {
            String substr = str.substring(start, ind + 1);
            if (str.charAt(start) == str.charAt(ind) && (ind - start <= 2 || palindrome[start + 1][ind - 1])) {
                list.add(substr);
                palindrome[start][ind] = true;
                helper(ind + 1, str, list, palindrome);
                list.remove(list.size() - 1);
            }
        }
    }

    public static ArrayList<ArrayList<String>> partition(String a) {
        int n = a.length();
        boolean[][] palindrome = new boolean[n][n];
        helper(0, a, new ArrayList<>(), palindrome);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> ans = partition("aab");
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
