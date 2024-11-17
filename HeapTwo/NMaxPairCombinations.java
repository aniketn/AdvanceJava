package scaler.Adv.HeapTwo;

import java.util.*;

/*Problem Description
        Given two integers arrays, A and B, of size N each.
        Find the maximum N elements from the sum combinations (Ai + Bj)
        formed from elements in arrays A and B.

        Problem Constraints
        1 <= N <= 2 * 105
        -1000 <= A[i], B[i] <= 1000

        Input Format
        The first argument is an integer array A.
        The second argument is an integer array B.

        Output Format
        Return an integer array denoting the N maximum element in descending order.

        Example Input
        Input 1:
        A = [1, 4, 2, 3]
        B = [2, 5, 1, 6]
        Input 2:
        A = [2, 4, 1, 1]
        B = [-2, -3, 2, 4]

        Example Output
        Output 1:
        [10, 9, 9, 8]
        Output 2:
        [8, 6, 6, 5]

        Example Explanation
        Explanation 1:
        4 maximum elements are 10(6+4), 9(6+3), 9(5+4), 8(6+2).
        Explanation 2:
        4 maximum elements are 8(4+4), 6(4+2), 6(4+2), 5(4+1).*/
public class NMaxPairCombinations {
    public static int[] solve(int[] A, int[] B) {
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        Set<String> set = new HashSet<>();

        //priority in reverse order
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(A[b[0]] + B[b[1]], A[a[0]] + B[a[1]]));

        maxHeap.add(new int[]{n - 1, n - 1});
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            int[] temp = maxHeap.peek();
            ans[i] = A[temp[0]] + B[temp[1]];
            maxHeap.poll();
            //now this temp indexes can generate 2 possible answers
            //l-1,r & l,r-1;
            int[] first = new int[]{temp[0] - 1, temp[1]};
            int[] second = new int[]{temp[0], temp[1] - 1};

            //using set to avoid duplicacy
            if (set.add(first[0] + " " + first[1]) && first[0] >= 0)
                maxHeap.add(first);
            if (set.add(second[0] + " " + second[1]) && second[1] >= 0)
                maxHeap.add(second);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] A=new int[] {1, 4, 2, 3};
        int[] B=new int[] {2, 5, 1, 6};
        System.out.println(solve(A,B));
    }

}
