package scaler.Adv.TreeOne;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Stack;

/*Problem Description
        Given a binary tree, return the inorder traversal of its nodes' values.
        NOTE: Using recursion is not allowed.

        Problem Constraints
        1 <= number of nodes <= 105

        Input Format
        First and only argument is root node of the binary tree, A.

        Output Format
        Return an integer array denoting the inorder traversal of the given binary tree.

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
        [1, 3, 2]
        Output 2:
        [6, 1, 3, 2]

        Example Explanation
        Explanation 1:
        The Inorder Traversal of the given tree is [1, 3, 2].
        Explanation 2:
        The Inorder Traversal of the given tree is [6, 1, 3, 2].*/
public class InorderTraversal {
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

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> al=new ArrayList<>();
        if(A==null) return al;
        al.addAll(inorderTraversal(A.left)); // left
        al.add(A.val);                                            // data
        al.addAll(inorderTraversal(A.right));// right
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
        ArrayList<Integer> ans = inorderTraversal(A);
        for (int a : ans) {
            System.out.println(a);
        }
    }
}
