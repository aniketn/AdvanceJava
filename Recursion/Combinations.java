package scaler.Adv.Recursion;

import java.util.ArrayList;

/*Problem Description
        Given two integers A and B, return all possible combinations of B numbers out of 1 2 3 ... A.
        Make sure the combinations are sorted.
        To elaborate,
        Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
        Entries should be sorted within themselves.
        WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

        Problem Constraints
        1 <= A, B <= 10

        Input Format
        The first argument is an integer A.
        The second argument is an integer B.

        Output Format
        Return a 2-D vector denoting all possible combinations.

        Example Input
        Input 1:
        A = 4
        B = 2
        Input 2:
        A = 3
        B = 2
        Example Output
        Output 1:
        [
        [1, 2],
        [1, 3],
        [1, 4],
        [2, 3],
        [2, 4],
        [3, 4],
        ]
        Output 2:
        [
        [1, 2],
        [1, 3],
        [2, 3]
        ]

        Example Explanation
        Explanation 1:

        All the possible combinations of size 2 in sorted order.*/
public class Combinations {
    private static ArrayList<ArrayList<Integer>> ans;

    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ans = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        solve(1, cur, A, B);
        return ans;
    }

    static void solve(int idx, ArrayList<Integer> cur, int A, int B) {
        if (cur.size() == B) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (idx == A + 1)
            return;
        // Include current element
        cur.add(idx);
        solve(idx + 1, cur, A, B);
        cur.remove(cur.size() - 1);
        // Don't include current element
        solve(idx + 1, cur, A, B);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<ArrayList<Integer>> ans = combine(4, 2);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println("" + ans.get(i));
        }
    }
}
