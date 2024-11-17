package scaler.Adv.TreeThreeBST;

/*Problem Description
        You are given a Binary Tree A with N nodes.
        Write a function that returns the size of the largest subtree,
        which is also a Binary Search Tree (BST).

        If the complete Binary Tree is BST, then return the size of the whole tree.
        NOTE:
        The largest subtree is the subtree with the most number of nodes.

        Problem Constraints
        1 <= N <= 105

        Input Format
        First and only argument is an pointer to root of the binary tree A.

        Output Format
        Return an single integer denoting the size of the largest subtree which is also a BST.

        Example Input
        Input 1:
        10
        / \
        5  15
        / \   \
        1   8   7
        Input 2:
        5
        / \
        3   8
        / \ / \
        1  4 7  9


        Example Output
        Output 1:
        3
        Output 2:
        7

        Example Explanation
        Explanation 1:
        Largest BST subtree is
        5
        / \
        1   8
        Explanation 2:
        Given binary tree itself is BST.*/
public class LargestBSTSubtree {
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

    static int ans = Integer.MIN_VALUE;

    public static int solve(TreeNode A) {
        int k = isValid(A);
        return ans;
    }

    public static int isValid(TreeNode A) {
        if (A == null) return 0;
        int a = isValid(A.left);
        int b = isValid(A.right);

        if (A.right != null && A.val > A.right.val) return -1;
        if (A.left != null && A.val < A.left.val) return -1;

        if (a != -1 && b != -1) {
            ans = Math.max(ans, a + b + 1);
            return a + b + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(15);
        TreeNode B = new TreeNode(12);
        TreeNode C = new TreeNode(20);
        TreeNode D = new TreeNode(8);
        TreeNode E = new TreeNode(14);
        TreeNode F = new TreeNode(16);
        TreeNode G = new TreeNode(27);
        /*TreeNode H = new TreeNode(8);*/
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        /*D.left = H;*/
        System.out.println(solve(A));
    }
}
