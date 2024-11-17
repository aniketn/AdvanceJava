package scaler.Adv.GraphColoring;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Problem Description
        A country consist of N cities connected by N - 1 roads.
         King of that country want to construct maximum number of
          roads such that the new country formed remains bipartite country.

        Bipartite country is a country, whose cities can be partitioned
        into 2 sets in such a way, that for each road (u, v) that belongs
        to the country, u and v belong to different sets. Also,
        there should be no multiple roads between two cities and no self loops.

        Return the maximum number of roads king can construct.
        Since the answer could be large return answer % 109 + 7.

        NOTE: All cities can be visited from any city.

        Problem Constraints
        1 <= A <= 105
        1 <= B[i][0], B[i][1] <= N

        Input Format
        First argument is an integer A denoting the number of cities, N.
        Second argument is a 2D array B of size (N-1) x 2 denoting the initial
        roads i.e. there is a road between cities B[i][0] and B[1][1] .

        Output Format
        Return an integer denoting the maximum number of roads king can construct.

        Example Input
        Input 1:
        A = 3
        B = [
        [1, 2]
        [1, 3]
        ]
        Input 2:
        A = 5
        B = [
        [1, 3]
        [1, 4]
        [3, 2]
        [3, 5]
        ]

        Example Output
        Output 1:
        0
        Output 2:
        2

        Example Explanation
        Explanation 1:
        We can't construct any new roads such that the country remains bipartite.
        Explanation 2:
        We can add two roads between cities (4, 2) and (4, 5).*/
public class ConstructRoads {
    static int[] visited;
    static List<List<Integer>> adjList;
    static int mod = 1000000007;

    public static int solve(int A, int[][] B) {
        visited = new int[A + 1];
        adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < B.length; i++) {
            adjList.get(B[i][0]).add(B[i][1]);
            adjList.get(B[i][1]).add(B[i][0]);
        }
        for (int i = 1; i <= A; i++) {
            if (visited[i] == 0)
                bfs(i);
        }
        long a = 0;
        long b = 0;
        for (int i = 1; i <= A; i++) {
            if (visited[i] == 1)
                a++;
            else
                b++;
        }
        return (int) ((a * b) % mod - B.length) % mod;
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        int color = 1;
        visited[node] = color;
        while (!q.isEmpty()) {
            int temp = q.poll();
            color = visited[temp] == 1 ? 2 : 1;
            for (int neighbor : adjList.get(temp)) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = color;
                    q.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1)));*/
        int[][] A = new int[][]{{1,3},{1,4},{3,2},{3,5}};
        System.out.println(solve(5, A));
    }
}
