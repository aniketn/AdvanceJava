package scaler.Adv.TreeFourLCA;
/*
Problem Description
        Find the lowest common ancestor in an unordered binary tree A,
        given two values, B and C, in the tree.

        Lowest common ancestor: the lowest common ancestor (LCA) of two nodes
        and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest)
         node that has both v and w as descendants.

        Problem Constraints
        1 <= size of tree <= 100000
        1 <= B, C <= 109

        Input Format
        First argument is head of tree A.
        Second argument is integer B.
        Third argument is integer C.

        Output Format
        Return the LCA.

        Example Input
        Input 1:
        1
        /  \
        2    3
        B = 2
        C = 3
        Input 2:
        1
        /  \
        2    3
        / \
        4   5
        B = 4
        C = 5

        Example Output
        Output 1:
        1
        Output 2:
        2
        Example Explanation
        Explanation 1:
        LCA is 1.
        Explanation 2:
        LCA is 2.
*/

import java.util.HashSet;

public class LeastCommonAncestor {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    static HashSet<Integer> set;
    static int ans;

    public static int lca(TreeNode A, int B, int C) {
        TreeNode curr = A;
        while (curr != null) {
            if (B < curr.val && C < curr.val) {
                curr = curr.left;
            } else if (B > curr.val && C > curr.val) {
                curr = curr.right;
            } else {
                return curr.val;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(15);
        TreeNode B = new TreeNode(12);
        TreeNode C = new TreeNode(20);
        TreeNode D = new TreeNode(10);
        TreeNode E = new TreeNode(14);
        TreeNode F = new TreeNode(16);
        TreeNode G = new TreeNode(27);
        TreeNode H = new TreeNode(8);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        System.out.println(lca(A, 8, 14));
    }
}
