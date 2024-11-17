package scaler.Adv.TreeThreeBST;

/*Problem Description
        Given an array where elements are sorted in ascending order,
        convert it to a height Balanced Binary Search Tree (BBST).

        Balanced tree : a height-balanced binary tree is defined as a binary tree in which
        the depth of the two subtrees of every node never differ by more than 1.

        Problem Constraints
        1 <= length of array <= 100000

        Input Format
        First argument is an integer array A.

        Output Format
        Return a root node of the Binary Search Tree.

        Example Input
        Input 1:
        A : [1, 2, 3]
        Input 2:
        A : [1, 2, 3, 5, 10]

        Example Output
        Output 1:
        2
        /   \
        1     3
        Output 2:
        3
        /   \
        2     5
        /       \
        1         10

        Example Explanation
        Explanation 1:
        You need to return the root node of the Binary Tree.*/
public class SortedArrayToBalancedBST {
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

    public static TreeNode sortedArrayToBST(final int[] A) {
        return generateBST(0, A.length - 1, A);
    }

    public static TreeNode generateBST(int l, int r, int[] A) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = generateBST(l, mid - 1, A);
        root.right = generateBST(mid + 1, r, A);
        return root;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A=new int[] {1, 2, 3};
        sortedArrayToBST(A);
    }
}
