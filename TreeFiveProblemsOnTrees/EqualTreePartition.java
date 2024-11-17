package scaler.Adv.TreeFiveProblemsOnTrees;

import java.util.HashSet;

/*Problem Description
        Given a binary tree A. Check whether it is possible to partition the tree to two trees which have
        equal sum of values after removing exactly one edge on the original tree.

        Problem Constraints
        1 <= size of tree <= 100000
        0 <= value of node <= 109

        Input Format
        First and only argument is head of tree A.

        Output Format
        Return 1 if the tree can be partitioned into two trees of equal sum else return 0.

        Example Input
        Input 1:
        5
        /  \
        3    7
        / \  / \
        4  6  5  6
        Input 2:
        1
        / \
        2   10
        / \
        20  2

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        Remove edge between 5(root node) and 7:
        Tree 1 =                                               Tree 2 =
        5                                                     7
        /                                                     / \
        3                                                     5   6
        / \
        4   6
        Sum of Tree 1 = Sum of Tree 2 = 18
        Explanation 2:
        The given Tree cannot be partitioned.*/
public class EqualTreePartition {
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

    //******************************************HashSet APPROACH****************************************
    static HashSet<Long> set;
    static long max;

    public static int solve(TreeNode A) {
        max = -1;
        set = new HashSet<>();
        nodeSum(A);
        return max % 2 != 0 ? 0 : set.contains(max / 2) ? 1 : 0;
    }

    private static long nodeSum(TreeNode node) {
        if (node == null) return 0;
        long left = nodeSum(node.left);
        long right = nodeSum(node.right);
        set.add(0L + left + node.val + right);
        max = Math.max(max, 0L + left + node.val + right);
        return left + node.val + right;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(15);
        TreeNode B = new TreeNode(12);
        TreeNode C = new TreeNode(20);
        TreeNode D = new TreeNode(10);
        TreeNode E = new TreeNode(14);
        TreeNode F = new TreeNode(16);
        TreeNode G = new TreeNode(27);
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


//******************************************WITHOUT HashSet****************************************
   /* public class Solution {
        long totalSum;
        boolean flag, itr1;
        public int solve(TreeNode A) {
            flag = false;
            itr1 = false;
            totalSum = 0;
            nodeSum(A);
            itr1 = true;
            nodeSum(A);
            return totalSum % 2 != 0 ? 0 : flag ? 1 : 0;
        }

        private long nodeSum(TreeNode node) {
            if (node == null) return 0;
            long left = nodeSum(node.left);
            long right = nodeSum(node.right);
            totalSum = Math.max(totalSum, 0 L + left + node.val + right);
            if (itr1 && (left == totalSum / 2 || right == totalSum / 2)) flag = true;
            return left + node.val + right;
        }*/
