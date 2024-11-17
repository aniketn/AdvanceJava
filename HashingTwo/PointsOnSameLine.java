package scaler.Adv.HashingTwo;

import java.util.HashMap;
import java.util.Map;

/*Problem Description
        Given two arrays of integers A and B describing a pair of (A[i], B[i]) coordinates in a 2D plane.
        A[i] describe x coordinates of the ith point in the 2D plane,
        whereas B[i] describes the y-coordinate of the ith point in the 2D plane.

        Find and return the maximum number of points that lie on the same line.

        Problem Constraints
        1 <= (length of the array A = length of array B) <= 1000
        -105 <= A[i], B[i] <= 105

        Input Format
        The first argument is an integer array A.
        The second argument is an integer array B.

        Output Format
        Return the maximum number of points which lie on the same line.

        Example Input
        Input 1:
        A = [-1, 0, 1, 2, 3, 3]
        B = [1, 0, 1, 2, 3, 4]
        Input 2:
        A = [3, 1, 4, 5, 7, -9, -8, 6]
        B = [4, -8, -3, -2, -1, 5, 7, -4]

        Example Output
        Output 1:
        4
        Output 2:
        2

        Example Explanation
        Explanation 1:
        The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}.
        Explanation 2:
        Any 2 points lie on a same line.*/
public class PointsOnSameLine {
    public static int solve(int[] A, int[] B) {
        int n = A.length;
        if (n == 1) return 1;
        int global_count = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int x1 = A[i];
            int y1 = B[i];
            int repeatedFreq = 1;

            Map<String, Integer> map = new HashMap<>();
            int max_freq = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int x2 = A[j];
                int y2 = B[j];
                //edge case for same points
                if (x2 == x1 && y2 == y1) {
                    repeatedFreq++;
                    continue;
                }

                int x = x2 - x1;
                int y = y2 - y1;
                int gcd = gcd(x, y);
                x = x / gcd;
                y = y / gcd;

                //for mapping the keys
                if ((x < 0 && y < 0) || (x > 0 && y < 0)) {
                    x *= -1;
                    y *= -1;
                }

                String key = x + "-" + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                //finding the max_freq of key in map
                max_freq = Math.max(max_freq, map.get(key));
            }
            //adding repeatedFreq if there are same points
            global_count = Math.max(global_count, (max_freq + repeatedFreq));
        }
        return global_count;
    }

    private static int gcd(int big, int small) {
        if (small == 0) return big;
        return gcd(small, big % small);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{-1, 0, 1, 2, 3, 3};
        int[] B = new int[]{1, 0, 1, 2, 3, 4};
        System.out.println(solve(A, B));
    }
}
