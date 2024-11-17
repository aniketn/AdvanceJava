package scaler.Adv.TriesOne;

import java.util.ArrayList;
import java.util.HashMap;

import static scaler.Adv.TriesOne.ShortestUniquePrefix.Node.prefix;

/*Problem Description
        Given a list of N words, find the shortest unique prefix to represent each word in the list.
        NOTE: Assume that no word is the prefix of another.
        In other words, the representation is always possible

        Problem Constraints
        1 <= Sum of length of all words <= 106

        Input Format
        First and only argument is a string array of size N.

        Output Format
        Return a string array B where B[i] denotes the shortest unique prefix to represent the ith word.

        Example Input
        Input 1:
        A = ["zebra", "dog", "duck", "dove"]
        Input 2:
        A = ["apple", "ball", "cat"]

        Example Output
        Output 1:
        ["z", "dog", "du", "dov"]
        Output 2:
        ["a", "b", "c"]

        Example Explanation
        Explanation 1:
        Shortest unique prefix of each word is:
        For word "zebra", we can only use "z" as "z" is not any prefix of any other word given.
        For word "dog", we have to use "dog" as "d" and "do" are prefixes of "dov".
        For word "du", we have to use "du" as "d" is prefix of "dov" and "dog".
        For word "dov", we have to use "dov" as "d" and do" are prefixes of "dog".

        Explanation 2:
        "a", "b" and c" are not prefixes of any other word. So, we can use of first letter of each to represent.*/
public class ShortestUniquePrefix {
    static class Node {
        char ch;
        boolean isEnd;
        int wordCnt;
        HashMap<Character, Node> child;

        Node(char x) {
            ch = x;
            isEnd = false;
            child = new HashMap<>();
            wordCnt = 0;
        }

        public static ArrayList<String> prefix(ArrayList<String> A) {
            ArrayList<String> ans = new ArrayList<>();
            Node root = new Node(' ');
            for (int i = 0; i < A.size(); i++) put(A.get(i), root);
            for (int i = 0; i < A.size(); i++) ans.add(prefix(A.get(i), root));
            return ans;
        }

        private static void put(String word, Node root) {
            Node current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!current.child.containsKey(ch)) current.child.put(ch, new Node(ch));
                current = current.child.get(ch);
                current.wordCnt++;
            }
            current.isEnd = true;
        }

        private static String prefix(String word, Node root) {
            Node current = root;
            StringBuilder preFixres = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                current = current.child.get(ch);
                preFixres.append(ch);
                if (current.wordCnt == 1) break;
            }
            return preFixres.toString();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<String> A = new ArrayList<>();
        A.add("zebra");
        A.add("dog");
        A.add("duck");
        A.add("dove");
        System.out.println(prefix(A));
    }
}
