package scaler.Adv.TreeOne;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*Problem Description
        Given a binary tree, return the level order traversal of its nodes' values.
        (i.e., from left to right, level by level).

        Problem Constraints
        1 <= number of nodes <= 105

        Input Format
        First and only argument is root node of the binary tree, A.

        Output Format
        Return a 2D integer array denoting the level order traversal of the given binary tree.

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
        [9, 20],
        [15, 7]
        ]
        Output 2:
        [
        [1]
        [6, 2]
        [3]
        ]

        Example Explanation
        Explanation 1:
        Return the 2D array. Each row denotes the traversal of each level.*/
public class LevelOrder {
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

    public static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<Integer> subAns = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                ans.add(subAns);
                subAns = new ArrayList<>();
                if (!queue.isEmpty()) queue.add(null);
            } else {
                subAns.add(current.val);
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
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
        ArrayList<ArrayList<Integer>> ans = solve(A);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
