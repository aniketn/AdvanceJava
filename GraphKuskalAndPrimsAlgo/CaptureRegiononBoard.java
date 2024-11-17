package scaler.Adv.GraphKuskalAndPrimsAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CaptureRegiononBoard {
    static class Pair {
        int x, y;

        Pair(int i, int j) {
            x = i;
            y = j;
        }
    }

    static int[] x = {-1, 1, 0, 0};
    static int[] y = {0, 0, 1, -1};

    public static void solve(ArrayList<ArrayList<Character>> a) {
        int n = a.size(), m = a.get(0).size();
        if (m == 1 && n == 1) return;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < m - 1; i++)
            if (a.get(0).get(i) == 'O')
                queue.add(new Pair(0, i));
        for (int i = 0; i < n - 1; i++)
            if (a.get(i).get(m - 1) == 'O')
                queue.add(new Pair(i, m - 1));
        for (int i = m - 1; i > 0; i--)
            if (a.get(n - 1).get(i) == 'O')
                queue.add(new Pair(n - 1, i));
        for (int i = n - 1; i > 0; i--)
            if (a.get(i).get(0) == 'O')
                queue.add(new Pair(i, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            vis[pair.x][pair.y] = true;
            for (int i = 0; i < 4; i++) {
                int xx = pair.x + x[i];
                int yy = pair.y + y[i];
                if (xx >= 0 && xx < n && yy >= 0 && yy < m && !vis[xx][yy] && a.get(xx).get(yy) == 'O') {
                    queue.add(new Pair(xx, yy));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a.get(i).get(j) == 'O' && !vis[i][j]) a.get(i).set(j, 'X');
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList('X', 'X', 'X', 'X')));
        A.add(new ArrayList<>(Arrays.asList('X', 'O', 'O', 'X')));
        A.add(new ArrayList<>(Arrays.asList('X', 'X', 'O', 'X')));
        A.add(new ArrayList<>(Arrays.asList('X', 'O', 'X', 'X')));
        solve(A);
    }
}
