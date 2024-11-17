package scaler.Adv.GraphIntroBFSAndDFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PathInDirectedGraph {
    public static int solve(int A, int[][] B) {
        int n = B.length;
        Map<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!adjMap.containsKey(B[i][0]))
                adjMap.put(B[i][0], new ArrayList<Integer>());
            adjMap.get(B[i][0]).add(B[i][1]);
        }
        boolean[] vis = new boolean[A + 1];
        dfs(1, vis, adjMap, A);
        return vis[A] ? 1 : 0;
    }

    static void dfs(int i, boolean[] visited, Map<Integer, ArrayList<Integer>> adjMap, int dest) {
        visited[i] = true;
        if (i == dest || adjMap.get(i) == null) return;
        for (int j = 0; j < adjMap.get(i).size(); j++) {
            int k = adjMap.get(i).get(j);
            if (!visited[k]) {
                dfs(k, visited, adjMap, dest);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] B = new int[][]{{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {1, 3}};
        System.out.println(solve(5, B));
    }
}
