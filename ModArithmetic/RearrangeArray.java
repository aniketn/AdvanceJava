package scaler.Adv.ModArithmetic;

import java.util.ArrayList;

/*Given an array A of size N. Rearrange the given array so that A[i] becomes A[A[i]] with O(1) extra space.

        Constraints:
        1 <= N <= 5×104
        0 <= A[i] <= N - 1

        The elements of A are distinct
        Input Format
        The argument A is an array of integers

        Example 1:
        Input : [1, 0]
        Return : [0, 1]
        Example 2:
        Input : [0, 2, 1, 3]
        Return : [0, 1, 2, 3]*/
public class RearrangeArray {
    public static ArrayList<Integer> arrange(ArrayList<Integer> A) {
        int multiplier = A.size();
        // multiply every number in array A with A.length (our multiplier)
        for (int i = 0; i < A.size(); i++) {
            int val = multiplier * A.get(i);
            A.set(i, val);
        }

        // loop over the array and add the new number to each index
        for (int i = 0; i < A.size(); i++) {
            // to get old value of current index which is our index of new value to add
            int newidx = A.get(i) / multiplier;
            // now we can get the new value by dividing by the multiplier
            int newval = A.get(newidx) / multiplier + A.get(i);
            // we need to add newVal to current index
            A.set(i, newval);
        }

        // now that we have combined both numbers into one… We can now get new val: A[i]%n and to get old val:
        // A[i]/n. since we are only interest in the new val we will use the modulus (%)
        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i) % multiplier;
            A.set(i, val);
        }
        return A;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(2);
        A.add(1);
        A.add(3);
        ArrayList<Integer> ans = arrange(A);
        for (int a : ans) {
            System.out.println(" " + a);
        }
    }
}
