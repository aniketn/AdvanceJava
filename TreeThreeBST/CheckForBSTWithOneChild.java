package scaler.Adv.TreeThreeBST;

/*Problem Description
        Given preorder traversal of a binary tree, check if it is possible
        that it is also a preorder traversal of a Binary Search Tree (BST),
        where each internal node (non-leaf nodes) have exactly one child.

        Problem Constraints
        1 <= number of nodes <= 100000

        Input Format
        First and only argument is an integer array denoting the preorder traversal of binary tree.

        Output Format
        Return a string "YES" if true else "NO".

        Example Input
        Input 1:
        A : [4, 10, 5, 8]
        Input 2:
        A : [1, 5, 6, 4]

        Example Output
        Output 1:
        "YES"
        Output 2:
        "NO"

        Example Explanation
        Explanation 1:
        The possible BST is:
        4
        \
        10
        /
        5
        \
        8
        Explanation 2:
        There is no possible BST which have the above preorder traversal.*/
public class CheckForBSTWithOneChild {
    public static String solve(int[] A) {
        int l = Integer.MIN_VALUE;
        int r = Integer.MAX_VALUE;
        int root = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > root) { // if the child node is greater than root update "l" else "r"
                l = root;
            } else {
                r = root;
            }
            if (l > A[i] || r < A[i]) { // if it is not comes in range return "NO"
                return "NO";
            }
            root = A[i];  // update next root node
        }
        return "YES";
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{4,10,5,8};
        System.out.println(solve(A));
    }
}
