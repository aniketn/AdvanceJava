package scaler.Adv.BackTrackingOne;

import java.util.*;

/*Problem Description
        Given an integer array A of size N denoting collection of numbers ,
        return all possible permutations.

        NOTE:
        No two entries in the permutation sequence should be the same.
        For the purpose of this problem, assume that all the numbers in the collection are unique.
        Return the answer in any order
        WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
        Example : next_permutations in C++ / itertools.permutations in python.
        If you do, we will disqualify your submission retroactively and give you penalty points.

        Problem Constraints
        1 <= N <= 9

        Input Format
        Only argument is an integer array A of size N.

        Output Format
        Return a 2-D array denoting all possible permutation of the array.

        Example Input
        A = [1, 2, 3]
        Example Output
        [ [1, 2, 3]
        [1, 3, 2]
        [2, 1, 3]
        [2, 3, 1]
        [3, 1, 2]
        [3, 2, 1] ]

        Example Explanation
        All the possible permutation of array [1, 2, 3].*/

//We have covered duplicate elements as well
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        permutelist(list, row, matrix);
        return matrix;
    }

    public static void permutelist(List<Integer> list, List<Integer> row, List<List<Integer>> matrix) {
        if (list.size() == 0) {
            matrix.add(new ArrayList<>(row));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            List<Integer> copy = new ArrayList<>(list);
            copy.remove(i);
            row.add(list.get(i));
            permutelist(copy, row, matrix);
            row.remove(row.size() - 1);
        }
    }

    public static void main(String[] args) {
        /*ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);*/
        int[] A = new int[]{1, 2, 3};
        List<List<Integer>> ans = permute(A);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
