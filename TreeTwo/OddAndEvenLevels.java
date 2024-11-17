package scaler.Adv.TreeTwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Problem Description
        Given a binary tree of integers. Find the difference between the sum of
        nodes at odd level and sum of nodes at even level.

        NOTE: Consider the level of root node as 1.

        Problem Constraints
        1 <= Number of nodes in binary tree <= 100000
        0 <= node values <= 109

        Input Format
        First and only argument is a root node of the binary tree, A
        Output Format
        Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.

        Example Input
        Input 1:
        1
        /   \
        2     3
        / \   / \
        4   5 6   7
        /
        8

        Input 2:
        1
        / \
        2   10
        \
        4


        Example Output
        Output 1:
        10
        Output 2:
        -7

        Example Explanation
        Explanation 1:
        Sum of nodes at odd level = 23
        Sum of ndoes at even level = 13
        Explanation 2:
        Sum of nodes at odd level = 5
        Sum of ndoes at even level = 12*/
public class OddAndEvenLevels {

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

    public static int solve(TreeNode A) {
        int oddSum = 0;
        int evenSum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isOdd = true;
        queue.add(A);
        queue.add(null);
        while (queue.size() > 1) {
            TreeNode current = queue.poll();
            if (current == null) {
                isOdd = !isOdd;
                queue.add(null);
            } else {
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
                if (isOdd == true) oddSum += current.val;
                if (isOdd == false) evenSum += current.val;
            }
        }
        return oddSum - evenSum;
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
        System.out.println(solve(A));
    }
}
