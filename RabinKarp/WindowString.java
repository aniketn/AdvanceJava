package scaler.Adv.RabinKarp;

/*Problem Description
        Given a string A and a string B, find the window with minimum length in A,
        which will contain all the characters in B in linear time complexity.
        Note that when the count of a character c in B is x,
        then the count of c in the minimum window in A should be at least x.

        Note:
        If there is no such window in A that covers all characters in B, return the empty string.
        If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )

        Problem Constraints
        1 <= size(A), size(B) <= 106

        Input Format
        The first argument is a string A.
        The second argument is a string B.

        Output Format
        Return a string denoting the minimum window.

        Example Input
        Input 1:
        A = "ADOBECODEBANC"
        B = "ABC"
        Input 2:
        A = "Aa91b"
        B = "ab"

        Example Output
        Output 1:
        "BANC"
        Output 2:
        "a91b"

        Example Explanation
        Explanation 1:
        "BANC" is a substring of A which contains all characters of B.
        Explanation 2:
        "a91b" is the substring of A which contains all characters of B.*/
public class WindowString {
    static final int no_of_chars = 256;
    static String findSubString(String A, String B) {
        int len1 = A.length();
        int len2 = B.length();

        // Check if string's length is less than pattern's length. If yes then no such window can exist
        if (len1 < len2) {
            System.out.println("No such window exists");
            return "";
        }

        int hash_pat[] = new int[no_of_chars];
        int hash_str[] = new int[no_of_chars];

        // Store occurrence ofs characters of pattern
        for (int i = 0; i < len2; i++)
            hash_pat[B.charAt(i)]++;

        int start = 0, start_index = -1,
                min_len = Integer.MAX_VALUE;

        // Start traversing the string Count of characters
        int count = 0;
        for (int j = 0; j < len1; j++) {

            // Count occurrence of characters of string
            hash_str[A.charAt(j)]++;

            // If string's char matches with pattern's char then increment count
            if (hash_str[A.charAt(j)]
                    <= hash_pat[A.charAt(j)])
                count++;

            // If all the characters are matched
            if (count == len2) {

                // Try to minimize the window
                while (hash_str[A.charAt(start)]
                        > hash_pat[A.charAt(start)]
                        || hash_pat[A.charAt(start)]
                        == 0) {

                    if (hash_str[A.charAt(start)]
                            > hash_pat[A.charAt(start)])
                        hash_str[A.charAt(start)]--;
                    start++;
                }

                // update window size
                int len_window = j - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }
            }
        }

        // If no window found
        if (start_index == -1) {
            System.out.println("No such window exists");
            return "";
        }

        // Return substring starting from start_index and length min_len
        return A.substring(start_index,
                start_index + min_len);
    }

    // Driver Method
    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String pat = "ABC";

        System.out.print(findSubString(str, pat));
    }
}
