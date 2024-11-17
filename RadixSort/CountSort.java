package scaler.Adv.RadixSort;

import java.util.HashMap;

/*Problem Description
        Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.

        Problem Constraints
        1 <= |A| <= 105
        1 <= A[i] <= 105

        Input Format
        The first argument is an integer array A.

        Output Format
        Return an integer array that is the sorted array A.

        Example Input
        Input 1:
        A = [1, 3, 1]
        Input 2:
        A = [4, 2, 1, 3]

        Example Output
        Output 1:
        [1, 1, 3]
        Output 2:
        [1, 2, 3, 4]

        Example Explanation
        For Input 1:
        The array in sorted order is [1, 1, 3].
        For Input 2:
        The array in sorted order is [1, 2, 3, 4].*/
public class CountSort {
    public static int[] solve(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            }
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }
        int k = 0;
        for (int i = 0; i < max + 1; i++) {
            if (map.containsKey(i)) {
                for (int j = 0; j < map.get(i); j++) {
                    A[k] = i;
                    k++;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{6, 3, 3, 6, 7, 8, 7, 3, 7};
        int[] ans = solve(A);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("" + ans[i]);
        }
    }
}
