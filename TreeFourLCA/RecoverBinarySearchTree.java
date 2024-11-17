package scaler.Adv.TreeFourLCA;

import java.util.ArrayList;

/*Problem Description
        Two elements of a binary search tree (BST), represented by root A are swapped by mistake.
        Tell us the 2 values swapping which the tree will be restored.

        A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
        Note: The 2 values must be returned sorted in ascending order

        Problem Constraints
        1 <= size of tree <= 100000

        Input Format
        First and only argument is the head of the tree,A

        Output Format
        Return the 2 elements which need to be swapped.

        Example Input
        Input 1:
        1
        / \
        2   3
        Input 2:
        2
        / \
        3   1

        Example Output
        Output 1:
        [2, 1]
        Output 2:
        [3, 1]

        Example Explanation
        Explanation 1:
        Swapping 1 and 2 will change the BST to be
        2
        / \
        1   3
        which is a valid BST
        Explanation 2:
        Swapping 1 and 3 will change the BST to be
        2
        / \
        1   3
        which is a valid BST*/
public class RecoverBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode first;   // The first node that violates the BST property
    private static TreeNode middle;  // The middle node that violates the BST property
    private static TreeNode last;    // The last node that violates the BST property
    private static TreeNode prev;    // The previous node during the inorder traversal

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        inorder(root.left);

        // Check if the current node violates the BST property
        if (prev != null && (root.val < prev.val)) {
            // If this is the first time we've found a violation,
            // set first and middle to the nodes that violate the BST property
            if (first == null) {
                first = prev;
                middle = root;
            }
            // If we've already found a violation, set last to the node that violates the BST property
            else {
                last = root;
            }
        }
        // Set prev to the current node, so that we can compare it to the next node
        prev = root;

        // Traverse the right subtree
        inorder(root.right);
    }

    public static void recoverTree(TreeNode root) {
        // Initialize the variables
        first = middle = last = null;
        // Initialize prev to a node with the minimum possible value, so that it will not violate the BST property
        prev = new TreeNode(Integer.MIN_VALUE);

        // Perform an inorder traversal of the tree
        inorder(root);

        // Swap the values of the nodes that violate the BST property, if any
        if (first != null && last != null) {
            // If there are two nodes that violate the BST property,
            // and they are not adjacent to each other, swap the values of the first and last nodes
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            // If there are two nodes that violate the BST property,
            // and they are adjacent to each other, swap the values of the first and middle nodes
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(15);
        TreeNode B = new TreeNode(12);
        TreeNode C = new TreeNode(20);
        TreeNode D = new TreeNode(10);
        TreeNode E = new TreeNode(14);
        TreeNode F = new TreeNode(27);
        TreeNode G = new TreeNode(16);
        TreeNode H = new TreeNode(8);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        recoverTree(A);
    }
}
