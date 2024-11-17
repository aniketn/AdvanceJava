package scaler.Adv.GraphColoring;

import java.util.*;

/*Problem Description
        You are given an undirected unweighted graph consisting of
        A vertices and M edges given in a form of 2D Matrix B of size M x 2
        where (B[i][0], B][i][1]) denotes two nodes connected by an edge.

        You have to write a number on each vertex of the graph.
        Each number should be 1, 2 or 3. The graph becomes Poisonous
        if for each edge the sum of numbers on vertices connected by this edge is odd.

        Calculate the number of possible ways to write numbers 1, 2 or 3 on
        vertices so the graph becomes poisonous. Since this number may be large,
        return it modulo 998244353.

        NOTE:
        Note that you have to write exactly one number on each vertex.
        The graph does not have any self-loops or multiple edges.
        Nodes are labelled from 1 to A.

        Problem Constraints
        1 <= A <= 3*105
        0 <= M <= 3*105
        1 <= B[i][0], B[i][1] <= A
        B[i][0] != B[i][1]

        Input Format
        First argument is an integer A denoting the number of nodes.
        Second argument is an 2D Matrix B of size M x 2 denoting the M edges.

        Output Format
        Return one integer denoting the number of possible ways to write numbers 1, 2 or 3
        on the vertices of given graph so it becomes Poisonous .
        Since answer may be large, print it modulo 998244353.

        Example Input
        Input 1:
        A = 2
        B = [  [1, 2]
        ]
        Input 2:
        A = 4
        B = [  [1, 2]
        [1, 3]
        [1, 4]
        [2, 3]
        [2, 4]
        [3, 4]
        ]

        Example Output
        Output 1:
        4
        Output 2:
        0*/
public class PoisonousGraph {
    static int maxn = 300009;
    static long mod = 998244353;
    static int[] visited = new int[maxn];
    static long[] dp = new long[maxn];
    static ArrayList<ArrayList<Integer>> adj;
    static int a, b;

    public static void graph() {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            visited[i] = -1;
            adj.add(new ArrayList<Integer>());
        }
    }

    public static void pre() {
        dp[0] = 1;
        for (int i = 1; i < maxn; i++) {
            dp[i] = ((long) 2) * dp[i - 1];
            dp[i] %= mod;
        }
    }

    public static int solve(int A, int[][] B) {
        graph();
        pre();
        for (int[] edge : B) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        long ans = 1;
        for (int i = 1; i <= A; i++) {
            if (visited[i] == -1) {
                a = 0;
                b = 0;
                if (bfs(i) == false)
                    return 0;
                long res = ((dp[a] % mod) + (dp[b] % mod)) % mod;
                ans = ((ans % mod) * (res % mod)) % mod;
            }
        }
        return (int) ans;
    }

    public static boolean bfs(int s) {
        visited[s] = 1;
        a++;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        while (q.size() > 0) {
            int temp = q.poll();
            for (int v : adj.get(temp)) {
                if (visited[v] == -1) {
                    visited[v] = 1 - visited[temp];
                    if (visited[v] == 0) b++;
                    else a++;
                    q.offer(v);
                } else if (visited[v] == visited[temp])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       /* ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(2, 1)));*/
        int[][] B = new int[][]{{2, 1}};
        System.out.println(solve(2, B));
    }
}
