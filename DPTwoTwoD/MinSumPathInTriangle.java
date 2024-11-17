package scaler.Adv.DPTwoTwoD;

import java.util.ArrayList;
import java.util.Arrays;

/*Problem Description
        Given a triangle, find the minimum path sum from top to bottom.
        Each step you may move to adjacent numbers on the row below.

        Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row

        Problem Constraints
        |A| <= 1000
        A[i] <= 1000

        Input Format
        First and only argument is the vector of vector A defining the given triangle

        Output Format
        Return the minimum sum

        Example Input
        Input 1:
        A = [
        [2],
        [3, 4],
        [6, 5, 7],
        [4, 1, 8, 3]
        ]
        Input 2:
        A = [ [1] ]

        Example Output
        Output 1:
        11
        Output 2:
        1

        Example Explanation
        Explanation 1:
        The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
        Explanation 2:
        Only 2 can be collected.*/
public class MinSumPathInTriangle {
    public static int minimumTotal(int[][] a) {
        int N = a.length;
        int[] dp = new int[a.length];

        for (int i = 0; i < N; i++) {
            dp[i] = a[N - 1][i];
        }
        for (int i = N - 2; i >= 0; i--) {
            int M = a[i].length;
            for (int j = 0; j < M; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + a[i][j];
            }
        }
        return dp[0];
        /*int N = a.size();
        for (int i = N - 2; i >= 0; i--) {
            int M = a.get(i).size();
            for (int j = 0; j < M; j++) {
                int curr = a.get(i).get(j);
                int left = a.get(i + 1).get(j); //left adjacent
                int right = a.get(i + 1).get(j + 1); //right adjacent

                int min = Math.min(left, right);
                a.get(i).set(j, curr + min);
            }
        }
        return a.get(0).get(0);*/
    }

    public static void main(String[] args) {
       /* ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(2)));
        A.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        A.add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
        A.add(new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3)));*/
        int[][] A = new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        System.out.println(minimumTotal(A));
        //minimumTotal(A);
    }

}
