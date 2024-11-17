package scaler.Adv.TreeOne;

import java.util.ArrayList;

/*Problem Description
        Given a binary tree, return the preorder traversal of its nodes values.

        Problem Constraints
        1 <= number of nodes <= 105

        Input Format
        First and only argument is root node of the binary tree, A.

        Output Format
        Return an integer array denoting the preorder traversal of the given binary tree.

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
        [1, 2, 3]
        Output 2:
        [1, 6, 2, 3]

        Example Explanation
        Explanation 1:
        The Preoder Traversal of the given tree is [1, 2, 3].
        Explanation 2:
        The Preoder Traversal of the given tree is [1, 6, 2, 3].*/
public class PreorderTraversal {
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

    public static ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> al = new ArrayList<>();
        if (A == null) return al;
        al.add(A.val);                     //data
        al.addAll(preorderTraversal(A.left)); // left
        al.addAll(preorderTraversal(A.right));// right
        return al;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(4);
        TreeNode B = new TreeNode(5);
        TreeNode C = new TreeNode(2);
        TreeNode D = new TreeNode(3);
        TreeNode E = new TreeNode(6);
        A.left = B;
        A.right = C;
        C.left = D;
        C.right = E;
        ArrayList<Integer> ans = preorderTraversal(A);
        for (int a : ans) {
            System.out.println(a);
        }
    }
}
