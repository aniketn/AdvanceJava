package scaler.Adv.TriesTwoBitsProblem;
/*Problem Description
        Given an array, A of integers of size N. Find the subarray AL, AL+1, AL+2, ... AR
         with 1<=L<=R<=N, which has maximum XOR value.

        NOTE: If there are multiple subarrays with the same maximum value,
        return the subarray with minimum length. If the length is the same, return the subarray with the minimum starting index.

        Problem Constraints
        1 <= N <= 100000
        0 <= A[i] <= 109

        Input Format
        First and only argument is an integer array A.

        Output Format
        Return an integer array B of size 2. B[0] is the starting index(1-based)
        of the subarray and B[1] is the ending index(1-based) of the subarray.


        Example Input
        Input 1:
        A = [1, 4, 3]
        Input 2:
        A = [8]

        Example Output
        Output 1:
        [2, 3]
        Output 2:
        [1, 1]

        Example Explanation
        Explanation 1:
        There are 6 possible subarrays of A:
        subarray            XOR value
        [1]                     1
        [4]                     4
        [3]                     3
        [1, 4]                  5 (1^4)
        [4, 3]                  7 (4^3)
        [1, 4, 3]               6 (1^4^3)

        [4, 3] subarray has maximum XOR value. So, return [2, 3].
        Explanation 2:
        There is only one element in the array. So, the maximum XOR value is equal to 8
        and the only possible subarray is [1, 1].*/

/*Steps:

        1.  create a prefix XOR array.
        2.  create a trie and first insert num 0 with index -1. (hack: use to get the sub-array form 0-ith index)
        3.  query the prefixXOR element  px_num one by one to get its complement num in the trie and update maxXOR .
        4. inset px_num in the trie.
        5. loop.*/
public class MaximumXORSubarray {
    public static int[] solve(int[] A) {
        // init
        int[] prefixXOR = new int[A.length];
        prefixXOR[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ A[i];
        }

        NodePrefix root = new NodePrefix();
        int maxXor = Integer.MIN_VALUE;
        int s = -1;
        int e = -1;

        insert(root, 0, -1); // -1 index has 0. since x^0 = x.

        for (int i = 0; i < prefixXOR.length; i++) {
            int ind = query(root, prefixXOR[i]); // complement of prefix num index
            int currXor = (ind == -1) ? prefixXOR[i] : (prefixXOR[i] ^ prefixXOR[ind]); // ind = -1, took the subarray from 0-i
            if (currXor > maxXor || s == -1) {
                maxXor = currXor;
                s = ind + 1;
                e = i;
            } else if (currXor == maxXor) {
                int currLen = i - (ind + 1) + 1;
                int prevLen = e - s + 1;
                if (currLen < prevLen) {
                    s = ind + 1;
                    e = i;
                }
            }
            insert(root, prefixXOR[i], i);
        }

        int[] res = {s + 1, e + 1};
        return res;
    }

    private static int query(NodePrefix root, int prefixNum) {
        NodePrefix curr = root;
        for (int j = 30; j >= 0; j--) {
            int bit = checkBit(prefixNum, j);
            int compBit = bit == 1 ? 0 : 1;
            if (curr.child[compBit] != null) {
                curr = curr.child[compBit];
            } else {
                curr = curr.child[bit];
            }
        }
        return curr.index;
    }

    private static void insert(NodePrefix root, int prefixNum, int index) {
        NodePrefix curr = root;
        for (int i = 30; i >= 0; i--) {
            int bit = checkBit(prefixNum, i);
            if (curr.child[bit] == null) {
                curr.child[bit] = new NodePrefix();
            }
            curr = curr.child[bit];
        }
        curr.index = index;
    }

    private static int checkBit(int prefixNum, int i) {
        return (prefixNum >> i & 1) == 1 ? 1 : 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{1, 4, 3};
        System.out.println(solve(A));
    }
}

class NodePrefix {
    int index;
    NodePrefix[] child;

    NodePrefix() {
        index = -1;
        child = new NodePrefix[2];
    }
}


