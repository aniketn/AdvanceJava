package scaler.Adv.GraphTopologicalOrder;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*Problem Description
        There are a total of A courses you have to take, labeled from 1 to A.
        Some courses may have prerequisites, for example to take course
        2 you have to first take course 1, which is expressed as a pair: [1,2].

        So you are given two integer array B and C of same size where for
        each i (B[i], C[i]) denotes a pair.

        Given the total number of courses and a list of prerequisite pairs,
        is it possible for you to finish all courses?

        Return 1 if it is possible to finish all the courses, or 0 if
        it is not possible to finish all the courses.

        Problem Constraints
        1 <= A <= 6*104
        1 <= length(B) = length(C) <= 105
        1 <= B[i], C[i] <= A

        Input Format
        The first argument of input contains an integer A, representing the number of courses.
        The second argument of input contains an integer array, B.
        The third argument of input contains an integer array, C.

        Output Format
        Return 1 if it is possible to finish all the courses,
        or 0 if it is not possible to finish all the courses.

        Example Input
        Input 1:
        A = 3
        B = [1, 2]
        C = [2, 3]
        Input 2:
        A = 2
        B = [1, 2]
        C = [2, 1]

        Example Output
        Output 1:
        1
        Output 2:
        0*/
public class PossibilityOfFinishing {
    static int maxn = 100009;
    static ArrayList<ArrayList<Integer>> g;
    static int[] visited = new int[maxn];
    static int f = 0;

    public static void graph() {
        g = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            visited[i] = 0;
            g.add(new ArrayList<Integer>());
        }
    }

    public static int solve(int A, int[] B, int[] C) {
        graph();
        for (int i = 0; i < B.length; i++) {
            g.get(B[i]).add(C[i]);
        }
        for (int i = 1; i <= A; i++) {
            if (visited[i] == 0) {
                f = 0;
                check_cycle(i);
                if (f == 1)
                    break;
            }
        }
        f = 1 - f;
        return f;
    }

    public static void check_cycle(int u) {
        visited[u] = 1;
        for (int v : g.get(u)) {
            if (visited[v] == 0)
                check_cycle(v);
            else if (visited[v] == 1)
                f = 1;
        }
        visited[u] = 2;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       /* ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(2, 1)));*/
        int[] B = new int[]{1, 2};
        int[] C = new int[]{2, 3};
        System.out.println(solve(3, B, C));
    }
}
