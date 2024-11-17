package scaler.Adv.TreeTwo;

import java.util.*;

/*Problem Description
        Given a binary tree of integers denoted by root A.
        Return an array of integers representing the top view of the Binary tree.
        The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
        Return the nodes in any order.

        Problem Constraints
        1 <= Number of nodes in binary tree <= 100000
        0 <= node values <= 10^9

        Input Format
        First and only argument is head of the binary tree A.

        Output Format
        Return an array, representing the top view of the binary tree.

        Example Input
        Input 1:
        1
        /   \
        2    3
        / \  / \
        4   5 6  7
        /
        8
        Input 2:
        1
        /  \
        2    3
        \
        4
        \
        5
        Example Output
        Output 1:
        [1, 2, 4, 8, 3, 7]
        Output 2:
        [1, 2, 3]

        Example Explanation
        Explanation 1:
        Top view is described.
        Explanation 2:
        Top view is described.*/
public class TopViewOfBinaryTree {
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


    static class Pair {
        Integer value;
        TreeNode node;

        Pair(Integer value, TreeNode node) {
            this.value = value;
            this.node = node;
        }
    }

    public static ArrayList<Integer> topViewOfBinaryTree(TreeNode A) {
        // to calculate the min and max key in hm on the fly;
        int min = 0;
        int max = 0;
        // create a queue for level order traversal
        Queue<Pair> queue = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null) return ans;
        queue.add(new Pair(0, A));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode currentNode = current.node;
            Integer currentLevel = current.value;
            // add current nodes left and right to queue
            if (currentNode.left != null) {
                queue.add(new Pair(currentLevel - 1, currentNode.left));
                min = Math.min(currentLevel - 1, min);
            }
            if (currentNode.right != null) {
                queue.add(new Pair(currentLevel + 1, currentNode.right));
                max = Math.max(currentLevel + 1, max);
            }
            // then check the hashmap with level and store the node val
            if (hm.get(currentLevel) == null) {
                // create a key level in hm ans add a empty array as its value and put the node val to it
                hm.put(currentLevel, new ArrayList<>());
                hm.get(currentLevel).add(currentNode.val);
            } else {
                hm.get(currentLevel).add(currentNode.val);
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(hm.get(i).get(0));
        }
        return ans;
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
        ArrayList<Integer> ans = topViewOfBinaryTree(A);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
