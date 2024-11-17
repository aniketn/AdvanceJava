package scaler.Adv.TriesTwoBitsProblem;
/*Problem Description
        Given an array of integers A of size N.
        A triplet (i, j, k), i < j <= k is called a power triplet if A[i] ^ A[i+1] ^....A[j-1] = A[j] ^.....^A[k].
        Where, ^ denotes bitwise xor.
        Return the count of all possible power triplets. Since the answer could be large return answer % 109 +7.

        Problem Constraints
        1 <= N <= 100000
        1 <= A[i] <= 100000

        Input Format
        The first argument given is the integer array A.

        Output Format
        Return the count of all possible power triplets % 109 + 7.

        Example Input
        Input 1:
        A = [5, 2, 7]
        Input 2:
        A = [1, 2, 3]

        Example Output
        Output 1:
        2
        Output 2:
        2

        Example Explanation
        Explanation 1:
        All possible power triplets are:
        1. (1, 2, 3) ->  A[1] = A[2] ^ A[3]
        2. (1, 3, 3) ->  A[1] ^ A[2] = A[3]
        Explanation 2:
        All possible power triplets are:
        1. (1, 2, 3) ->  A[1] = A[2] ^ A[3]
        2. (1, 3, 3) ->  A[1] ^ A[2] = A[3]*/

//Create a Trie Datastruture to store the XOR values in bits
//* Trie DataStructure contains a 2-sized Trie DataType Array that stores the Address of next Trie Node
//* contains repeations variable to keep track of No of repeations of every element in the Node
//* contains lastIndex variable to keep track of the index that gave the node value

//Start storing all XOR values in the Trie Node starting
//Increment the repeations variable if the XOR value already found
//Update the Index of XOR value
//If any repeations is found use the formula :- Ans = CurrentIndexNoofRepeations - LastIndices;

import java.util.ArrayList;
import java.util.HashMap;

public class XORTriplets {
    /*Do we really need to use trie for this?
    What is the advantage of that?
    I want to know the thought process behind choosing trie for this as
    to me HashMap comes at first instinct and I don't see any compelling reason to go for trie.
     */

    static class Pair {
        int count, sum;

        Pair(int a) {
            count = 1;
            sum = a;
        }
    }

    public static int solve(int[] A) {
        HashMap<Integer, Pair> hm = new HashMap<>();
        hm.put(0, new Pair(0));
        int xor = 0, mod = 1000 * 1000 * 1000 + 7;
        long result = 0;
        for (int i = 0; i < A.length; i++) {
            xor = xor ^ A[i];
            if (!hm.containsKey(xor)) {
                hm.put(xor, new Pair(i + 1));
            } else {
                Pair info = hm.get(xor);
                result = (result + (i * info.count - info.sum)) % mod;
                info.count++;
                info.sum += i + 1;
                hm.put(xor, info);
            }
        }
        return (int) result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {5, 2, 7};
        System.out.println(solve(A));
    }
}
