package scaler.Adv.TreeFourLCA;

import scaler.Adv.TreeOne.InorderTraversal;

import java.util.ArrayList;

/*Problem Description
        Given a binary tree, return the inorder traversal of its nodes' values.
        NOTE: Using recursion and stack are not allowed.

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
public class MorrisInorderTraversal {
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

    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode current = A;
        while (current != null) {
            if (current.left == null) { //if no element on left add to list and move right
                ans.add(current.val);
                current = current.right;
            } else {
                TreeNode predecessor = current.left;//if there is left node find the inorder predecessor
                while (predecessor.right != null && predecessor.right != current) { //going to current lefts and finding the rightmost node
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) { //if we incounter the null while moving right thats the first time we are traversing the subtree
                    predecessor.right = current;//preserve the parent connection and move left
                    current = current.left;
                } else {
                    predecessor.right = null; //if we encounter the current itself while moving right then its the connection we have mad earlier
                    ans.add(current.val); //no need to move left add node to list
                    current = current.right;
                }
            }
        }
        return ans;
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
        ArrayList<Integer> ans = solve(A);
        for (int a : ans) {
            System.out.println(a);
        }
    }
}
