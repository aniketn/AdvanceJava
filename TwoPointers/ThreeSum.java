package scaler.Adv.TwoPointers;

import java.util.Arrays;

/*Problem Description
        Given an array A of N integers, find three integers in A such that the sum is closest to a given number B.
        Return the sum of those three integers.
        Assume that there will only be one solution.

        Problem Constraints
        -108 <= B <= 108
        1 <= N <= 104
        -108 <= A[i] <= 108

        Input Format
        First argument is an integer array A of size N.
        Second argument is an integer B denoting the sum you need to get close to.

        Output Format
        Return a single integer denoting the sum of three integers which is closest to B.

        Example Input
        Input 1:
        A = [-1, 2, 1, -4]
        B = 1
        Input 2:
        A = [1, 2, 3]
        B = 6

        Example Output
        Output 1:
        2
        Output 2:
        6*/
public class ThreeSum {
    public static int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        long closestSum = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int p1 = i + 1;
            int p2 = A.length - 1;
            while (p1 < p2) {
                int sum = A[i] + A[p1] + A[p2];
                if (Math.abs(B - sum) < Math.abs(B - closestSum)) {
                    closestSum = sum;
                }
                if (sum > B) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }
        return (int) closestSum;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(A, 1));
    }
}
