package scaler.Adv.TreeTwo;

import java.util.ArrayList;

/*Given a binary tree, return the values of its boundary in anti-clockwise
direction starting from the root. Boundary includes left boundary, leaves, and right boundary
in order without duplicate nodes.

        Left boundary is defined as the path from the root to the left-most node.
        Right boundary is defined as the path from the root to the right-most node.
        If the root doesn't have left subtree or right subtree, then the root itself is left
        boundary or right boundary. Note this definition only applies to the input binary tree,
        and not applies to any subtrees.

        The left-most node is defined as a leaf node you could reach when you always firstly
        travel to the left subtree if exists. If not, travel to the right subtree.
        Repeat until you reach a leaf node.

        The right-most node is also defined by the same way with left and right exchanged.

        Return an array of integers denoting the boundary values of tree in anti-clockwise order.

        For Example

        Input 1:
        _____1_____
        /           \
        2             3
        / \            /
        4   5          6
        / \        / \
        7   8      9  10
        Output 1:
        [1, 2, 4, 7, 8, 9, 10, 6, 3]
        Explanation 1:
        The left boundary are node 1,2,4. (4 is the left-most node according to definition)
        The leaves are node 4,7,8,9,10.
        The right boundary are node 1,3,6,10. (10 is the right-most node).
        So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].

        Input 2:
        1
        / \
        2   3
        / \  / \
        4   5 6  7
        Output 2:
        [1, 2, 4, 5, 6, 7, 3]*/
public class BoundaryTraversalOfBinaryTree {
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

    static boolean isLeaf(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null)
            return true;
        return false;
    }

    static void addLeftBoundry(TreeNode root, ArrayList<Integer> res) {
        TreeNode current = root;
        while (current != null) {
            if (isLeaf(current) == false)
                res.add(current.val);
            if (current.left != null)
                current = current.left;
            else current = current.right;
        }
    }

    static void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode current = root;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        while (current != null) {
            if (isLeaf(current) == false)
                temp.add(current.val);
            if (current.right != null)
                current = current.right;
            else current = current.left;
        }
        for (int i = temp.size() - 1; i >= 1; i--)
            res.add(temp.get(i));
    }

    static void addLeafNodes(TreeNode root, ArrayList<Integer> res) {
        TreeNode current = root;
        if (isLeaf(current)) {
            res.add(current.val);
            return;
        }
        if (current.left != null)
            addLeafNodes(current.left, res);
        if (current.right != null)
            addLeafNodes(current.right, res);
    }

    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        addLeftBoundry(A, result);
        addLeafNodes(A, result);
        addRightBoundary(A, result);
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        TreeNode G = new TreeNode(7);
        TreeNode H = new TreeNode(8);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        System.out.println(solve(A));
    }
}
