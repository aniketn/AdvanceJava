package scaler.Adv.TreeFiveProblemsOnTrees;

/*Problem Description
        Given a binary tree,
        Populate each next pointer to point to its next right node.
        If there is no next right node, the next pointer should be set to NULL.
        Initially, all next pointers are set to NULL.
        Assume perfect binary tree.

        Problem Constraints
        1 <= Number of nodes in binary tree <= 100000
        0 <= node values <= 10^9

        Input Format
        First and only argument is head of the binary tree A.

        Output Format
        Return the head of the binary tree after the changes are made.

        Example Input
        Input 1:
        1
        /  \
        2    3
        Input 2:
        1
        /  \
        2    5
        / \  / \
        3  4  6  7

        Example Output
        Output 1:
        1 -> NULL
        /  \
        2 -> 3 -> NULL
        Output 2:
        1 -> NULL
        /  \
        2 -> 5 -> NULL
        / \  / \
        3->4->6->7 -> NULL

        Example Explanation
        Explanation 1:
        Next pointers are set as given in the output.
        Explanation 2:
        Next pointers are set as given in the output.*/
public class NextPointerBinaryTree {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public static void connect(TreeLinkNode root) {
        TreeLinkNode current = root;
        while (current.left != null) {
            TreeLinkNode temp = current;
            while (temp != null) {
                temp.left.next = temp.right;
                temp.right.next = temp.next == null ? null : temp.next.left;
                temp = temp.next;
            }
            current = current.left;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeLinkNode A = new TreeLinkNode(15);
        TreeLinkNode B = new TreeLinkNode(12);
        TreeLinkNode C = new TreeLinkNode(20);
        TreeLinkNode D = new TreeLinkNode(10);
        TreeLinkNode E = new TreeLinkNode(14);
        TreeLinkNode F = new TreeLinkNode(16);
        TreeLinkNode G = new TreeLinkNode(27);
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        connect(A);
    }
}
