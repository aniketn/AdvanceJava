package scaler.Adv.TreeOne;

import java.util.ArrayList;

/*Problem Description
        Given preorder and inorder traversal of a tree, construct the binary tree.
        NOTE: You may assume that duplicates do not exist in the tree.

        Problem Constraints
        1 <= number of nodes <= 105

        Input Format
        First argument is an integer array A denoting the preorder traversal of the tree.
        Second argument is an integer array B denoting the inorder traversal of the tree.

        Output Format
        Return the root node of the binary tree.

        Example Input
        Input 1:
        A = [1, 2, 3]
        B = [2, 1, 3]
        Input 2:
        A = [1, 6, 2, 3]
        B = [6, 1, 3, 2]

        Example Output
        Output 1:
        1
        / \
        2   3
        Output 2:
        1
        / \
        6   2
        /
        3

        Example Explanation
        Explanation 1:
        Create the binary tree and return the root node of the tree.*/
public class BinaryTreeFromInorderAndPreorder {
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

    public static TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        TreeNode root;
        int n = preorder.size(), m = inorder.size();
        if (n == 0 || m == 0) {
            return null;
        }
        root = new TreeNode(preorder.get(0));
        // Find mid from inorder array
        int mid = inorder.indexOf(preorder.get(0));
        //preorder becomes (1, mid+1) and inorder becomes left subArray of mid for left of root
        root.left = buildTree(new ArrayList<Integer>(preorder.subList(1, mid + 1)), new ArrayList<Integer>(inorder.subList(0, mid + 1)));
        //preorder becomes (mid+1,n) and inorder becomes right subArray of mid for right of root
        root.right = buildTree(new ArrayList<Integer>(preorder.subList(mid + 1, n)), new ArrayList<Integer>(inorder.subList(mid + 1, m)));
        return root;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> A = new ArrayList<>();
        A.add(4);
        A.add(6);
        A.add(8);
        A.add(9);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(6);
        B.add(4);
        B.add(9);
        B.add(8);
        BinaryTreeFromInorderAndPreorder.TreeNode ans = buildTree(A, B);
    }
}
