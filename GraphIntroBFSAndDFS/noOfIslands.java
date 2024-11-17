package scaler.Adv.GraphIntroBFSAndDFS;

public class noOfIslands {
    static int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int solve(int[][] A) {
        int n = A.length, m = A[0].length;
        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1 && !vis[i][j]) {
                    ans++;
                    dfs(i, j, vis, A);
                }
            }
        }
        return ans;
    }

    public static void dfs(int i, int j, boolean[][] vis, int[][] graph) {
        vis[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int xx = i + x[k];
            int yy = j + y[k];
            if (xx >= 0 && xx < graph.length && yy >= 0 && yy < graph[0].length && graph[xx][yy] == 1 && !vis[xx][yy]) {
                dfs(xx, yy, vis, graph);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] A = new int[][]{{1, 1, 0, 0, 0}, {0, 1, 0, 0, 0}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}};
        System.out.println(solve(A));
    }
}
