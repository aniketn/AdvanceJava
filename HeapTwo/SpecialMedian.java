package scaler.Adv.HeapTwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*Problem Description
        You are given an array A containing N numbers.
        This array is called special if it satisfies one of the following properties:

        There exists an element A[i] in the array such that
        A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
        There exists an element A[i] in the array such that
        A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
        The Median is the middle element in the sorted list of elements.
        If the number of elements is even then the median will be (sum of both middle elements) / 2.

        Return 1 if the array is special else return 0.

        NOTE:

        Do not neglect decimal point while calculating the median
        For A[0] consider only the median of elements
        [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
        For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]

        Problem Constraints
        1 <= N <= 1000000.
        A[i] is in the range of a signed 32-bit integer.

        Input Format
        The first and only argument is an integer array A.

        Output Format
        Return 1 if the given array is special else return 0.

        Example Input
        Input 1:
        A = [4, 6, 8, 4]
        Input 2:
        A = [2, 7, 3, 1]

        Example Output
        Output 1:
        1
        Output 2:
        0

        Example Explanation
        Explantion 1:
        Here, 6 is equal to the median of [8, 4].
        Explanation 2:
        No element satisfies any condition.*/
public class SpecialMedian {
    public static int solve(ArrayList<Integer> A) {
        ArrayList<Double> LtToRt = getmedian(A);
        for(int i = 0; i < LtToRt.size()- 1 ; i++){
            if(LtToRt.get(i).equals(A.get(i + 1).doubleValue())){
                return 1;
            }
        }
        Collections.reverse(A);
        ArrayList<Double> RtToLt = getmedian(A);
        for(int i = 0; i < RtToLt.size()-1 ; i++){
            if(RtToLt.get(i).equals(A.get(i + 1).doubleValue())){
                return 1;
            }
        }
        return 0;
    }
    public static ArrayList<Double> getmedian(ArrayList<Integer> A) {
        PriorityQueue<Integer> minrt = new PriorityQueue<>();
        PriorityQueue<Integer> maxlt = new PriorityQueue<>( Collections.reverseOrder());
        ArrayList<Double> ans = new ArrayList<>();

        for(int i = 0; i < A.size(); i++){
            if(i%2 == 0){
                minrt.add(A.get(i));
                maxlt.add(minrt.remove());
                ans.add((double)maxlt.peek());
            }
            else if(i%2 != 0){
                maxlt.add(A.get(i));
                minrt.add(maxlt.remove());
                ans.add((maxlt.peek() + minrt.peek())/2.0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(4);
        A.add(6);
        A.add(8);
        A.add(4);
        //A.add(3);
        System.out.println(solve(A));
    }
}
