package scaler.Adv.BackTrackingOne;

import java.util.Arrays;

/*Problem Description
        Given an array of integers A, the array is squareful if for every pair
        of adjacent elements, their sum is a perfect square.

        Find and return the number of permutations of A that are squareful.
        Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].

        Problem Constraints
        1 <= length of the array <= 12
        1 <= A[i] <= 109

        Input Format
        The only argument given is the integer array A.

        Output Format
        Return the number of permutations of A that are squareful.

        Example Input
        Input 1:
        A = [2, 2, 2]
        Input 2:
        A = [1, 17, 8]

        Example Output
        Output 1:
        1
        Output 2:
        2

        Example Explanation
        Explanation 1:
        Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
        Explanation 2:
        Permutation are [1, 8, 17] and [17, 8, 1].*/

  /*  1) sort the array
    2) condition for the next element
    condition-1: visited[i]==false
    condition-2 i==0 || (nums[i]!=nums[i-1] || visited[i-1]==true)
    condtion 3:  prev==-1 || arr[prev]+arr[i] (perfect square)*/

public class NumberOfSquarefulArrays {
    static boolean isPerfect(int num1, int num2) {
        long xx = num1 + num2;
        int root = (int) Math.sqrt(xx);
        return (long) root * root == xx;
    }

    static int helper(int count, int[] arr, int prevIdx, boolean[] visited) {
        if (count == arr.length) return 1;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (visited[i] == false && (i == 0 || (arr[i] != arr[i - 1] || visited[i - 1])) && (prevIdx == -1 || isPerfect(arr[prevIdx], arr[i]))) {
                visited[i] = true;
                ans += helper(count + 1, arr, i, visited);
                visited[i] = false;
            }
        }
        return ans;
    }

    public static int solve(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        if (n == 1) return 0;
        boolean[] visited = new boolean[n];
        return helper(0, A, -1, visited);
        // return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 17, 8};
        System.out.println(solve(A));
    }
}

