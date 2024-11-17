package scaler.Adv.TreeFiveProblemsOnTrees;

/*Problem Description
        Given a binary search tree represented by root A,
        write a function to find the Bth smallest element in the tree.

        Problem Constraints
        1 <= Number of nodes in binary tree <= 100000
        0 <= node values <= 10^9

        Input Format
        First and only argument is head of the binary tree A.

        Output Format
        Return an integer, representing the Bth element.

        Example Input
        Input 1:
        2
        /   \
        1    3
        B = 2
        Input 2:
        3
        /
        2
        /
        1
        B = 1

        Example Output
        Output 1:
        2
        Output 2:
        1

        Example Explanation
        Explanation 1:
        2nd element is 2.
        Explanation 2:
        1st element is 1.*/
public class KthSmallestElementInBST {
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

    static int C;
    static int ans;

    public static int kthsmallest(TreeNode A, int B) {
        C = 0;
        ans = -1;
        Dfs(A, B);
        return ans;
    }

    private static void Dfs(TreeNode A, int B) {
        if (C != B) {
            if (A == null) return;
            Dfs(A.left, B);
            C++;
            if (C == B) ans = A.val;
            Dfs(A.right, B);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(15);
        TreeNode B = new TreeNode(12);
        TreeNode C = new TreeNode(20);
       /* TreeNode D = new TreeNode(10);
        TreeNode E = new TreeNode(14);
        TreeNode F = new TreeNode(16);
        TreeNode G = new TreeNode(27);
        TreeNode H = new TreeNode(8);*/
        A.left = B;
        A.right = C;
       /* B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;*/
        System.out.println(kthsmallest(A,2));
    }
}
