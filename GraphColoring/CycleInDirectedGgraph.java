package scaler.Adv.GraphColoring;

import java.util.ArrayList;

public class CycleInDirectedGgraph {
    public static int solve(int A, int[][] B) {
        int N = B.length;
        ArrayList<Integer>[] mat = new ArrayList[A + 1];
        for (int i = 1; i <= A; i++) //Instantiate adjacency list
        {
            mat[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N; i++) //Populate each list as prescribed
        {
            int u = B[i][0];
            int v = B[i][1];
            mat[u].add(v);
        }

        boolean[] vis = new boolean[A + 1]; //visited array
        boolean[] isDesc = new boolean[A + 1]; //Descendant check

        for (int i = 1; i <= A; i++) {
            if (Check(i, mat, vis, isDesc)) {
                return 1;
            }
        }
        return 0;
    }

    private static boolean Check(int u, ArrayList<Integer>[] mat, boolean[] vis, boolean[] isDesc) {
        if (vis[u]) {
            return false;
        }

        vis[u] = true;
        isDesc[u] = true;
        ArrayList<Integer> nei = mat[u];
        for (int i = 0; i < nei.size(); i++) {
            int curr_nei = nei.get(i);
            if (isDesc[curr_nei]) //cycle is present if neighbor is a descendant.
            {
                return true;
            }

            boolean b = Check(curr_nei, mat, vis, isDesc); //cycle detection for neighbor

            if (b == true) //if neighbor has a cycle the graph is cyclic.
                return true;
        }
        isDesc[u] = false; //unmark this as non-desc before returning.
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] B = new int[][]{{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {1, 3}};
        System.out.println(solve(5, B));
    }
}
