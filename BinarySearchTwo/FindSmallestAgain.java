package scaler.Adv.BinarySearchTwo;
/*Problem Description
        Given an integer array A of size N.

        If we store the sum of each triplet of the array A in a new list,
        then find the Bth smallest element among the list.

        NOTE: A triplet consists of three elements from the array.
        Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.

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
        Output 1:
        9
        Output 2:
        14
        Example Explanation
        Explanation 1:
        All the triplets of the array A are:
        (2, 4, 3) = 9
        (2, 4, 2) = 8
        (2, 3, 2) = 7
        (4, 3, 2) = 9
        So the 3rd smallest element is 9.*/
import java.util.Arrays;

public class FindSmallestAgain {
    public static int check(int[] A, int val) {
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            int s = i + 1, e = A.length - 1;
            while (s < e) {
                if (A[i] + A[s] + A[e] < val) {
                    cnt += e - s;
                    s++;
                } else {
                    e--;
                }
            }
        }
        return cnt;
    }

    public static int solve(int[] A, int B) {
        Arrays.sort(A);
        int n = A.length;
        int low = 0, high = A[n - 1] + A[n - 2] + A[n - 3], ans = 0;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            // count of triplets with sum less than mid
            int count = check(A, mid);
            if (count >= B) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{2, 4, 3, 2};
        int B = 3;
        System.out.print(solve(A, B));
    }
}
