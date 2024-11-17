package scaler.Adv.TreeTwo;

import scaler.Adv.TreeOne.SerializeBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Problem Description
        Given a binary tree of integers denoted by root A. Return an array of integers representing
         the right view of the Binary tree.

        Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.

        Problem Constraints
        1 <= Number of nodes in binary tree <= 100000
        0 <= node values <= 10^9

        Input Format
        First and only argument is head of the binary tree A.

        Output Format
        Return an array, representing the right view of the binary tree.

        Example Input
        Input 1:
        1
        /   \
        2    3
        / \  / \
        4   5 6  7
        /
        8
        Input 2:
        1
        /  \
        2    3
        \
        4
        \
        5

        Example Output
        Output 1:
        [1, 3, 7, 8]
        Output 2:
        [1, 3, 4, 5]

        Example Explanation
        Explanation 1:
        Right view is described.
        Explanation 2:
        Right view is described.*/
public class RightViewOfBinaryTree {
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
        if (A == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode parent = q.peek();
                if (parent.left != null) {
                    q.add(parent.left);
                }
                if (parent.right != null) {
                    q.add(parent.right);
                }
                if (i == len - 1) {
                    ans.add(parent.val);
                }
                q.poll();
            }
        }
        return ans;
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
        ArrayList<Integer> ans = solve(A);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
