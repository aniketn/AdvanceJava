package scaler.Adv.TwoPointers;

/*Problem Description
        Given a binary array A, find the maximum sequence of continuous 1's that can be formed by replacing at-most B
        zeroes.
        For this problem, return the indices of maximum continuous series of 1s in order.
        If there are multiple possible solutions, return the sequence which has the minimum start index.

        Problem Constraints
        0 <= B <= 105
        1 <= size(A) <= 105
        0 <= A[i] <= 1

        Input Format
        First argument is an binary array A.
        Second argument is an integer B.

        Output Format
        Return an array of integers denoting the indices(0-based) of 1's in the maximum continuous series.

        Example Input
        Input 1:
        A = [1 1 0 1 1 0 0 1 1 1 ]
        B = 1
        Input 2:
        A = [1, 0, 0, 0, 1, 0, 1]
        B = 2

        Example Output
        Output 1:
        [0, 1, 2, 3, 4]
        Output 2:
        [3, 4, 5, 6]

        Example Explanation
        Explanation 1:
        Flipping 0 present at index 2 gives us the longest continous series of 1's i.e subarray [0:4].
        Explanation 2:
        Flipping 0 present at index 3 and index 5 gives us the longest continous series of 1's i.e subarray [3:6].*/
public class MaxContinuousSeriesOfOnes {
    public static int[] maxone(int[] A, int B) {
        int start = 0, best_start = 0, end, len = A.length, best_len = 0;
        int zeroes_count = 0;
        for (end = 0; end < len; end++) {
            if (A[end] == 0) {
                zeroes_count++;
            }

            while (zeroes_count > B) {
                if (A[start] == 0) {
                    zeroes_count--;
                }
                start++;
            }

            int current_len = end - start + 1;

            if (current_len > best_len) {
                best_len = current_len;
                best_start = start;
            }
        }

        int[] res = new int[best_len];
        for (int i = 0; i < best_len; i++) {
            res[i] = best_start++;
        }

        return res;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 1};
        int[] ans = maxone(A, 1);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("" + ans[i]);
        }
    }
}
