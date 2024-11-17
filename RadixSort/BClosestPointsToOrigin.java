package scaler.Adv.RadixSort;

import java.util.Arrays;

/*Problem Description
        We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
        Here, the distance between two points on a plane is the Euclidean distance.
        You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
        NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).

        Problem Constraints
        1 <= B <= length of the list A <= 105
        -105 <= A[i][0] <= 105
        -105 <= A[i][1] <= 105

        Input Format
        The argument given is list A and an integer B.

        Output Format
        Return the B closest points to the origin (0, 0) in any order.

        Example Input
        Input 1:
        A = [
        [1, 3],
        [-2, 2]
        ]
        B = 1
        Input 2:
        A = [
        [1, -1],
        [2, -1]
        ]
        B = 1

        Example Output
        Output 1:
        [ [-2, 2] ]
        Output 2:
        [ [1, -1] ]

        Example Explanation
        Explanation 1:
        The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
        So one closest point will be [-2,2].
        Explanation 2:
        The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
        So one closest point will be [1,-1].*/
public class BClosestPointsToOrigin {
    public static int[][] solve(int[][] A, int B) {
        int n = A.length;
        int[] distance = new int[n];
        int[][] ans = new int[B][2];
        for (int i = 0; i < n; i++) {
            int x = A[i][0], y = A[i][1];
            distance[i] = (x * x) + (y * y);
        }

        Arrays.sort(distance);

        // Find the k-th distance
        int distB = distance[B - 1];
        int k = 0;
        // Print all distances which are
        // smaller than k-th distance
        for (int i = 0; i < n; i++) {
            int x = A[i][0], y = A[i][1];
            int dist = (x * x) + (y * y);

            if (dist <= distB) {
                ans[k][0] = x;
                ans[k][1] = y;
                k++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] A = new int[][]{{26, 41}, {40, 47}, {47, 7}, {50, 34}, {18, 28}};
        int[][] ans = solve(A, 5);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.println("" + ans[i][j]);
            }
        }
    }
}
