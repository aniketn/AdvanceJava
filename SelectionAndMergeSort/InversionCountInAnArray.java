package scaler.Adv.SelectionAndMergeSort;

/*Problem Description
        Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the
         total number of inversions of A modulo (109 + 7).

        Problem Constraints
        1 <= length of the array <= 105
        1 <= A[i] <= 109

        Input Format
        The only argument given is the integer array A.

        Output Format
        Return the number of inversions of A modulo (109 + 7).

        Example Input
        Input 1:
        A = [1, 3, 2]
        Input 2:
        A = [3, 4, 1, 2]

        Example Output
        Output 1:        1
        Output 2:        4

        Example Explanation
        Explanation 1:
        The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
        Explanation 2:
        The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
        The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
        The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
        The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]*/
public class InversionCountInAnArray {
    static int mod = 1000000007;

    static int mergingElement(int arr[], int temp[], int start, int mid, int end) {
        int idx1 = start;
        int idx2 = mid;
        int x = start;
        int count_inv = 0;
        while ((idx1 <= mid - 1) && (idx2 <= end)) {
            if (arr[idx1] <= arr[idx2]) {
                temp[x++] = arr[idx1++];
            } else {
                temp[x++] = arr[idx2++];
                count_inv = (count_inv + (mid - idx1)) % mod;
            }
        }
        while (idx1 <= mid - 1) {
            temp[x++] = arr[idx1++];
        }
        while (idx2 <= end) {
            temp[x++] = arr[idx2++];
        }
        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
        return count_inv % mod;
    }

    static int mergeSort(int arr[], int temp[], int start, int end) {
        int count_inv = 0;
        int mid = 0;
        if (end > start) {
            mid = (end + start) / 2;
            count_inv = (count_inv + mergeSort(arr, temp, start, mid)) % mod;
            count_inv = (count_inv + mergeSort(arr, temp, mid + 1, end)) % mod;
            count_inv = (count_inv + mergingElement(arr, temp, start, mid + 1, end)) % mod;
        }
        return count_inv % mod;
    }

    public static int solve(int[] A) {
        int N = A.length;
        return mergeSort(A, new int[N], 0, N - 1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{3, 4, 1, 2};
        System.out.println(solve(A));
    }
}
