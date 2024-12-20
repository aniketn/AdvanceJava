package scaler.Adv.GraphColoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*Problem Description
        Given a undirected graph having A nodes. A matrix B of size M x 2
        is given which represents the edges such that there is an edge between B[i][0] and B[i][1].

        Find whether the given graph is bipartite or not.

        A graph is bipartite if we can split it's set of nodes into two
        independent subsets A and B such that every edge in the graph has one node in A and another node in B

        Note:
        There are no self-loops in the graph.
        No multiple edges between two pair of vertices.
        The graph may or may not be connected.
        Nodes are Numbered from 0 to A-1.
        Your solution will run on multiple testcases. If you are using global variables make sure to clear them.

        Problem Constraints
        1 <= A <= 100000
        1 <= M <= min(A*(A-1)/2,200000)
        0 <= B[i][0],B[i][1] < A

Input Format
        The first argument given is an integer A.
        The second argument given is the matrix B.

        Output Format
        Return 1 if the given graph is bipartide else return 0.

        Example Input
        Input 1:
        A = 2
        B = [ [0, 1] ]
        Input 2:
        A = 3
        B = [ [0, 1], [0, 2], [1, 2] ]

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        Put 0 and 1 into 2 different subsets.
        Explanation 2:
        It is impossible to break the graph down to make two different subsets for bipartite matching*/
public class CheckBipartiteGraph {
    public static int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = B.length;
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(B[i][0]).add(B[i][1]);
            adj.get(B[i][1]).add(B[i][0]);
        }
        int[] colors = new int[A];
        Arrays.fill(colors, -1);
        for (int i = 0; i < A; i++) {
            if (colors[i] == -1) {
                if (!isBipartite(adj, i, 0, colors)) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int node, int c, int[] colors) {
        colors[node] = c;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int neigh = adj.get(node).get(i);
            if (colors[neigh] == colors[node]) {
                return false;
            } else if (colors[neigh] == -1) {
                boolean check = isBipartite(adj, neigh, 1 - c, colors);
                if (!check) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(0, 1)));*/
        int[][] A = new int[][]{{0, 1}};
        System.out.println(solve(2, A));
    }
}
