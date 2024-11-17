package scaler.Adv.BackTrackingOne;

import java.util.ArrayList;
import java.util.Collections;

/*Problem Description
        Given a collection of integers denoted by array A of size N that might contain duplicates,
         return all possible subsets.

        NOTE:
        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.
        The subsets must be sorted lexicographically.

        Problem Constraints
        0 <= N <= 16

        Input Format
        Only argument is an integer array A of size N.

        Output Format
        Return a 2-D vector denoting all the possible subsets.

        Example Input
        Input 1:
        A = [1, 2, 2]
        Input 2:
        A = [1, 1]

        Example Output
        Output 1:
        [
        [],
        [1],
        [1, 2],
        [1, 2, 2],
        [2],
        [2, 2]
        ]
        Output 2:
        [
        [],
        [1],
        [1, 1]
        ]

        Example Explanation
        Explanation 1:
        All the subsets of the array [1, 2, 2] in lexicographically sorted order.*/
public class SubsetsTwo {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ans.add(new ArrayList<Integer>());
        subsetDupes(A, 0, new ArrayList<Integer>());
        return ans;
    }

    public static void subsetDupes(ArrayList<Integer> A, int i, ArrayList<Integer> entry) {
        if (i >= A.size()) {
            return;
        }
        entry.add(A.get(i));
        ans.add(new ArrayList(entry));
        subsetDupes(A, i + 1, entry);

        int x = entry.remove(entry.size() - 1);
        while (i < A.size() - 1 && x == A.get(i + 1)) {
            i = i + 1;
        }
        subsetDupes(A, i + 1, entry);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(2);
        ArrayList<ArrayList<Integer>> ans = subsetsWithDup(A);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
