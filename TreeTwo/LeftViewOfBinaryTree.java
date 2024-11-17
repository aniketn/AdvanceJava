package scaler.Adv.TreeTwo;
/*
Problem Description
        Given a binary tree of integers.
        Return an array of integers representing the left view of the Binary tree.

        Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
        NOTE: The value comes first in the array which have lower level.

        Problem Constraints
        1 <= Number of nodes in binary tree <= 100000
        0 <= node values <= 109

        Input Format
        First and only argument is a root node of the binary tree, A.

        Output Format
        Return an integer array denoting the left view of the Binary tree.

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
        [1, 2, 4, 8]
        Output 2:
        [1, 2, 4, 5]

        Example Explanation
        Explanation 1:
        The Left view of the binary tree is returned.

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
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
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int len = 0;
        queue.add(A);
        while(!queue.isEmpty()) {
            len = queue.size();
            for(int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if(i == 0) {
                    ans.add(temp.val);
                }
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
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
