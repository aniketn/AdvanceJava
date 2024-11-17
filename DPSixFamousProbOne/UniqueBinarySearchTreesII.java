package scaler.Adv.DPSixFamousProbOne;

/*Problem Description
        Given an integer A, how many structurally unique BST's
        (binary search trees) exist that can store values 1...A?

        Problem Constraints
        1 <= A <=18

        Input Format
        First and only argument is the integer A

        Output Format
        Return a single integer, the answer to the problem

        Example Input
        Input 1:
        1
        Input 2:
        2

        Example Output
        Output 1:
        1
        Output 2:
        2

        Example Explanation
        Explanation 1:
        Only single node tree is possible.
        Explanation 2:
        2 trees are possible, one rooted at 1 and other rooted at 2.*/
public class UniqueBinarySearchTreesII {
    public static int numTrees(int A) {
        int[] catalon = new int[A + 1];
        catalon[0] = 1;
        catalon[1] = 1;
        for (int i = 2; i < catalon.length; i++) {
            int l = 0;
            int r = i - 1;
            while (l <= i - 1) {
                catalon[i] += catalon[l] * catalon[r];
                l++;
                r--;
            }
        }
        return catalon[A];
    }

    public static void main(String[] args) {

        System.out.println(numTrees(4));
    }
}
