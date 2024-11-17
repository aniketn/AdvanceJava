package scaler.Adv.BackTrackingOne;

import java.util.ArrayList;
import java.util.Collections;

/*Problem Description
        Given a set of distinct integers A, return all possible subsets.

        NOTE:

        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.
        Also, the subsets should be sorted in ascending ( lexicographic ) order.
        The list is not necessarily sorted.

        Problem Constraints
        1 <= |A| <= 16
        INTMIN <= A[i] <= INTMAX

        Input Format
        First and only argument of input contains a single integer array A.

        Output Format
        Return a vector of vectors denoting the answer.

        Example Input
        Input 1:
        A = [1]
        Input 2:
        A = [1, 2, 3]

        Example Output
        Output 1:
        [
        []
        [1]
        ]
        Output 2:
        [
        []
        [1]
        [1, 2]
        [1, 2, 3]
        [1, 3]
        [2]
        [2, 3]
        [3]
        ]

        Example Explanation
        Explanation 1:

        You can see that these are all possible subsets.
        Explanation 2:

        You can see that these are all possible subsets.*/

/*Algorithm:
        Create a recursive function that takes the following parameters,
        input array, the current index, the output array, or current subset,
         if all the subsets need to be stored then a vector of the array is needed
         if the subsets need to be printed only then this space can be ignored.
        First, print the subset (output array) that has been sent to the function
        and then run a for loop starting from the ‘index’ to n-1 where n is the size
        of the input array. We use a loop to demonstrate that we have exactly n number
        of choices to choose from when adding the first element to our new array.
        Inside the loop, we call the function for the next index after inserting that
        particular index and then in the next call, we again have (n-1) choices to
        choose from and so it goes.
        Whenever a call is made for the last index of the array : in that function call,
         the loop is not run as the condition i<A.size() is not fulfilled and hence,
         we backtrack to the last recursion call and call the function for the next index
         after removing the element at that current index.*/
public class Subset {
    static ArrayList<ArrayList<Integer>> result;

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        result = new ArrayList<>();
        result.add(new ArrayList<>());
        Collections.sort(A);
        solve_subset(A, 0, new ArrayList<Integer>());
        return result;
    }

    public static void solve_subset(ArrayList<Integer> inputArray, int index, ArrayList<Integer> temp) {
        if (index == inputArray.size())
            return;
        temp.add(inputArray.get(index));
        result.add(new ArrayList<Integer>(temp));
        solve_subset(inputArray, index + 1, temp);
        temp.remove(temp.size() - 1);
        solve_subset(inputArray, index + 1, temp);
    }

    // Driver Code
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        ArrayList<ArrayList<Integer>> ans = subsets(A);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }

        //TC : O (n)
        //SC : O (n)
    }
}
