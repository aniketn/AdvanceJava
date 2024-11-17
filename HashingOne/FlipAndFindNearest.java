package scaler.Adv.HashingOne;

import java.util.ArrayList;
import java.util.TreeSet;

/*Problem Description
        Given a binary string A of size N. There are Q queries given by the array B of size Q*2.
        Each query is given by :-
        1 X :- Flip the bit of the X-th position in A
        2 X :- Find the index of the nearest '1' from X. If there are multiple such indexes,
        return the one with the lower index. Return -1 if there are no '1's in A
        Note :- We use 1-based indexing

        Problem Constraints
        1 <= N <= 105
        1 <= Q <= 105
        1 <= B[i][0] <= 2
        1 <= B[i][1] <= N

        Input Format
        First argument A is a string.
        Second argument B is a 2D array of integers describing the queries.

        Output Format
        Return an array of integers denoting the answers to each query of type 2.

        Example Input
        Input 1:
        A = "10010"
        B = [[1, 2]
        [2, 3]]
        Input 2:
        A = "010000100"
        B = [[2, 5]
        [1, 7]
        [2, 9]]

        Example Output
        Output 1:
        [2]
        Output 2:
        [7, 2]

        Example Explanation
        For Input 1:
        After first query, A = "11010".
        For second query, X = 3. Both index 2 and index 4 are at the same
        distance but we choose the lower index.
        For Input 2:
        For first query, the index 2 is at a distance 3 and index 7 is at a distance 2. So we choose
        index 7.
        After second query, A = "010000000"
        For third query, the only index with '1' is 2.*/
public class FlipAndFindNearest {
    public static int[] solve(String A, int[][] B) {
        TreeSet<Integer> set = new TreeSet<>();
        int n = A.length();

        //Put all indexes with the character 1 in the TreeSet
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                set.add(i + 1);
            }
        }

        //Since we do not know how many 2 X queires will be there
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < B.length; i++) {
            //Operation to be performed
            int ops = B[i][0];
            //1 based index ops to be done on
            int index = B[i][1];
            if (ops == 1) {
                if (set.contains(index)) {
                    set.remove(index);
                } else {
                    set.add(index);
                }
            } else {
                int left = Integer.MIN_VALUE, right = Integer.MAX_VALUE;
                if (set.ceiling(index) != null) {
                    // finds the nearest '1' on the right
                    right = set.ceiling(index);
                }
                if (set.floor(index) != null) {
                    // finds the nearest '1' on the left
                    left = set.floor(index);
                }
                if (left == Integer.MIN_VALUE && right == Integer.MAX_VALUE) {
                    ans.add(-1);
                } else if (left != Integer.MIN_VALUE && (index - left <= right - index)) {
                    ans.add(left);
                } else {
                    ans.add(right);
                }
            }
        }

        int[] res = new int[ans.size()];
        int j = 0;
        for (int i = 0; i < ans.size(); i++) {
            res[j++] = ans.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] B = new int[][]{{1, 2}, {2, 3}};
        int[] ans=solve("10010", B);
        for(int i=0;i<ans.length;i++)
        {
            System.out.println(""+ans[i]);
        }
    }
}
