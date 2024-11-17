package scaler.Adv.BackTrackingOne;

import java.util.ArrayList;
import java.util.Arrays;

/*Problem Description
        Given a matrix of integers A of size N x M . There are 4 types of squares in it:

        1. 1 represents the starting square.  There is exactly one starting square.
        2. 2 represents the ending square.  There is exactly one ending square.
        3. 0 represents empty squares we can walk over.
        4. -1 represents obstacles that we cannot walk over.
        Find and return the number of 4-directional walks from the starting square
        to the ending square, that walk over every non-obstacle square exactly once.

        Note: Rows are numbered from top to bottom and columns are numbered from left to right.

        Problem Constraints
        2 <= N * M <= 20
        -1 <= A[i] <= 2

        Input Format
        The first argument given is the integer matrix A.

        Output Format
        Return the number of 4-directional walks from the starting square to the ending square,
        that walk over every non-obstacle square exactly once.

        Example Input
        Input 1:

        A = [   [1, 0, 0, 0]
        [0, 0, 0, 0]
        [0, 0, 2, -1]   ]
        Input 2:

        A = [   [0, 1]
        [2, 0]    ]


        Example Output
        Output 1:
        2
        Output 2:
        0

        Example Explanation
        Explanation 1:
        We have the following two paths:
        1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
        2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
        Explanation 1:
        Answer is evident here.*/
public class UniquePathsThree {
    static int p = 0;

    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int count = 0, start = 0, end = 0;
        int[][] pointer = new int[A.size()][A.get(0).size()];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if (A.get(i).get(j) == 0)
                    count++;
                if (A.get(i).get(j) == 1) {
                    start = i;
                    end = j;
                }
            }
        }
        check(A, pointer, start, end, 0, count + 1);
        return p;
    }

    static void check(ArrayList<ArrayList<Integer>> A, int[][] pointer, int start, int end, int count, int ans) {
        if (start < 0 || start >= A.size() || end < 0 || end >= A.get(0).size())
            return;

        if (A.get(start).get(end) == 2) {
            if (count == ans)
                p++;
            return;
        }
        if (A.get(start).get(end) == -1)
            return;
        if (pointer[start][end] == 1)
            return;
        pointer[start][end] = 1;

        check(A, pointer, start, end + 1, count + 1, ans);
        check(A, pointer, start - 1, end, count + 1, ans);
        check(A, pointer, start + 1, end, count + 1, ans);
        check(A, pointer, start, end - 1, count + 1, ans);

        pointer[start][end] = 0;
        return;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0)));
        A.add(new ArrayList<Integer>(Arrays.asList(0, 0, 2, -1)));

        System.out.println(solve(A));
    }
}
