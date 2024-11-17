package scaler.Adv.GraphKuskalAndPrimsAlgo;

import java.util.ArrayList;
import java.util.Collections;

public class ConstructionCost {
    static class pair implements Comparable<pair> {
        int first;
        int second;

        public pair(int a, int b) {
            this.first = a;
            this.second = b;
        }

        @Override
        public int compareTo(pair temp) {
            return this.first - temp.first;
        }
    }

    static int maxn = 100009;
    static int[] arr = new int[maxn];
    static int[] sz = new int[maxn];
    static ArrayList<pair> edges;
    static long mod = 1000000007;

    public static int solve(int A, int[][] B) {
        ini();
        for (int i = 0; i < B.length; i++)
            edges.add(new pair(B[i][2], i));
        Collections.sort(edges);
        int ans = 0;
        for (pair p : edges) {
            int ind = p.second;
            int val = p.first;
            int u = B[ind][0];
            int v = B[ind][1];
            if (root(u) == root(v))
                continue;
            else {
                un(u, v);
                ans += (int) val;
                ans %= mod;
            }
        }
        return (int) ans;

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
        int A = 3;
        int[][] B = new int[][]{{1, 2, 14}, {2, 3, 7}, {3, 1, 2}};
        System.out.print(solve(A, B));
    }
}


