package scaler.Adv.TreeThreeBST;

/*Problem Description
        Given a binary search tree of integers. You are given a range B and C.
        Return the count of the number of nodes that lie in the given range.

        Problem Constraints
        1 <= Number of nodes in binary tree <= 100000
        0 <= B < = C <= 109

        Input Format
        First argument is a root node of the binary tree, A.
        Second argument is an integer B.
        Third argument is an integer C.

        Output Format
        Return the count of the number of nodes that lies in the given range.

        Example Input
        Input 1:
        15
        /    \
        12      20
        / \    /  \
        10  14  16  27
        /
        8

        B = 12
        C = 20
        Input 2:
        8
        / \
        6  21
        / \
        1   7

        B = 2
        C = 20


        Example Output
        Output 1:
        5
        Output 2:
        3*/
public class BSTNodesInARange {
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

    static int ans;

    public static int solve(TreeNode A, int B, int C) {
        ans = 0;
        modDFS(A, B, C);
        return ans;
    }

    private static void modDFS(TreeNode A, int B, int C) {
        if (A == null) return;

        if (A.val <= C && A.val >= B) {
            ans++;
            modDFS(A.left, B, C);
            modDFS(A.right, B, C);
        } else if (A.val > C) {
            modDFS(A.left, B, C);
        } else {
            modDFS(A.right, B, C);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(8);
        TreeNode B = new TreeNode(6);
        TreeNode C = new TreeNode(21);
        TreeNode D = new TreeNode(1);
        TreeNode E = new TreeNode(7);
       /* TreeNode F = new TreeNode(16);
        TreeNode G = new TreeNode(27);*/
        /*TreeNode H = new TreeNode(8);*/
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
       /* C.left = F;
        C.right = G;*/
        /*D.left = H;*/
        System.out.println(solve(A, 2, 20));
    }
}
