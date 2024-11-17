package scaler.Adv.BackTrackingTwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/*Problem Description
        Given an array of size N of candidate numbers A and a target number B.
        Return all unique combinations in A where the candidate numbers sums to B.

        Each number in A may only be used once in the combination.

        Note:
        All numbers (including target) will be positive integers.
        Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
        The solution set must not contain duplicate combinations.
        Warning:
        DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
        Example : itertools.combinations in python. If you do,
        we will disqualify your submission and give you penalty points.

        Problem Constraints
        1 <= N <= 20

        Input Format
        First argument is an integer array A denoting the collection of candidate numbers.
        Second argument is an integer which represents the target number.

        Output Format
        Return all unique combinations in A where the candidate numbers sums to B.

        Example Input
        Input 1:
        A = [10, 1, 2, 7, 6, 1, 5]
        B = 8
        Input 2:
        A = [2, 1, 3]
        B = 3

        Example Output
        Output 1:
        [
        [1, 1, 6 ],
        [1, 2, 5 ],
        [1, 7 ],
        [2, 6 ]
        ]
        Output 2:
        [
        [1, 2 ],
        [3 ]
        ]

        Example Explanation
        Explanation 1:
        1 + 1 + 6 = 8
        1 + 2 + 5 = 8
        1 + 7 = 8
        2 + 6 = 8
        All the above combinations sum to 8 and are arranged in ascending order.
        Explanation 2:
        1 + 2 = 3
        3 = 3
        All the above combinations sum to 3 and are arranged in ascending order.*/
public class CombinationSumII {
    static ArrayList<ArrayList<Integer>> ans;
    static HashSet<String> set;

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        set = new HashSet<>();
        ans = new ArrayList<>();
        Collections.sort(A);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++)
            map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        combinations(new ArrayList<>(), B, A, map);
        return ans;
    }

    private static void combinations(ArrayList<Integer> arrangement, int target, ArrayList<Integer> A, HashMap<Integer, Integer> map) {

        if (target == 0) {
            ArrayList<Integer> arr = new ArrayList<>(arrangement);
            Collections.sort(arr);
            if (set.add(arr.toString()))
                ans.add(new ArrayList<Integer>(arrangement));
            return;
        }
        for (int key : A) {
            if (map.get(key) > 0 && target - key >= 0) {
                target -= key;
                arrangement.add(key);
                map.put(key, map.get(key) - 1);
                combinations(arrangement, target, A, map);
                arrangement.remove(arrangement.size() - 1);
                target += key;
                map.put(key, map.get(key) + 1);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(10);
        A.add(1);
        A.add(2);
        A.add(7);
        A.add(6);
        A.add(1);
        A.add(5);
        ArrayList<ArrayList<Integer>> ans = combinationSum(A, 8);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
