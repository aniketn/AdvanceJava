package scaler.Adv.TreeTwo;

/*Problem Description
        Given a binary tree T, find the maximum path sum.
        The path may start and end at any node in the tree.
        Note: A maximum sum path is any path which has the maximum sum of the nodes lying on the path.

        Problem Constraints
        1 <= Number of Nodes <= 7e4
        -1000 <= Value of Node in T <= 1000

        Input Format
        The first and the only argument contains a pointer to the root of T, A.

        Output Format
        Return an integer representing the maximum sum path.

        Example Input
        Input 1:
        1
        / \
        2   3
        Input 2:
        20
        /  \
        -10   20
        /  \
        -10  -50

        Example Output
        Output 1:
        6
        Output 2:
        40

        Example Explanation
        Explanation 1:
        The path with maximum sum is: 2 -> 1 -> 3
        Explanation 2:
        The path with maximum sum is: 20 -> 20*/
public class MaxSumPathInBinaryTree {
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

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode A) {
        // Travel through post order
        postOrder(A);

        return maxSum;
    }

    private static int postOrder(TreeNode node) {
        if (node == null) return 0;
        //Calculate Best left sum possible;
        int leftSum = Math.max(0, postOrder(node.left));

        //Calculate Best right sum possible;
        int rightSum = Math.max(0, postOrder(node.right));

        maxSum = Math.max(maxSum, leftSum + rightSum + node.val);

        //Choose left path or right path
        return Math.max(leftSum + node.val, +rightSum + node.val);
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
        System.out.println(maxPathSum(A));
    }
}
