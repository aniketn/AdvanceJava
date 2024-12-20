package scaler.Adv.BinarySearchOne;

/*Problem Description
        Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller
         than its neighbors.

        For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
        NOTE: Users are expected to solve this in O(log(N)) time. The array may have duplicate elements.

        Problem Constraints
        1 <= |A| <= 100000
        1 <= A[i] <= 109

        Input Format
        The only argument given is the integer array A.

        Output Format
        Return the peak element.

        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5]
        Input 2:
        A = [5, 17, 100, 11]

        Example Output
        Output 1:
        5
        Output 2:
        100

        Example Explanation
        Explanation 1:
        5 is the peak.
        Explanation 2:
        100 is the peak.*/
public class FindAPeakElement {
    public static int solve(int[] A) {
        int n = A.length;
        if (n == 1) {
            return A[0];
        }
        if (A[0] >= A[1]) {
            return A[0];
        }
        if (A[n - 1] >= A[n - 2]) {
            return A[n - 1];
        }
        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if ((A[mid] > A[mid - 1]) && (A[mid] > A[mid + 1])) {
                return A[mid];
            } else if (A[mid - 1] >= A[mid] && A[mid] > A[mid + 1])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(A));
    }
}
