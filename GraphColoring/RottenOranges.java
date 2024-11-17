package scaler.Adv.GraphColoring;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*Problem Description
        Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
        Each cell can have three values:
        The value 0 representing an empty cell.
        The value 1 representing a fresh orange.
        The value 2 representing a rotten orange.
        Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom)
         to a rotten orange becomes rotten. Return the minimum number of minutes that
         must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

        Note: Your solution will run on multiple test cases.
        If you are using global variables, make sure to clear them.

        Problem Constraints
        1 <= N, M <= 1000
        0 <= A[i][j] <= 2

        Input Format
        The first argument given is the integer matrix A.

        Output Format
        Return the minimum number of minutes that must elapse until no cell has a fresh orange.
        If this is impossible, return -1 instead.

        Example Input
        Input 1:
        A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]
        Input 2:
        A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]

        Example Output
        Output 1:
        4
        Output 2:
        -1

        Example Explanation
        Explanation 1:
        Minute 0: [ [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1] ]
        Minute 1: [ [2, 2, 1]
        [2, 1, 0]
        [0, 1, 1] ]
        Minute 2: [ [2, 2, 2]
        [2, 2, 0]
        [0, 1, 1] ]
        Minute 3: [ [2, 2, 2]
        [2, 2, 0]
        [0, 2, 1] ]
        Minute 4: [ [2, 2, 2]
        [2, 2, 0]
        [0, 2, 2] ]
        At Minute 4, all the oranges are rotten.
        Explanation 2:
        The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.*/
public class RottenOranges {
    // This function finds the shortest path from the start point to the end point in a grid.
    public static int solve(int[][] A) {

        // Get the dimensions of the grid.
        int n = A.length;
        int m = A[0].length;

        // Create a graph to represent the grid.
        int[][] graph = new int[n][m];

        // Initialize the queue with the start point.
        Queue<Edge> line = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 2) {
                    line.offer(new Edge(i, j, 0));
                }
            }
        }

        // Initialize the answer to be the maximum possible distance.
        int ans = 0;


        int[][] directions = {
                {-1, 0}, // Up
                {0, -1}, // Left
                {1, 0}, // Down
                {0, 1}, // Right
        };

        // Iterate through the queue until it is empty.
        while (!line.isEmpty()) {

            // Get the current edge from the queue.
            Edge temp = line.poll();

            // Check if the current edge is within the bounds of the grid.
            if (temp.row >= 0 && temp.row < n && temp.col >= 0 && temp.col < m) {

                // Check the four directions for a valid neighbor.
                for (int i = 0; i < 4; i++) {

                    // Get the neighbor’s row and column.
                    int neighborRow = temp.row + directions[i][0];
                    int neighborCol = temp.col + directions[i][1];

                    // Check if the neighbor is within the bounds of the grid and is not blocked.
                    if (neighborRow >= 0 && neighborRow < n && neighborCol >= 0 && neighborCol < m && A[neighborRow][neighborCol] == 1) {

                        // Add the neighbor to the queue.
                        line.add(new Edge(neighborRow, neighborCol, temp.time + 1));
                        A[neighborRow][neighborCol] = 2;
                        ans = Math.max(temp.time + 1, ans);
                    }
                }
            }
        }

        // If there are still unvisited points in the grid, return -1.
        for (int[] row : A) {
            for (int element : row) {
                if (element == 1) {
                    return -1;
                }
            }
        }

        // Return the answer.
        return ans;
    }

    // This class represents an edge in the graph.
    public static class Edge {

        // The row and column of the edge.
        int row;
        int col;

        // The time it takes to travel along the edge.
        int time;

        // Constructor for the Edge class.
        Edge(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] B = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(solve(B));
    }
}
