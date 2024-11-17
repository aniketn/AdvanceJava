package scaler.Adv.BackTrackingTwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/*Problem Description
        Given an array of candidate numbers A and a target number B,
        find all unique combinations in A where the candidate numbers sums to B.

        The same repeated number may be chosen from A unlimited number of times.

        Note:
        1) All numbers (including target) will be positive integers.
        2) Elements in a combination (a1, a2, … , ak) must be in non-descending order.
        (ie, a1 ≤ a2 ≤ … ≤ ak).
        3) The combinations themselves must be sorted in ascending order.
        4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1
         AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)
        5) The solution set must not contain duplicate combinations.

        Problem Constraints
        1 <= |A| <= 20
        1 <= A[i] <= 50
        1 <= B <= 500

        Input Format
        The first argument is an integer array A.
        The second argument is integer B.

        Output Format
        Return a vector of all combinations that sum up to B.

        Example Input
        Input 1:
        A = [2, 3]
        B = 2
        Input 2:
        A = [2, 3, 6, 7]
        B = 7

        Example Output
        Output 1:
        [ [2] ]
        Output 2:
        [ [2, 2, 3] , [7] ]

        Example Explanation
        Explanation 1:
        All possible combinations are listed.
        Explanation 2:
        All possible combinations are listed.*/
public class CombinationSum {
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
        for (int element : A) {
            if (target - element >= 0) {
                target -= element;
                arrangement.add(element);
                combinations(arrangement, target, A, map);
                arrangement.remove(arrangement.size() - 1);
                target += element;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(3);
        A.add(6);
        A.add(7);
        ArrayList<ArrayList<Integer>> ans = combinationSum(A, 7);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
