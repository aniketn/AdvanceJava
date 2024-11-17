package scaler.Adv.DPOneOneD;

import java.util.ArrayList;
import java.util.Arrays;

/*Problem Description
        Given a 2 x N grid of integers, A, your task is to choose numbers from
         the grid such that sum of these numbers is maximized.
        However, you cannot choose two numbers that are adjacent horizontally,
        vertically, or diagonally.

        Return the maximum possible sum.

        Note: You are allowed to choose more than 2 numbers from the grid.

        Problem Constraints
        1 <= N <= 20000
        1 <= A[i] <= 2000

        Input Format
        The first and the only argument of input contains a 2d matrix, A.

        Output Format
        Return an integer, representing the maximum possible sum.

        Example Input
        Input 1:

        A = [
        [1]
        [2]
        ]
        Input 2:

        A = [
        [1, 2, 3, 4]
        [2, 3, 4, 5]
        ]

        Example Output
        Output 1:
        2
        Output 2:
        8

        Example Explanation
        Explanation 1:
        We will choose 2 (From 2nd row 1st column).
        Explanation 2:
        We will choose 3 (From 2nd row 2nd column) and 5 (From 2nd row 4th column).*/
public class MaxSumWithoutAdjacentElements {
    public static int adjacent(int grid[][]) {
        int n = grid[0].length;
        // Sum including maximum element of first
        // column
        int incl = Math.max(grid[0][0], grid[1][0]);

        // Not including first column's element
        int excl = 0, excl_new;

        // Traverse for further elements
        for (int i = 1; i < n; i++) {
            // Update max_sum on including or
            // excluding of previous column
            excl_new = Math.max(excl, incl);

            // Include current column. Add maximum element
            // from both row of current column
            incl = excl + Math.max(grid[0][i], grid[1][i]);

            // If current column doesn't to be included
            excl = excl_new;
        }

        // Return maximum of excl and incl
        // As that will be the maximum sum
        return Math.max(excl, incl);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        System.out.println(adjacent(grid));
    }
}
