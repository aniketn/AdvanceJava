package scaler.Adv.TreeTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

/*Problem Description
        Given a binary tree, return a 2-D array with vertical order traversal of it.
        Go through the example and image for more details.

        NOTE: If 2 Tree Nodes shares the same vertical level
        then the one with lesser depth will come first.

        Problem Constraints
        0 <= number of nodes <= 105

        Input Format
        First and only arument is a pointer to the root node of binary tree, A.

        Output Format
        Return a 2D array denoting the vertical order traversal of tree as shown.

        Example Input
        Input 1:
        6
        /   \
        3     7
        / \     \
        2   5     9
        Input 2:
        1
        /   \
        3     7
        /       \
        2         9

        Example Output
        Output 1:
        [
        [2],
        [3],
        [6, 5],
        [7],
        [9]
        ]
        Output 2:
        [
        [2],
        [3],
        [1],
        [7],
        [9]
        ]

        Example Explanation
        Explanation 1:
        First row represent the verical line 1 and so on.*/
public class VerticalOrderTraversal {
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

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        int max = 0, min = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, A));
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            if (!map.containsKey(poll.value))
                map.put(poll.value, new ArrayList<>());
            map.get(poll.value).add(poll.node.val);
            if (poll.node.left != null) {
                queue.add(new Pair(poll.value - 1, poll.node.left));
                min = Math.min(min, poll.value - 1);
            }
            if (poll.node.right != null) {
                queue.add(new Pair(poll.value + 1, poll.node.right));
                max = Math.max(max, poll.value + 1);
            }
        }
        for (int i = min; i <= max; i++)
            ans.add(new ArrayList<>(map.get(i)));
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
        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(A);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
