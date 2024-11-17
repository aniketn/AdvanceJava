package scaler.Adv.TreeFiveProblemsOnTrees;

/*Problem Description
        Given a binary tree, check whether it is a mirror
        of itself (i.e., symmetric around its center).

        Problem Constraints
        1 <= number of nodes <= 105

        Input Format
        First and only argument is the root node of the binary tree.

        Output Format
        Return 0 / 1 ( 0 for false, 1 for true ).

        Example Input
        Input 1:
        1
        / \
        2   2
        / \ / \
        3  4 4  3
        Input 2:
        1
        / \
        2   2
        \   \
        3    3

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        The above binary tree is symmetric.
        Explanation 2:
        The above binary tree is not symmetric.*/
public class SymmetricBinaryTree {
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
    public static int isSymmetric(TreeNode A) {
        if (A == null) return 0;
        return (isSymmetricHelp(A.left, A.right)) ? 1 : 0;
    }

    static boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        if (left == null || right == null) // if one element is null then other element has to be null
            return (left == right); // if both are null it will return true or else false
        if (left.val != right.val) return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(2);
        TreeNode D = new TreeNode(3);
        TreeNode E = new TreeNode(4);
        TreeNode F = new TreeNode(4);
        TreeNode G = new TreeNode(3);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        System.out.println(isSymmetric(A));
    }
}
