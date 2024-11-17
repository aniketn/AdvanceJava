package scaler.Adv.GraphShortestPathAlgo;

import java.util.ArrayList;

/*Problem Description
        Given an integer A, representing number of vertices in a graph.
        Also you are given a matrix of integers B of size N x 3 where N
        represents number of Edges in a Graph and Triplet (B[i][0], B[i][1], B[i][2])
        implies there is an undirected edge between B[i][0] and B[i][1] and weight of that edge is B[i][2].
        Find and return the weight of minimum weighted cycle and if there is no cycle return -1 instead.
        NOTE: Graph may contain self loops but does not have duplicate edges.

        Problem Constraints
        1 <= A <= 1000
        1 <= B[i][0], B[i][1] <= A
        1 <= B[i][2] <= 100000

        Input Format
        The first argument given is the integer A.
        The second argument given is the integer matrix B.

        Output Format
        Return the weight of minimum weighted cycle and if there is no cycle return -1 instead.

        Example Input
        Input 1:
        A = 4
        B = [  [1 ,2 ,2]
        [2 ,3 ,3]
        [3 ,4 ,1]
        [4 ,1 ,4]
        [1 ,3 ,15]  ]
        Input 2:
        A = 3
        B = [  [1 ,2 ,2]
        [2 ,3 ,3]  ]

        Example Output
        Output 1:
        10
        Output 2:
        -1

        Example Explanation
        Explanation 1:
        Given graph forms 3 cycles
        1. 1 ---> 2 ---> 3 ---> 4 ---> 1 weight = 10
        2. 1 ---> 2 ---> 3 ---> 1 weight = 20
        3. 1 ---> 3---> 4 ---> 1 weight = 20
        so answer would be 10.
        Explanation 2:
        Given graph forms 0 cycles so return -1.*/
public class MinimumWeightedCycle {
    int ans = Integer.MAX_VALUE;

    class Pair {
        int node;
        int weight;

        Pair(int n, int w) {
            node = n;
            weight = w;
        }
    }

    public int solve(int A, int[][] B) {
        ArrayList<Pair>[] adjList = new ArrayList[A + 1];
        boolean[] cycle = new boolean[A + 1];
        for (int i = 1; i <= A; i++) adjList[i] = new ArrayList<Pair>();
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0], v = B[i][1], w = B[i][2];
            adjList[u].add(new Pair(v, w));
            adjList[v].add(new Pair(u, w));
        }
        for (int i = 1; i <= A; i++) dfs(i, 0, 0, cycle, adjList);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int start, int prev, int sum, boolean[] cycle, ArrayList<Pair>[] adjList) {
        if (cycle[start]) {
            ans = Math.min(ans, sum);
            return;
        }
        cycle[start] = true;
        for (Pair pair : adjList[start]) {
            if (pair.node != prev) {
                dfs(pair.node, start, sum + pair.weight, cycle, adjList);
            }
        }
        cycle[start] = false;
    }
}
