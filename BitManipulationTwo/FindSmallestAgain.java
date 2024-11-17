package scaler.Adv.BitManipulationTwo;

import java.util.Arrays;

/*Problem Description
        Given an integer array A of size N.
        If we store the sum of each triplet of the array A in a new list, then find the Bth smallest element
        among the list.

        NOTE: A triplet consists of three elements from the array. Let's say if A[i], A[j], A[k] are the
        elements of the triplet then i < j < k.

        Problem Constraints
        3 <= N <= 500
        1 <= A[i] <= 108
        1 <= B <= (N*(N-1)*(N-2))/6

        Input Format
        The first argument is an integer array A.
        The second argument is an integer B.

        Output Format
        Return an integer denoting the Bth element of the list.

        Example Input
        Input 1:
        A = [2, 4, 3, 2]
        B = 3
        Input 2:
        A = [1, 5, 7, 3, 2]
        B = 9

        Example Output
        Output 1:        9
        Output 2:        14

        Example Explanation
        Explanation 1:
        All the triplets of the array A are:
        (2, 4, 3) = 9
        (2, 4, 2) = 8
        (2, 3, 2) = 7
        (4, 3, 2) = 9
        So the 3rd smallest element is 9.*/

/**
 * Approach
 * Sort the array. Find the maximum and minimum possible answer by suming the last three and first three numbers
 * from the array .
 * Take min and max as start & end .
 * find mid and check how to combinations have count lesser than mid. if the number is less than B keep
 * increasing mid
 * else keep decreasing mid.
 */

public class FindSmallestAgain {
    public static int solve(int[] A, int B) {
        Arrays.sort(A);
        int N = A.length;
        int start = A[0] + A[1] + A[2];
        int end = A[N - 1] + A[N - 2] + A[N - 3];
        int ans = 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = Count(A, mid);

            if (count < B) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ((ans == -1) ? 0 : ans);
    }


    public static int Count(int[] A, int M) {
        int N = A.length;
        int count = 0;
        for (int i = 0; i < N; i++) {

            int p1 = i + 1;
            int p2 = N - 1;

            while (p1 < p2) {
                if (A[i] + A[p1] + A[p2] < M) {
                    count += p2 - p1;
                    p1++;
                } else {
                    p2--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{2, 4, 3, 2};
        System.out.println(solve(A, 3));
    }
}
