package scaler.Adv.TriesTwoBitsProblem;

import java.util.ArrayList;

/*Problem Description
        Given an array of integers A, find and return the maximum result of A[i] XOR A[j],
        where i, j are the indexes of the array.

        Problem Constraints
        1 <= length of the array <= 100000
        0 <= A[i] <= 109

        Input Format
        The only argument given is the integer array A.

        Output Format
        Return an integer denoting the maximum result of A[i] XOR A[j].

        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5]
        Input 2:
        A = [5, 17, 100, 11]

        Example Output
        Output 1:
        7
        Output 2:
        117

        Example Explanation
        Explanation 1:
        Maximum XOR occurs between element of indicies(0-based) 1 and 4 i.e. 2 ^ 5 = 7.
        Explanation 2:
        Maximum XOR occurs between element of indicies(0-based) 1 and 2 i.e. 17 ^ 100 = 117.*/
public class MaximumXOR {
    static class Node {
        Node[] child;

        Node() {
            child = new Node[2];
        }
    }

    public static int solve(ArrayList<Integer> A) {
        int ans = 0;
        Node root = new Node();
        for (int i = 0; i < A.size(); i++) put(root, A.get(i));
        for (int i = 0; i < A.size(); i++) ans = Math.max(ans, maxXor(root, A.get(i)));
        return ans;
    }

    private static void put(Node root, int n) {
        Node current = root;
        for (int i = 31; i >= 0; i--) {
            if ((n & 1 << i) == 0) {
                if (current.child[0] == null) current.child[0] = new Node();
                current = current.child[0];
            } else {
                if (current.child[1] == null) current.child[1] = new Node();
                current = current.child[1];
            }
        }
    }

    private static int maxXor(Node root, int n) {
        int ans = 0;
        Node current = root;
        for (int i = 31; i >= 0; i--) {
            if ((n & 1 << i) == 0) {
                if (current.child[1] != null) {
                    ans = ans | (1 << i);
                    current = current.child[1];
                } else {
                    current = current.child[0];
                }
            } else {
                if (current.child[0] != null) {
                    ans = ans | (1 << i);
                    current = current.child[0];
                } else {
                    current = current.child[1];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(solve(A));
    }
}
