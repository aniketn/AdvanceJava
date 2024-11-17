package scaler.Adv.ArrayThree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*Problem Description
        Given a collection of intervals, merge all overlapping intervals.

        Problem Constraints
        1 <= Total number of intervals <= 100000.

        Input Format
        First argument is a list of intervals.
        Output Format
        Return the sorted list of intervals after merging all the overlapping intervals.

        Example Input
        Input 1:        [1,3],[2,6],[8,10],[15,18]

        Example Output
        Output 1:        [1,6],[8,10],[15,18]

        Example Explanation
        Explanation 1:
        Merge intervals [1,3] and [2,6] -> [1,6].
        so, the required answer after merging is [1,6],[8,10],[15,18].
        No more overlapping intervals present.*/
public class MergeOverlappingIntervals {
    public static ArrayList<Interval> mergeOverlappingIntervals(ArrayList<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        Collections.sort(intervals, (i1, i2) -> {
            if (i1.start != i2.start) {
                return i1.start - i2.start;
            } else {
                return i1.end - i2.end;
            }
        });

        for (int i = 1; i < intervals.size(); ) {
            if (intervals.get(i).start <= intervals.get(i - 1).end) {
                intervals.get(i - 1).end = Math.max(intervals.get(i - 1).end, intervals.get(i).end);
                intervals.remove(i);
            } else {
                i++;
            }
        }
        return intervals;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Interval newIntervalA = new Interval();
        newIntervalA.start = 1;
        newIntervalA.end = 3;
        Interval newIntervalB = new Interval();
        newIntervalB.start = 2;
        newIntervalB.end = 6;
        Interval newIntervalC = new Interval();
        newIntervalC.start = 8;
        newIntervalC.end = 10;
        Interval newIntervalD = new Interval();
        newIntervalD.start = 15;
        newIntervalD.end = 18;
        ArrayList<Interval> A = new ArrayList<>();
        A.add(newIntervalA);
        A.add(newIntervalB);
        A.add(newIntervalC);
        A.add(newIntervalD);
        ArrayList<Interval> ans = mergeOverlappingIntervals(A);
        for (Interval a : ans) {
            System.out.println("Start Interval:- " + a.start);
            System.out.println("End Interval:- " + a.end);
            System.out.println("-------------------");
        }
    }
}
