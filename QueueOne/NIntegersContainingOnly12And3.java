package scaler.Adv.QueueOne;

import java.util.ArrayDeque;
import java.util.Queue;

/*Problem Description
        Given an integer, A. Find and Return first positive A integers in ascending order
        containing only digits 1, 2, and 3.

        NOTE: All the A integers will fit in 32-bit integers.

        Problem Constraints
        1 <= A <= 29500

        Input Format
        The only argument given is integer A.

        Output Format
        Return an integer array denoting the first positive A integers in ascending order
        containing only digits 1, 2 and 3.

        Example Input
        Input 1:
        A = 3
        Input 2:
        A = 7

        Example Output
        Output 1:
        [1, 2, 3]
        Output 2:
        [1, 2, 3, 11, 12, 13, 21]

        Example Explanation
        Explanation 1:
        Output denotes the first 3 integers that contains only digits 1, 2 and 3.
        Explanation 2:
        Output denotes the first 3 integers that contains only digits 1, 2 and 3.*/
public class NIntegersContainingOnly12And3 {
    public static int[] solve(int A) {
        int[] ans = new int[A];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        int a = 10;

        for (int i = 0; i < A; i++) {
            int ele = q.remove();
            ans[i] = ele;
            q.add(ele * a + 1);
            q.add(ele * a + 2);
            q.add(ele * a + 3);
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] ans = solve(7);
        for (int i = 0; i < ans.length; i++) {
            System.out.println("" + ans[i]);
        }
    }
}
