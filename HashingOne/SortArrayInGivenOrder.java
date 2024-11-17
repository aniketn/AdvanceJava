package scaler.Adv.HashingOne;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/*Problem Description
        Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements
        will be the same as those are in B.
        For the elements not present in B, append them at last in sorted order.
        Return the array A after sorting from the above method.
        NOTE: Elements of B are unique.

        Problem Constraints
        1 <= length of the array A <= 100000
        1 <= length of the array B <= 100000
        -10^9 <= A[i] <= 10^9

        Input Format
        The first argument given is the integer array A.
        The second argument given is the integer array B.

        Output Format
        Return the array A after sorting as described.

        Example Input
        Input 1:
        A = [1, 2, 3, 4, 5]
        B = [5, 4, 2]
        Input 2:
        A = [5, 17, 100, 11]
        B = [1, 100]

        Example Output
        Output 1:
        [5, 4, 2, 1, 3]
        Output 2:
        [100, 5, 11, 17]

        Example Explanation
        Explanation 1:
        Simply sort as described.
        Explanation 2:
        Simply sort as described.*/

/**
 Step 1: create a TreeMap & add elements of A as key and count as Value
 Step 2 : Create ArrayList ans
 Step 3: Iterate the List B and if the element is present in A, get the count of it and add that element as many
        as count
 Step 4: once all the elements are added to ans, the remaining will be the elements which are not present in B
        do same as step 3 ,no need to check for the presence in B
 **/

public class SortArrayInGivenOrder {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer, Integer> map = new TreeMap<>(); // step 1

        for (int i : A) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }

        ArrayList<Integer> ans = new ArrayList<>(); //step 2

        for (int i : B) { //step 3
            if (map.containsKey(i)) {
                int count = map.get(i);
                for (int j = 0; j < count; j++) {
                    ans.add(i);
                }
                map.remove(i);
            }
        }

        map.forEach((k, v) -> { //step 4
            for (int i = 0; i < v; i++) {
                ans.add(k);
            }
        });
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(5);
        B.add(4);
        B.add(3);
        ArrayList<Integer> ans = solve(A, B);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println("" + ans.get(i));
        }
    }
}
