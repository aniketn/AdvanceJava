package scaler.Adv.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*Problem Description
        There are N jobs to be done, but you can do only one job at a time.
        Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
        Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
        Return the maximum number of jobs you can finish.

        Problem Constraints
        1 <= N <= 105
        1 <= A[i] < B[i] <= 109

        Input Format
        The first argument is an integer array A of size N, denoting the start time of the jobs.
        The second argument is an integer array B of size N, denoting the finish time of the jobs.

        Output Format
        Return an integer denoting the maximum number of jobs you can finish.

        Example Input
        Input 1:
        A = [1, 5, 7, 1]
        B = [7, 8, 8, 8]
        Input 2:
        A = [3, 2, 6]
        B = [9, 8, 9]

        Example Output
        Output 1:
        2
        Output 2:
        1

        Example Explanation
        Explanation 1:
        We can finish the job in the period of time: (1, 7) and (7, 8).
        Explanation 2:
        Since all three jobs collide with each other. We can do only 1 job.*/
public class FinishMaximumJobs {
    static class pair {
        int S, E;

        pair(int s, int e) {
            S = s;
            E = e;
        }
    }

    public static int solve(int[] A, int[] B) {
        int n = A.length;
        pair a[] = new pair[n];
        for (int i = 0; i < n; i++) {
            a[i] = new pair(A[i], B[i]);
            assert (A[i] != B[i]);
        }
        Arrays.sort(a, (pair u, pair v) -> (u.E - v.E));
        int end = 0, ans = 0;
        for (pair job : a) {
            if (job.S >= end) {
                ans++;
                end = job.E;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 7, 1};
        int[] B = new int[]{7, 8, 8, 8};
        System.out.println(solve(A, B));
    }
}
