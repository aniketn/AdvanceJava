package scaler.Adv.GraphTopologicalOrder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DijkshtraAlgo {
    static int maxn = 100009;
    static int[] vis = new int[maxn];
    static ArrayList<ArrayList<Pair>> adj;

    public static void graph() {
        adj = new ArrayList<ArrayList<Pair>>(maxn);
        for (int i = 0; i < maxn; i++) {
            vis[i] = 0;
            adj.add(new ArrayList<Pair>());
        }
    }

    public static int[] solve(int A, int[][] B, int C) {
        graph();
        for (int[] edge : B) {
            adj.get(edge[0]).add(new Pair(edge[2], edge[1]));
            adj.get(edge[1]).add(new Pair(edge[2], edge[0]));
        }
        return dijkstra(A, C);
    }

    public static int[] dijkstra(int n, int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new CustomComp());
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;
        pq.offer(new Pair(0, source));

        while (pq.size() != 0) {
            Pair temp = pq.poll();
            int u = temp.b;
            if (vis[u] == 1)
                continue;
            vis[u] = 1;
            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i).b, w = adj.get(u).get(i).a;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Pair(dist[v], v));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }

    public static void main(String[] args) {
        int A = 6;
        int[][] B = new int[][]{{0, 4, 9}, {3, 4, 6}, {1, 2, 1}, {2, 5, 1}, {2, 4, 5}, {0, 3, 7}, {0, 1, 1}, {4, 5, 7}, {0, 5, 1}};
        int C = 4;
        int[] ans = solve(A, B, C);
    }
}

class Pair {
    int a, b;

    public Pair(int u, int v) {
        this.a = u;
        this.b = v;
    }
}

class CustomComp implements Comparator<Pair> {
    @Override
    public int compare(Pair aa, Pair bb) {
        return aa.a - bb.a;
    }
}

