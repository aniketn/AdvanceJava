package scaler.Adv.HeapOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/*Problem Description
        Given an array of integers A and an integer B. You must modify the array
        exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].

        You need to perform these modifications in such a way that after exactly B modifications,
         sum of the array must be maximum.

        Problem Constraints
        1 <= length of the array <= 5*105
        1 <= B <= 5 * 106
        -100 <= A[i] <= 100

        Input Format
        The first argument given is an integer array A.
        The second argument given is an integer B.

        Output Format
        Return an integer denoting the maximum array sum after B modifications.

        Example Input
        Input 1:
        A = [24, -68, -29, -9, 84]
        B = 4
        Input 2:
        A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
        B = 10

        Example Output
        Output 1:
        196
        Output 2:
        362

        Example Explanation
        Explanation 1:
        Final array after B modifications = [24, 68, 29, -9, 84]
        Explanation 2:
        Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]*/
public class MaximumArraySumAfterBNegations {
    public static int solve(ArrayList<Integer> A, int B) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++)
            pq.add(A.get(i));
        for (int i = 1; i <= B; i++)
            pq.add(-pq.poll());
        while (!pq.isEmpty())
            ans += pq.poll();
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(57);
        //A.add(3);
        A.add(-14);
        //A.add(-87);
        //A.add(42);
        //A.add(38);
        A.add(-31);
        A.add(-7);
        A.add(-28);
        //A.add(-61);
        System.out.println(solve(A, 10));
    }
}
