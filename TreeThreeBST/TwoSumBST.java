package scaler.Adv.TreeThreeBST;

import java.util.HashSet;

/*Problem Description
        Given a binary search tree A, where each node contains a positive integer,
        and an integer B, you have to find whether or not there exist two different nodes X and Y
        such that X.value + Y.value = B.

        Return 1 to denote that two such nodes exist. Return 0, otherwise.

        Problem Constraints
        1 <= size of tree <= 100000
        1 <= B <= 109

        Input Format
        First argument is the head of the tree A.
        Second argument is the integer B.

        Output Format
        Return 1 if such a pair can be found, 0 otherwise.

        Example Input
        Input 1:
        10
        / \
        9   20

        B = 19
        Input 2:

        10
        / \
        9   20
        B = 40

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explanation 1:
        10 + 9 = 19. Hence 1 is returned.
        Explanation 2:
        No such pair exists.*/
public class TwoSumBST {

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

    static boolean flag;
    static HashSet<Integer> set;

    public static int t2Sum(TreeNode A, int B) {
        set = new HashSet<>();
        flag = false;
        DFS(A, B);
        return flag == true ? 1 : 0;
    }

    private static void DFS(TreeNode node, int B) {
        if (node == null) return;
        DFS(node.left, B);
        DFS(node.right, B);
        if (set.contains(B - node.val)) {
            flag = true;
        } else {
            set.add(node.val);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(10);
        TreeNode B = new TreeNode(9);
        TreeNode C = new TreeNode(20);
       /* TreeNode D = new TreeNode(1);
        TreeNode E = new TreeNode(7);*/
       /* TreeNode F = new TreeNode(16);
        TreeNode G = new TreeNode(27);*/
        /*TreeNode H = new TreeNode(8);*/
        A.left = B;
        A.right = C;
       /* B.left = D;
        B.right = E;*/
       /* C.left = F;
        C.right = G;*/
        /*D.left = H;*/
        System.out.println(t2Sum(A, 19));
    }
}
