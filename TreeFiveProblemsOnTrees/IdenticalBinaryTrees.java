package scaler.Adv.TreeFiveProblemsOnTrees;

/*Problem Description
        Given two binary trees, check if they are equal or not.
        Two binary trees are considered equal if they are structurally
        identical and the nodes have the same value.

        Problem Constraints
        1 <= number of nodes <= 105

        Input Format
        The first argument is a root node of the first tree, A.
        The second argument is a root node of the second tree, B.

        Output Format
        Return 0 / 1 ( 0 for false, 1 for true ) for this problem.

        Example Input
        Input 1:
        1       1
        / \     / \
        2   3   2   3
        Input 2:
        1       1
        / \     / \
        2   3   3   3


        Example Output
        Output 1:
        1
        Output 2:
        0


        Example Explanation
        Explanation 1:
        Both trees are structurally identical and the nodes have the same value.
        Explanation 2:
        Values of the left child of the root node of the trees are different.*/
public class IdenticalBinaryTrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        public static int isSameTree(TreeNode A, TreeNode B) {
            if (A == null && B != null) return 0;
            if (A != null && B == null) return 0;
            if (A == null && B == null) return 1;
            int left = isSameTree(A.left, B.left);
            int right = isSameTree(A.right, B.right);
            int flag = A.val == B.val ? 1 : 0;
            return flag & left & right;
        }

        public static void main(String[] args) {
            // TODO Auto-generated method stub
            TreeNode A = new TreeNode(1);
            TreeNode B = new TreeNode(2);
            TreeNode C = new TreeNode(3);

            TreeNode D = new TreeNode(1);
            TreeNode E = new TreeNode(2);
            TreeNode F = new TreeNode(3);

            A.left = B;
            A.right = C;

            D.left = E;
            D.right = F;
            System.out.println(isSameTree(A,D));
        }
    }
}
