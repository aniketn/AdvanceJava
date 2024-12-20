package scaler.Adv.GraphColoring;

import java.util.LinkedList;
import java.util.Queue;

/*Problem Description
        Given a matrix of integers A of size N x M consisting of 0 or 1.
        For each cell of the matrix find the distance of nearest 1 in the matrix.
        Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.
        Find and return a matrix B of size N x M which defines for each cell in
        A distance of nearest 1 in the matrix A.
        NOTE: There is atleast one 1 is present in the matrix.

        Problem Constraints
        1 <= N, M <= 1000
        0 <= A[i][j] <= 1

        Input Format
        The first argument given is the integer matrix A.

        Output Format
        Return the matrix B.

        Example Input
        Input 1:
        A = [
        [0, 0, 0, 1]
        [0, 0, 1, 1]
        [0, 1, 1, 0]
        ]
        Input 2:
        A = [
        [1, 0, 0]
        [0, 0, 0]
        [0, 0, 0]
        ]

        Example Output
        Output 1:
        [
        [3, 2, 1, 0]
        [2, 1, 0, 0]
        [1, 0, 0, 1]
        ]
        Output 2:
        [
        [0, 1, 2]
        [1, 2, 3]
        [2, 3, 4]
        ]

        Example Explanation
        Explanation 1:
        A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
        A[1][0], A[1][1] will be nearest to A[1][2].
        A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].
        Explanation 2:
        There is only a single 1. Fill the distance from that 1.*/
public class DistanceOfNearestCell {
    static class Pair {
        int x, y;

        Pair(int i, int j) {
            x = i;
            y = j;
        }
    }

    static int[] arr1 = {-1, 1, 0, 0};
    static int[] arr2 = {0, 0, -1, 1};

    public static int[][] solve(int[][] A) {
        int n = A.length, m = A[0].length;
        int[][] dis = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) queue.add(new Pair(i, j));
            }
        }
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int xx = pair.x + arr1[i];
                int yy = pair.y + arr2[i];
                if (xx >= 0 && xx < n && yy >= 0 && yy < m && A[xx][yy] == 0) {
                    queue.add(new Pair(xx, yy));
                    A[xx][yy] = 2;
                    dis[xx][yy] = 1 + dis[pair.x][pair.y];
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] B = new int[][]{{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 0}};
        System.out.println(solve(B));
    }
}
