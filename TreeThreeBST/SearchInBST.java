package scaler.Adv.TreeThreeBST;

/*Problem Description
        Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.

        Problem Constraints
        1 <= Number of nodes in binary tree <= 105
        0 <= B <= 106

        Input Format
        First argument is a root node of the binary tree, A.
        Second argument is an integer B.

        Output Format
        Return 1 if such a node exist and 0 otherwise

        Example Input
        Input 1:
        15
        /    \
        12      20
        / \    /  \
        10  14  16  27
        /
        8

        B = 16
        Input 2:
        8
        / \
        6  21
        / \
        1   7

        B = 9

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        Node with value 16 is present.
        Explanation 2:
        There is no node with value 9.*/
public class SearchInBST {
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

    public static int solve(TreeNode A, int B) {
        if (A == null) return 0;
        if (A.val == B) return 1;
        return (A.val > B) ? solve(A.left, B) : solve(A.right, B);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(8);
        TreeNode B = new TreeNode(6);
        TreeNode C = new TreeNode(21);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(1);
        TreeNode F = new TreeNode(7);
        /*TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(8);*/
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
       /* C.right = G;
        D.left = H;*/
        System.out.println(solve(A, 21));
    }

}
