package scaler.Adv.TriesTwoBitsProblem;

import scaler.Adv.TreeOne.BinaryTreeFromInorderAndPostorder;
import scaler.Adv.TreeOne.InorderTraversal;

import java.util.ArrayList;

/*Problem Description
        Given a binary tree A, flatten it to a linked list in-place.
        The left child of all nodes should be NULL.

        Problem Constraints
        1 <= size of tree <= 100000

        Input Format
        First and only argument is the head of tree A.

        Output Format
        Return the linked-list after flattening.

        Example Input
        Input 1:
        1
        / \
        2   3
        Input 2:
        1
        / \
        2   5
        / \   \
        3   4   6

        Example Output
        Output 1:
        1
        \
        2
        \
        3
        Output 2:
        1
        \
        2
        \
        3
        \
        4
        \
        5
        \
        6

        Example Explanation
        Explanation 1:
        Tree flattening looks like this.
        Explanation 2:
        Tree flattening looks like this.*/
public class FlattenBinaryTreeToLinkedList {
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

    public static TreeNode flatten(TreeNode a) {
        TreeNode current = a, prev = null;
        while (current != null) {
            if (current.left != null) {
                prev = current.left;
                while (prev.right != null) prev = prev.right;
                prev.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
        return a;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(4);
        TreeNode B = new TreeNode(5);
        TreeNode C = new TreeNode(2);
        TreeNode D = new TreeNode(3);
        TreeNode E = new TreeNode(6);

        A.right = C;
        C.left = D;
        C.right = E;
        TreeNode ans = flatten(A);
    }
}
