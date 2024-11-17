package scaler.Adv.TreeFiveProblemsOnTrees;

import scaler.Adv.TreeFourLCA.DistanceBetweenNodesOfBST;
import scaler.Adv.TreeFourLCA.LeastCommonAncestor;

/*Problem Description
        Given a binary tree A, invert the binary tree and return it.
        Inverting refers to making the left child the right child and vice versa.

        Problem Constraints
        1 <= size of tree <= 100000

        Input Format
        First and only argument is the head of the tree A.

        Output Format
        Return the head of the inverted tree.

        Example Input
        Input 1:
        1
        /   \
        2     3
        Input 2:
        1
        /   \
        2     3
        / \   / \
        4   5 6   7


        Example Output
        Output 1:
        1
        /   \
        3     2
        Output 2:
        1
        /   \
        3     2
        / \   / \
        7   6 5   4


        Example Explanation
        Explanation 1:
        Tree has been inverted.
        Explanation 2:
        Tree has been inverted.*/
public class InvertTheBinaryTree {
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

    public static TreeNode invertTree(TreeNode A) {
        if (A == null) return null;
        TreeNode left = invertTree(A.left);
        TreeNode right = invertTree(A.right);
        A.right = left;
        A.left = right;
        return A;
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
        TreeNode ans = invertTree(A);
    }
}
