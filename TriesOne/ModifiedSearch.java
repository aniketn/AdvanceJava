package scaler.Adv.TriesOne;

import java.util.ArrayList;
import java.util.HashMap;

/*Problem Description
        Given two arrays of strings A of size N and B of size M.
        Return a binary string C where C[i] = '1' if B[i] can be found in
        dictionary A using exactly one modification in B[i], Else C[i] = '0'.

        NOTE: modification is defined as converting a character into another character.

        Problem Constraints
        1 <= N <= 30000
        1 <= M <= 2500
        1 <= length of any string either in A or B <= 20
        strings contains only lowercase alphabets

        Input Format
        First argument is the string arrray A.
        Second argument is the string array B.

        Output Format
        Return a binary string C where C[i] = '1' if B[i] can be found in dictionary
        A using one modification in B[i], Else C[i] = '0'.


        Example Input
        Input 1:
        A = [data, circle, cricket]
        B = [date, circel, crikket, data, circl]
        Input 2:
        A = [hello, world]
        B = [hella, pello, pella]

        Example Output
        Output 1:
        "10100"
        Output 2:
        "110"

        Example Explanation
        Explanation 1:
        1. date = dat*(can be found in A)
        2. circel =(cannot be found in A using exactly one modification)
        3. crikket = cri*ket(can be found in A)
        4. data = (cannot be found in A using exactly one modification)
        5. circl = (cannot be found in A using exactly one modification)
        Explanation 2:
        Only pella cannot be found in A using only one modification.*/
public class ModifiedSearch {
    public static class Trie {
        boolean isEnd;
        Trie[] nodes;

        public Trie(boolean isEnd) {
            this.isEnd = isEnd;
            nodes = new Trie[26];
        }
    }

    public static String solve(String[] A, String[] B) {
        int n = A.length;
        Trie root = new Trie(false);
        for (int i = 0; i < n; i++) {
            root = addWordInTrie(A[i], root);
        }
        int m = B.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (wordExistsInTrie(root, B[i], B[i].length(), 0, false))
                sb.append('1');
            else
                sb.append('0');
        }
        return sb.toString();
    }

    public static boolean wordExistsInTrie(Trie root, String word, int length, int index, boolean modified) {
        if (index == length && modified)
            return true;
        if (root == null || (index == length && !modified))
            return false;

        char ch = word.charAt(index);
        boolean res = false; // important before starting itrations of node array make the flag false again
        for (int i = 0; i < 26; i++) { //any node can contain answer so need to check all nodes
            if (root.nodes[i] != null) {
                if (modified && i == (ch - 'a')) {
                    res = res | wordExistsInTrie(root.nodes[i], word, length, index + 1, modified);
                } else if (!modified) {
                    if (i == (ch - 'a')) {
                        res = res | wordExistsInTrie(root.nodes[i], word, length, index + 1, modified);
                    } else {
                        res = res | wordExistsInTrie(root.nodes[i], word, length, index + 1, true);
                    }
                }
            }
        }

        return res;
    }

    public static Trie addWordInTrie(String word, Trie root) {
        Trie temp = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int index = word.charAt(i) - 'a';
            if (temp.nodes[index] == null)
                temp.nodes[index] = new Trie(false);
            temp = temp.nodes[index];
        }
        temp.isEnd = true;
        return root;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] A = new String[]{"data", "circle", "cricket"};
        String[] B = new String[]{"date", "circel", "crikket", "data", "circl"};
        System.out.println(solve(A, B));
    }
}
