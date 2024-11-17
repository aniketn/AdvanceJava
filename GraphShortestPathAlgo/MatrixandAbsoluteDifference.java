package scaler.Adv.GraphShortestPathAlgo;
/*
Problem Description
        Given a matrix C of integers, of dimension A x B.
        For any given K, you are not allowed to travel between cells that have
        an absolute difference greater than K.

        Return the minimum value of K such that it is possible to travel between
        any pair of cells in the grid through a path of adjacent cells.

        NOTE:
        Adjacent cells are those cells that share a side with the current cell.

        Problem Constraints
        1 <= A, B <= 102
        1 <= C[i][j] <= 109

        Input Format
        The first argument given is A.
        The second argument give is B.
        The third argument given is the integer matrix C.

        Output Format
        Return a single integer, the minimum value of K.

        Example Input
        Input 1:
        A = 3
        B = 3
        C = [  [1, 5, 6]
        [10, 7, 2]
        [3, 6, 9]   ]

        Example Output
        Output 1:
        4
        Example Explanation
        Explanation 1:
        It is possible to travel between any pair of cells through a path of adjacent
        cells that do not have an absolute
        difference in value greater than 4. e.g. : A path from (0, 0) to (2, 2) may look like this:
        => (0, 0) -> (0, 1) -> (1, 1) -> (2, 1) -> (2, 2)

*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MatrixandAbsoluteDifference {
    static class Edge {
        int x, y, w;

        Edge(int i, int j, int weight) {
            x = i;
            y = j;
            w = weight;
        }
    }

    public static int solve(int A, int B, int[][] C) {
        int n = A * B;
        int[] par = new int[n];
        ArrayList<Edge> edges = new ArrayList<>();
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                for (int k = 0; k < 2; k++) {
                    int xx = i + dx[k];
                    int yy = j + dy[k];
                    if (xx < A && yy < B)
                        edges.add(new Edge(i * B + j, xx * B + yy, Math.abs(C[xx][yy] - C[i][j])));
                }
            }
        }
        for (int i = 1; i < n; i++) par[i] = i;
        int ans = 0, cnt = 0;
        Collections.sort(edges, (a, b) -> a.w - b.w);
        for (int i = 0; i < edges.size(); i++) {
            int a = getRoot(edges.get(i).x, par);
            int b = getRoot(edges.get(i).y, par);
            if (a != b) {
                par[a] = b;
                cnt++;
                ans = Math.max(ans, edges.get(i).w);
            }
        }
        return ans;
    }

    public static int getRoot(int x, int[] par) {
        if (x == par[x]) return x;
        int ans = getRoot(par[x], par);
        par[x] = ans;
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int A = 3;
        int B = 3;
        int[][] C = new int[][]{{1, 5, 6}, {10, 7, 2}, {3, 6, 9}};
        System.out.println(solve(A, B, C));
    }
}
