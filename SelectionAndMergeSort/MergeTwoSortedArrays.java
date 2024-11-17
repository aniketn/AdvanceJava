package scaler.Adv.SelectionAndMergeSort;

/*Problem Description
        Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.

        Problem Constraints
        -1010 <= A[i], B[i] <= 1010

        Input Format
        First Argument is a 1-D array representing A.
        Second Argument is also a 1-D array representing B.

        Output Format
        Return a 1-D vector which you got after merging A and B.

        Example Input
        Input 1:
        A = [4, 7, 9 ]
        B = [2, 11, 19 ]
        Input 2:
        A = [1]
        B = [2]

        Example Output
        Output 1:
        [2, 4, 7, 9, 11, 19]
        Output 2:
        [1, 2]

        Example Explanation
        Explanation 1:
        Merging A and B produces the output as described above.
        Explanation 2:
        Merging A and B produces the output as described above.*/
public class MergeTwoSortedArrays {
    public static int[] solve(final int[] A, final int[] B) {
        int N = A.length;
        int M = B.length;
        int[] C = new int[N + M];
        int p1 = 0, p2 = 0, p3 = 0;
        while (p1 < N && p2 < M) {
            if (A[p1] < B[p2]) {
                C[p3++] = A[p1++];
            } else {
                C[p3++] = B[p2++];
            }
        }
        while (p1 < N) {
            C[p3++] = A[p1++];
        }
        while (p2 < M) {
            C[p3++] = B[p2++];
        }
        return C;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final int[] A = new int[]{4, 7, 9};
        final int[] B = new int[]{2, 11, 19};
        int[] ans = solve(A, B);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i] + "");
        }
    }
}

