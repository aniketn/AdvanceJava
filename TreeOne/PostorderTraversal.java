package scaler.Adv.TreeOne;

import java.util.ArrayList;

/*Problem Description
        Given a binary tree, return the Postorder traversal of its nodes values.

        Problem Constraints
        1 <= number of nodes <= 105

        Input Format
        First and only argument is root node of the binary tree, A.

        Output Format
        Return an integer array denoting the Postorder traversal of the given binary tree.

        Example Input
        Input 1:
        1
        \
        2
        /
        3
        Input 2:
        1
        / \
        6   2
        /
        3

        Example Output
        Output 1:
        [3, 2, 1]
        Output 2:
        [6, 3, 2, 1]

        Example Explanation
        Explanation 1:
        The Preoder Traversal of the given tree is [3, 2, 1].
        Explanation 2:
        The Preoder Traversal of the given tree is [6, 3, 2, 1].*/
public class PostorderTraversal {
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
    public static ArrayList<Integer> postorderTraversal(PreorderTraversal.TreeNode A) {
        ArrayList<Integer> al = new ArrayList<>();
        if (A == null) return al;
        al.addAll(postorderTraversal(A.left)); // left
        al.addAll(postorderTraversal(A.right));// right
        al.add(A.val);                     //data
        return al;
    }
}
