package scaler.Adv.TreeOne;

import java.util.ArrayList;

/*Problem Description
        Given the inorder and postorder traversal of a tree, construct the binary tree.
        NOTE: You may assume that duplicates do not exist in the tree.

        Problem Constraints
        1 <= number of nodes <= 105

        Input Format
        First argument is an integer array A denoting the inorder traversal of the tree.
        Second argument is an integer array B denoting the postorder traversal of the tree.

        Output Format
        Return the root node of the binary tree.

        Example Input
        Input 1:
        A = [2, 1, 3]
        B = [2, 3, 1]
        Input 2:
        A = [6, 1, 3, 2]
        B = [6, 3, 2, 1]

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
public class BinaryTreeFromInorderAndPostorder {
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

    public static TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        TreeNode root;
        int n = inorder.size(), m = postorder.size();

        if (n == 0 || m == 0)
            return null;

        root = new TreeNode(postorder.get(m - 1));//6,3,2,4
        int mid = inorder.indexOf(postorder.get(m - 1));//6,4,3,2

        root.left = buildTree(new ArrayList<Integer>(inorder.subList(0, mid)),
                new ArrayList<Integer>(postorder.subList(0, mid)));
        root.right = buildTree(new ArrayList<Integer>(inorder.subList(mid + 1, n)),
                new ArrayList<Integer>(postorder.subList(mid, m - 1)));

        return root;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> A = new ArrayList<>();
        A.add(6);
        A.add(4);
        A.add(3);
        A.add(2);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(6);
        B.add(3);
        B.add(2);
        B.add(4);
        TreeNode ans = buildTree(A, B);
    }

}
