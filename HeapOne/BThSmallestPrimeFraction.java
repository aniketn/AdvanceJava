package scaler.Adv.HeapOne;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*Problem Description
        Given a sorted array of integers A which contains 1 and some number of primes.
        Then, for every p < q in the list, we consider the fraction p / q.

        What is the B-th smallest fraction considered?
        Return your answer as an array of integers, where answer[0] = p and answer[1] = q.

        Problem Constraints
        1 <= length(A) <= 2000
        1 <= A[i] <= 30000
        1 <= B <= length(A)*(length(A) - 1)/2

        Input Format
        The first argument of input contains the integer array, A.
        The second argument of input contains an integer B.

        Output Format
        Return an array of two integers, where answer[0] = p and answer[1] = q.

        Example Input
        Input 1:
        A = [1, 2, 3, 5]
        B = 3
        Input 2:
        A = [1, 7]
        B = 1

        Example Output
        Output 1:
        [2, 5]
        Output 2:
        [1, 7]

        Example Explanation
        Explanation 1:
        The fractions to be considered in sorted order are:
        [1/5, 1/3, 2/5, 1/2, 3/5, 2/3]
        The third fraction is 2/5.
        Explanation 2:
        The fractions to be considered in sorted order are:
        [1/7]
        The first fraction is 1/7.*/
public class BThSmallestPrimeFraction {
    static class Node {
        double fraction;
        int num;
        int denom;

        public Node(Double fraction, int num, int denom) {
            this.fraction = fraction;
            this.num = num;
            this.denom = denom;
        }
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.fraction < b.fraction) {
                return -1;
            }
            if (a.fraction > b.fraction) {
                return 1;
            }
            return 0;
        });
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                double x = (double) A.get(i) / (double) A.get(j);
                pq.add(new Node(x, A.get(i), A.get(j)));
            }
        }
        for (int i = 0; i < B - 1; i++) {
            pq.poll();
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Node temp = pq.poll();
        ans.add(temp.num);
        ans.add(temp.denom);
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(5);
       /* A.add(38);
        A.add(31);
        A.add(-7);
        A.add(-28);
        A.add(-61);*/
        System.out.println(solve(A,3));
    }
}
