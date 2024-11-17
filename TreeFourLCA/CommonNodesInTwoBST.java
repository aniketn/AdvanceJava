package scaler.Adv.TreeFourLCA;

import java.util.HashSet;

/*Problem Description
        Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .

        In case there is no common node, return 0.

        NOTE:

        Try to do it one pass through the trees.



        Problem Constraints
        1 <= Number of nodes in the tree A and B <= 105

        1 <= Node values <= 106



        Input Format
        First argument represents the root of BST A.

        Second argument represents the root of BST B.



        Output Format
        Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .



        Example Input
        Input 1:

        Tree A:
        5
        / \
        2   8
        \   \
        3   15
        /
        9

        Tree B:
        7
        / \
        1  10
        \   \
        2  15
        /
        11
        Input 2:

        Tree A:
        7
        / \
        1   10
        \   \
        2   15
        /
        11

        Tree B:
        7
        / \
        1  10
        \   \
        2  15
        /
        11


        Example Output
        Output 1:

        17
        Output 2:

        46


        Example Explanation
        Explanation 1:

        Common Nodes are : 2, 15
        So answer is 2 + 15 = 17
        Explanation 2:

        Common Nodes are : 7, 2, 1, 10, 15, 11
        So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46*/
public class CommonNodesInTwoBST {
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

    static HashSet<Integer> set;
    static int ans;
    static int mod = 1000000007;

    public static int solve(TreeNode A, TreeNode B) {
        set = new HashSet<>();
        ans = 0;
        dfs(A);
        dfs(B);
        return ans;
    }

    private static void dfs(TreeNode node) {
        if (node == null) return;
        if (!set.add(node.val))
            ans = ans % mod + node.val;
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(5);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(8);
        TreeNode D = new TreeNode(3);
        TreeNode E = new TreeNode(15);
        TreeNode F = new TreeNode(9);
        A.left = B;
        A.right = C;
        B.right = D;
        C.right = E;
        E.left = F;

        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(1);
        TreeNode I = new TreeNode(10);
        TreeNode J = new TreeNode(2);
        TreeNode K = new TreeNode(15);
        TreeNode L = new TreeNode(11);
        G.left = H;
        G.right = I;
        H.right = J;
        I.right = K;
        K.left = L;
        System.out.println(solve(A, G));
    }
}
