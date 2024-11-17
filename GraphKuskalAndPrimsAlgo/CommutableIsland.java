package scaler.Adv.GraphKuskalAndPrimsAlgo;

import java.util.ArrayList;
import java.util.Collections;

public class CommutableIsland {
    static class pair implements Comparable<pair> {
        int a, b, c;

        pair(int e, int f, int g) {
            this.a = e;
            this.b = f;
            this.c = g;
        }

        @Override
        public int compareTo(pair aa) {
            return this.a - aa.a;
        }
    }

    static int maxn = 60009;
    static int[] arr = new int[maxn];
    static int[] sz = new int[maxn];
    static ArrayList<pair> edges;

    public static int solve(int A, int[][] B) {
        ini();
        for (int[] row : B) {
            edges.add(new pair(row[2], row[0], row[1]));
        }
        Collections.sort(edges);
        return kruskal();
    }

    public static int kruskal() {
        int cost = 0;
        for (int i = 0; i < edges.size(); i++) {
            if (root(edges.get(i).b) == root(edges.get(i).c))
                continue;
            cost += edges.get(i).a;
            un(edges.get(i).b, edges.get(i).c);
        }
        return cost;
    }

    public static void ini() {
        edges = new ArrayList<pair>();
        for (int i = 0; i < maxn; i++) {
            arr[i] = i;
            sz[i] = 1;
        }
    }

    public static int root(int a) {
        while (arr[a] != a) {
            arr[a] = arr[arr[a]];
            a = arr[a];
        }
        return a;
    }

    public static void un(int a, int b) {
        int ra = root(a);
        int rb = root(b);
        if (sz[ra] <= sz[rb]) {
            arr[ra] = rb;
            sz[rb] += sz[ra];
        } else {
            arr[rb] = ra;
            sz[ra] += sz[rb];
        }
    }

    public static void main(String[] args) {
        int A = 4;
        int[][] B = new int[][]{{1, 2, 1}, {2, 3, 4}, {1, 4, 3}, {4, 3, 2}, {1, 3, 10}};
        System.out.print(solve(A, B));
    }
}



