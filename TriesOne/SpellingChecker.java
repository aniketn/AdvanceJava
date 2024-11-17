package scaler.Adv.TriesOne;

import java.util.ArrayList;

/*Problem Description
        Given an array of words A (dictionary) and another array B (which contain some words).
        You have to return the binary array (of length |B|) as the answer where 1
        denotes that the word is present in the dictionary and 0 denotes it is not present.

        Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
        Such problems can be seen in real life when we work on any online editor
        (like Google Documnet), if the word is not valid it is underlined by a red line.

        NOTE: Try to do this in O(n) time complexity.

        Problem Constraints
        1 <= |A| <= 1000
        1 <= sum of all strings in A <= 50000
        1 <= |B| <= 1000

        Input Format
        First argument is array of strings A.
        First argument is array of strings B.

        Output Format
        Return the binary array of integers according to the given format.

        Example Input
        Input 1:
        A = [ "hat", "cat", "rat" ]
        B = [ "cat", "ball" ]
        Input 2:
        A = [ "tape", "bcci" ]
        B = [ "table", "cci" ]

        Example Output
        Output 1:
        [1, 0]
        Output 2:
        [0, 0]

        Example Explanation
        Explanation 1:
        Only "cat" is present in the dictionary.
        Explanation 2:
        None of the words are present in the dictionary.*/
public class SpellingChecker {
    static class Node {
        char ch;
        boolean isEnd;
        Node[] child;

        Node(char x) {
            ch = x;
            isEnd = false;
            child = new Node[129];
        }
    }


    public static ArrayList<Integer> solve(ArrayList<String> A, ArrayList<String> B) {
        ArrayList<Integer> ans = new ArrayList<>();
        Node root = new Node(' ');
        for (int i = 0; i < A.size(); i++) put(A.get(i), root);
        for (int i = 0; i < B.size(); i++) ans.add(search(B.get(i), root) == true ? 1 : 0);
        return ans;
    }

    private static void put(String word, Node root) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.child[(int) ch] == null) current.child[(int) ch] = new Node(ch);
            current = current.child[(int) ch];
        }
        current.isEnd = true;
    }

    private static boolean search(String word, Node root) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.child[(int) ch] == null) return false;
            current = current.child[(int) ch];
        }
        if (current.isEnd == true) return true;
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<String> A = new ArrayList<>();
        A.add("hat");
        A.add("cat");
        A.add("rat");
        ArrayList<String> B=new ArrayList<>();
        B.add("cat");
        B.add("ball");
        System.out.println(solve(A,B));
    }
}
