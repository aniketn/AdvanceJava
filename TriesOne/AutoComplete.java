package scaler.Adv.TriesOne;
/*
Problem Description
        There is a dictionary A of N words, and ith word has a unique weight Wi.
        Another string array B of size M contains the prefixes. For every prefix B[i],
        output atmost 5 words from the dictionary A that start with the same prefix.

        Output the words in decreasing order of their weight.
        NOTE: If there is no word that starts with the given prefix output -1.

        Problem Constraints
        1 <= T <= 5
        1 <= N <= 20000
        1 <= M <= 10000
        1 <= Wi <= 106
        1 <= length of any string either in A or B <= 30

        Input Format
        First line is an integer T denoting the number of test cases.
        For each test case,
        First line denotes two space seperated integer N and M.
        Second line denotes N space seperated strings denoting the words in dictionary.
        Third line denotes N space seperated integers denoting the weight of each word in the dictionary.
        Fourth line denotes M space seperated integers denoting the prefixes.

        Output Format
        For every prefix B[i], print the space seperated output on a new line.
        NOTE: After every output there should be a space.

        Example Input
        Input 1:
        1
        6 3
        abcd aecd abaa abef acdcc acbcc
        2 1 3 4 6 5
        ab abc a
        Input 2:
        1
        5 3
        aaaa aacd abaa abaa aadcc
        3 4 1 2 6
        aa aba abc

        Example Output
        Output 1:
        abef abaa abcd
        abcd
        acdcc acbcc abef abaa abcd
        Output 2:
        aadcc aacd aaaa
        abaa abaa
        -1


        Example Explanation
        Explanation 1:
        For the prefix "ab" 3 words in the dictionary have same prefix:
        ("abcd" : 2, "abaa" : 3, "abef" : 4). Ouput them in decreasing order of weight.
        For the prefix "abc" only 1 word in the dictionary have same prefix: ("abcd" : 2).
        For the prefix "a" all 6 words in the dictionary have same prefix:
        ("abcd" : 2, "aecd" : 1, "abaa" : 3, "abef" : 4, "acdcc" : 6, "acbcc" : 5).
        Since we can output atmost 5 words. Output top 5 weighted words in decreasing order of weight.
        Explanation 2:
        For the prefix "aa" 3 words in the dictionary have same prefix:
        ("aaaa" : 3, "aacd" : 4, "aadcc" : 6). Ouput them in decreasing order of weight.
        For the prefix "aba" 2 words in the dictionary have same prefix: ("abaa" : 1, "abaa" : 2).
        For the prefix "abc" there is no word in the dictionary which have same prefix. So print -1.

*/

import java.util.*;

public class AutoComplete {
    String str;
    int weight;

    public AutoComplete(String str, int weight) {
        this.str = str;
        this.weight = weight;
    }

    static class Node {
        boolean isEnd;
        HashMap<Character, Node> hm;
        ArrayList<AutoComplete> ar;

        Node() {
            this.hm = new HashMap<Character, Node>();
            this.isEnd = false;
            this.ar = new ArrayList<AutoComplete>();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int k = 0; k < t; k++) {
            // read the second line of input
            String line2 = scanner.nextLine();
            String[] NandM = line2.split(" ");
            int[] nums2 = new int[NandM.length];
            for (int i = 0; i < NandM.length; i++) {
                nums2[i] = Integer.parseInt(NandM[i]);
            }

            // read the third line of input
            String line3 = scanner.nextLine();
            String[] words = line3.split(" ");

            // read the fourth line of input
            String line4 = scanner.nextLine();
            String[] weights = line4.split(" ");

            AutoComplete[] suggestions = new AutoComplete[weights.length];
            for (int i = 0; i < weights.length; i++) {
                suggestions[i] = new AutoComplete(words[i], Integer.parseInt(weights[i]));
            }

            Arrays.sort(suggestions, new Comparator<AutoComplete>() {
                public int compare(AutoComplete p1, AutoComplete p2) {
                    int indexA = p1.weight;
                    int indexB = p2.weight;
                    return indexB - indexA;
                }
            });

            Node root = new Node();
            for (int i = 0; i < suggestions.length; i++) {
                insert(suggestions[i].str, root, i);
            }

            // read the fifth line of input
            String line5 = scanner.nextLine();
            String[] searchwords = line5.split(" ");
            for (int i = 0; i < searchwords.length; i++) {
                search(searchwords[i], root);
            }
        }
    }

    public static void insert(String word, Node root, int wt) {
        Node t = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (t.hm.containsKey(ch)) {
                t = t.hm.get(ch);
                if (t.ar.size() < 5) {
                    t.ar.add(new AutoComplete(word, wt));
                }
            } else {
                Node nn = new Node();
                t.hm.put(ch, nn);
                t = nn;
                t.ar.add(new AutoComplete(word, wt));
            }
        }
        t.isEnd = true;
    }

    public static void search(String word, Node root) {
        Node t = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (t.hm.containsKey(ch)) {
                t = t.hm.get(ch);
            } else {
                System.out.print("-1 ");
                System.out.println();
                return;
            }
        }

        for (int j = 0; j < t.ar.size(); j++) {
            System.out.print(t.ar.get(j).str + " ");
        }
        System.out.println();
    }
}
