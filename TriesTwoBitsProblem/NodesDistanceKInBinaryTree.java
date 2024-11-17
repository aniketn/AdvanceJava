package scaler.Adv.TriesTwoBitsProblem;

import java.util.*;

/*Problem Description
        Given the root of a binary tree A, the value of a target node B, and an integer C.
        Return an array of the values of all nodes that have a distance C from the target node B.
        Note :- The target node B always exist. All the nodes has unique value

        Problem Constraints
        1 <= number of nodes <= 105
        1 <= B <= 105
        1 <= C <= 105

        Input Format
        First argument is the root node of the binary tree, A.
        Second argument is an integer denoting the value of the target node B.
        Third argument is an integer denoting C.

        Output Format
        Return an integer array denoting the nodes at a distance C from targer node B

        Example Input
        Input 1:
        A = 1
        \
        2
        /
        3

        B = 2
        C = 1
        Input 2:
        A = 1
        / \
        6   2
        /
        3

        B = 6
        C = 2


        Example Output
        Output 1:
        [1, 3]
        Output 2:
        [2]

        Example Explanation
        Explanation 1:
        The nodes 1 and 3 are at a distance 1 from node 2.
        Explanation 2:
        The node 2 is at a distance 2 from node 6.*/
public class NodesDistanceKInBinaryTree {
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

    Map<Integer, Set<Integer>> adjMap; // for storing undirected graph ajacency list
    Set<Integer> visited; // stores visited list
    ArrayList<Integer> list; // answer list

    public ArrayList<Integer> solve(TreeNode root, int B, int C) {
        adjMap = new HashMap<>();
        list = new ArrayList<>();
        visited = new HashSet<>();
        addNodesIntoAdjMap(root);

        visited.add(B);
        traverse(adjMap.get(B), 1, C);
        return list;
    }

    public void traverse(Set<Integer> set, int distance, int C) {
        for (int node : set) {
            if (visited.contains(node))
                continue;
            visited.add(node);
            if (distance == C)
                list.add(node);
            else
                traverse(adjMap.get(node), distance + 1, C);
        }
    }

    public void addNodesIntoAdjMap(TreeNode root) {
        if (root == null)
            return;
        int src = root.val;
        if (!adjMap.containsKey(src))
            adjMap.put(src, new HashSet<>());
        if (root.left != null) {
            if (!adjMap.containsKey(root.left.val))
                adjMap.put(root.left.val, new HashSet<>());
            adjMap.get(src).add(root.left.val);
            adjMap.get(root.left.val).add(src);
        }
        if (root.right != null) {
            if (!adjMap.containsKey(root.right.val))
                adjMap.put(root.right.val, new HashSet<>());
            adjMap.get(src).add(root.right.val);
            adjMap.get(root.right.val).add(src);
        }

        addNodesIntoAdjMap(root.left);
        addNodesIntoAdjMap(root.right);
    }
}
