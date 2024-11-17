package scaler.Adv.TwoPointers;

/*Problem Description
        Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).
        N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
        Find two lines, which together with x-axis forms a container, such that the container contains the most water.
        Note: You may not slant the container.

        Problem Constraints
        0 <= N <= 105
        1 <= A[i] <= 105

        Input Format
        Single Argument representing a 1-D array A.

        Output Format
        Return single Integer denoting the maximum area you can obtain.

        Example Input
        Input 1:
        A = [1, 5, 4, 3]
        Input 2:
        A = [1]

        Example Output
        Output 1:
        6
        Output 2:
        0

        Example Explanation
        Explanation 1:
        5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
        So total area = 3 * 2 = 6
        Explanation 2:
        No container is formed.*/
public class ContainerWithMostWater {
    public static int maxArea(int[] A) {
        int len = A.length;
        int p1 = 0;
        int p2 = len - 1;
        int ans = 0;
// edge case condition if array contains only 1 element
        if (len == 1) {
            return 0;
        }
        while (p1 < p2) {
            // The maximum height of the container would be minimum of height at 2 pointers
            int height = Math.min(A[p1], A[p2]);
            int width = p2 - p1;
            int capacity = height * width;
            if (capacity > ans) {
                ans = capacity; // updating answer whenever getting better capcity
            }
// As there will not be better capcity with given set of minimum height, we need to move that pointer
            if (height == A[p1]) {
                p1++;
            } else if (height == A[p2]) {
                p2--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{1, 5, 4, 3};
        System.out.println(maxArea(A));
    }
}
