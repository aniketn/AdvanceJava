package scaler.Adv.GraphIntroBFSAndDFS;
/*
Problem Description
        You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
        Given 2 towns find whether you can reach the first town from the second without repeating any edge.
        B C : query to find whether B is reachable from C.
        Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
        There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also,
        it's guaranteed that A[i] <= i for every 1 <= i < N.
        NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.


        Problem Constraints
        1 <= N <= 100000

        Input Format
        First argument is vector A
        Second argument is integer B
        Third argument is integer C

        Output Format
        Return 1 if reachable, 0 otherwise.

        Example Input
        Input 1:
        A = [1, 1, 2]
        B = 1
        C = 2
        Input 2:
        A = [1, 1, 2]
        B = 2
        C = 1

        Example Output
        Output 1:
        0
        Output 2:
        1

        Example Explanation
        Explanation 1:
        Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
        Explanation 2:
        Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
*/

import java.util.ArrayList;

public class FirstDFS {
    public static int solve(int[] A, final int B, final int C) {
        int n = A.length;
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            if (adjList[A[i]] == null)
                adjList[A[i]] = new ArrayList<Integer>();
            adjList[A[i]].add(i + 1);
        }
        boolean[] vis = new boolean[n + 1];
        dfs(C, vis, adjList, B);
        return vis[B] ? 1 : 0;
    }

    public static void dfs(int i, boolean[] vis, ArrayList<Integer>[] adjList, int end) {
        vis[i] = true;
        if (i == end || adjList[i] == null) return;
        for (int j = 0; j < adjList[i].size(); j++) {
            int k = adjList[i].get(j);
            if (!vis[k])
                dfs(k, vis, adjList, end);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{1, 1, 2};
        System.out.println(solve(A, 2, 1));
    }
}
