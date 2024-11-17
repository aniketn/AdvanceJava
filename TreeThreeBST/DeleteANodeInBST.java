package scaler.Adv.TreeThreeBST;

/*Problem Description
        Given a Binary Search Tree(BST) A. If there is a node with value B
        present in the tree delete it and return the tree.

        Note - If there are multiple options, always replace a node by its in-order predecessor

        Problem Constraints
        2 <= No. of nodes in BST <= 105
        1 <= value of nodes <= 109
        Each node has a unique value

        Input Format
        The first argument is the root node of a Binary Search Tree A.
        The second argument is the value B.

        Output Format
        Delete the given node if found and return the root of the BST.

        Example Input
        Input 1:
        15
        /    \
        12      20
        / \    /  \
        10  14  16  27
        /
        8

        B = 10

        Input 2:
        8
        / \
        6  21
        / \
        1   7

        B = 6

        Example Output
        Output 1:
        15
        /    \
        12      20
        / \    /  \
        8  14  16  27

        Output 2:
        8
        / \
        1  21
        \
        7

        Example Explanation
        Explanation 1:
        Node with value 10 is deleted
        Explanation 2:
        Node with value 6 is deleted*/

/*Approach
        If the root is null, it means the tree is empty, so we return null as there is nothing to delete.
        If the key we want to delete is less than the root's value, we recursively call the deleteNode function on the left subtree. This ensures that we traverse the left side of the tree to find the node with the key to be deleted.
        If the key is greater than the root's value, we recursively call the deleteNode function on the right subtree. This ensures that we traverse the right side of the tree to find the node with the key to be deleted.
        If the key is equal to the root's value, we have found the node to be deleted. We handle three cases:
        If the node has no left child, we return its right child, effectively replacing the node with its right child.
        If the node has no right child, we return its left child, effectively replacing the node with its left child.
        If the node has both left and right children, we find the minimum value in its right subtree (the leftmost node in the right subtree) and replace the value of the current node with that minimum value. Then, we recursively delete that minimum node from the right subtree.
        Finally, we return the root of the modified tree.
        Complexity
        Time complexity: O(log N)
        The time complexity of the given code is O(log N) on average for a balanced binary search tree (BST), and O(N) in the worst case for a skewed tree.

        Space complexity: O(log N)
        The space complexity is O(log N) on average for the recursive calls, and O(N) in the worst case for a skewed tree.*/

public class DeleteANodeInBST {
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

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.val = minVal(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public static int minVal(TreeNode root) {
        int min = root.val;
        while (root.left != null) {
            min = root.left.val;
            root = root.left;
        }
        return min;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode A = new TreeNode(15);
        TreeNode B = new TreeNode(12);
        TreeNode C = new TreeNode(20);
        TreeNode D = new TreeNode(8);
        TreeNode E = new TreeNode(14);
        TreeNode F = new TreeNode(16);
        TreeNode G = new TreeNode(27);
        /*TreeNode H = new TreeNode(8);*/
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        /*D.left = H;*/
        System.out.println(deleteNode(A, 15));
    }
}
