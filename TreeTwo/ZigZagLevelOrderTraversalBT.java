package scaler.Adv.TreeTwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*Problem Description
        Given a binary tree, return the zigzag level order traversal of its nodes values.
        (ie, from left to right, then right to left for the next level and alternate between).

        Problem Constraints
        1 <= number of nodes <= 105

        Input Format
        First and only argument is root node of the binary tree, A.

        Output Format
        Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.

        Example Input
        Input 1:
        3
        / \
        9  20
        /  \
        15   7

        Input 2:
        1
        / \
        6   2
        /
        3

        Example Output
        Output 1:
        [
        [3],
        [20, 9],
        [15, 7]
        ]
        Output 2:
        [
        [1]
        [2, 6]
        [3]
        ]

        Example Explanation
        Explanation 1:
        Return the 2D array. Each row denotes the zigzag traversal of each level.*/
public class ZigZagLevelOrderTraversalBT {
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

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        int level = 1;
        while (q.size() > 0) {
            int n = q.size();
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                TreeNode temp = q.peek();
                q.poll();
                row.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            if (level % 2 == 0) {
                Collections.reverse(row);
            }
            ans.add(row);
            level++;
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
        ArrayList<ArrayList<Integer>> ans = zigzagLevelOrder(A);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
