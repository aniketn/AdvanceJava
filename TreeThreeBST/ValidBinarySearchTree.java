package scaler.Adv.TreeThreeBST;

import scaler.Adv.TreeTwo.BoundaryTraversalOfBinaryTree;

import java.util.ArrayList;

/*Problem Description
        You are given a binary tree represented by root A.
        Assume a BST is defined as follows:
        1) The left subtree of a node contains only nodes with keys less than the node's key.
        2) The right subtree of a node contains only nodes with keys greater than the node's key.
        3) Both the left and right subtrees must also be binary search trees.

        Problem Constraints
        1 <= Number of nodes in binary tree <= 105
        0 <= node values <= 232-1

        Input Format
        First and only argument is head of the binary tree A.

        Output Format
        Return 0 if false and 1 if true.

        Example Input
        Input 1:
        1
        /  \
        2    3
        Input 2:
        2
        / \
        1   3

        Example Output
        Output 1:
        0
        Output 2:
        1

        Example Explanation
        Explanation 1:
        2 is not less than 1 but is in left subtree of 1.
        Explanation 2:
        Satisfies all conditions.*/
public class ValidBinarySearchTree {
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

    public static int isValidBST(TreeNode A) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(A, arr);
        int l = arr.size();
        int i;

        for (i = 0; i < l - 1; i++) {
            if (arr.get(i) >= arr.get(i + 1)) {
                return 0;
            }
        }
        return 1;
    }

    public static void inorder(TreeNode A, ArrayList<Integer> arr) {
        if (A == null) {
            return;
        }
        inorder(A.left, arr);
        arr.add(A.val);
        inorder(A.right, arr);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(8);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        System.out.println(isValidBST(A));
    }
}
