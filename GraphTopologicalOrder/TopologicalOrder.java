package scaler.Adv.GraphTopologicalOrder;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class TopologicalOrder {
    static int maxn = 10009;
    static int[] in = new int[maxn];
    static ArrayList<ArrayList<Integer>> adj;

    public static void graph() {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            in[i] = 0;
            adj.add(new ArrayList<Integer>());
        }
    }

    public static int[] solve(int A, int[][] B) {
        graph();
        for (int[] edge : B) {
            adj.get(edge[0]).add(edge[1]);
            in[edge[1]]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= A; i++) {
            if (in[i] == 0)
                pq.offer(i);
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (pq.size() > 0) {
            int temp = pq.poll();
            ans.add(temp);
            for (int v : adj.get(temp)) {
                in[v]--;
                if (in[v] == 0)
                    pq.offer(v);
            }
        }
        if (ans.size() != A)
            ans.clear();
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       /* ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(2, 1)));*/
        int[][] B = new int[][]{{6, 3}, {6, 1}, {5, 1}, {5, 2}, {3, 4}, {4, 2}};
        System.out.println(solve(6, B));
    }
}
