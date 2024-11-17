package scaler.Adv.TreeFiveProblemsOnTrees;

/*Problem Description
        Given a binary tree and a sum, determine if the tree has a root-to-leaf
        path such that adding up all the values along the path equals the given sum.

        Problem Constraints
        1 <= number of nodes <= 105
        -100000 <= B, value of nodes <= 100000

        Input Format
        First argument is a root node of the binary tree, A.
        Second argument is an integer B denoting the sum.

        Output Format
        Return 1, if there exist root-to-leaf path such that adding up all the values
        along the path equals the given sum. Else, return 0.

        Example Input
        Input 1:
        Tree:    5
        / \
        4   8
        /   / \
        11  13  4
        /  \      \
        7    2      1

        B = 22
        Input 2:
        Tree:    5
        / \
        4   8
        /   / \
        -11 -13  4

        B = -1

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
        Explanation 2:
        There is no path which has sum -1.*/
public class PathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        public static int hasPathSum(TreeNode A, int B) {
            if (A == null) {
                return 0;
            }
            B = B - A.val;
            if (A.left == null && A.right == null && B == 0) {
                return 1;
            } else return (hasPathSum(A.left, B) | hasPathSum(A.right, B));
        }

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            TreeNode A = new TreeNode(5);
            TreeNode B = new TreeNode(4);
            TreeNode C = new TreeNode(8);
            TreeNode D = new TreeNode(11);
            TreeNode E = new TreeNode(7);
            TreeNode F = new TreeNode(2);
            TreeNode G = new TreeNode(9);
            A.left = B;
            A.right = C;
            B.left = D;
            B.right = E;
            C.left = F;
            C.right = G;
            System.out.println(hasPathSum(A,22));
        }
    }
}
