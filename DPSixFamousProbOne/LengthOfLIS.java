package scaler.Adv.DPSixFamousProbOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*Problem Description
        You are given an array A. You need to find the length
        of the Longest Increasing Subsequence in the array.

        In other words, you need to find a subsequence of array
        A in which the elements are in sorted order, (strictly increasing) and as long as possible.

        Problem Constraints
        1 ≤ length(A), A[i] ≤ 105

        Input Format
        The first and only argument of the input is the array A.

        Output Format
        Output a single integer, the length of the longest increasing subsequence in array A.

        Example Input
        Input 1:
        A: [2, 1, 4, 3]
        Input 2:
        A: [5, 6, 3, 7, 9]

        Example Output
        Output 1:
        2
        Output 2:
        4

        Example Explanation
        Explanation 1:
        [2, 4] and [1, 3] are the longest increasing sequences of size 2.
        Explanation 2:
        The longest increasing subsequence we can get is [5, 6, 7, 9] of size 4.*/
public class LengthOfLIS {
    /*public static int findLIS(int[] A) {
        int n = A.length;
        int overallmax = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;

            if (dp[i] > overallmax) {
                overallmax = dp[i];
            }
        }
        return overallmax;
    }*/

    public static int findLIS(ArrayList<Integer> A) {
        int N = A.size();
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(A.get(0));

        for (int i = 1; i < N; i++) {
            if (A.get(i) > dp.get(dp.size() - 1)) {
                dp.add(A.get(i));
            } else {
                /* Arrays.binarySearch is similar to the lower_bound function in C++.
                    The main difference is that if the number being searched for is not found,
                    Arrays.binarySearch returns a negative value instead of an index.
                    To handle this, you can use the formula -1 * (insertion point + 1)
                    to get the index where the element
                    should be inserted to maintain the sorted order of the array. */
                int idx = Collections.binarySearch(dp, A.get(i));
                int positiveIdx = idx >= 0 ? idx : -(idx + 1);
                if (positiveIdx != dp.size()) dp.set(positiveIdx, A.get(i));
            }
        }
        return dp.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(5);
        A.add(6);
        A.add(3);
        A.add(7);
        A.add(9);
        System.out.println(findLIS(A));
    }
}
