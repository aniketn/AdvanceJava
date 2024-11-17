package scaler.Adv.TreeFourLCA;

import java.util.ArrayList;

/*Problem Description
        Given a binary search tree.
        Return the distance between two nodes with given two keys B and C.
        It may be assumed that both keys exist in BST.

        NOTE: Distance between two nodes is number of edges between them.

        Problem Constraints
        1 <= Number of nodes in binary tree <= 1000000
        0 <= node values <= 109

        Input Format
        First argument is a root node of the binary tree, A.
        Second argument is an integer B.
        Third argument is an integer C.

        Output Format
        Return an integer denoting the distance between two nodes with given two keys B and C

        Example Input
        Input 1:
        5
        /   \
        2     8
        / \   / \
        1   4 6   11
        B = 2
        C = 11
        Input 2:
        6
        /   \
        2     9
        / \   / \
        1   4 7   10
        B = 2
        C = 6

        Example Output
        Output 1:
        3
        Output 2:
        1

        Example Explanation
        Explanation 1:
        Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
        Explanation 2:
        Path between 2 and 6 is: 2 -> 6. Distance will be 1*/
public class DistanceBetweenNodesOfBST {
    //1. Find the LCA of B&C
//2.Calculate the distance of LCA from B & LCA from C
//3. sum both the distance

    /* Java Program to find distance between n1 and n2
  using one traversal */
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node LCA(Node root, int n1, int n2) {
        if (root == null)
            return root;
        if (root.value == n1 || root.value == n2)
            return root;

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;
        if (left != null)
            return left;
        else
            return right;
    }

    // Returns level of key k if it is present in
    // tree, otherwise returns -1
    public static int findLevel(Node root, int a, int level) {
        if (root == null)
            return -1;
        if (root.value == a)
            return level;
        int left = findLevel(root.left, a, level + 1);
        if (left == -1)
            return findLevel(root.right, a, level + 1);
        return left;
    }

    public static int findDistance(Node root, int a, int b) {
        Node lca = LCA(root, a, b);

        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);

        return d1 + d2;
    }

    // Driver program to test above functions
    public static void main(String[] args) {

        // Let us create binary tree given in
        // the above example
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println("Dist(4, 5) = "
                + findDistance(root, 4, 5));

        System.out.println("Dist(4, 6) = "
                + findDistance(root, 4, 6));

        System.out.println("Dist(3, 4) = "
                + findDistance(root, 3, 4));

        System.out.println("Dist(2, 4) = "
                + findDistance(root, 2, 4));

        System.out.println("Dist(8, 5) = "
                + findDistance(root, 8, 5));
    }
}

