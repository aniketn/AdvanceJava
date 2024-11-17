package scaler.Adv.ArrayThree;

import java.util.ArrayList;

public class MergeIntervals {
    public static ArrayList<Interval> mergeInterval(ArrayList<Interval> intervals, Interval newInterval) {
        int start = Math.min(newInterval.start, newInterval.end);
        int end = Math.max(newInterval.end, newInterval.start);
        newInterval.start = start;
        newInterval.end = end;
        ArrayList<Interval> ans = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).end < newInterval.start) {
                ans.add(intervals.get(i));
            } else if (intervals.get(i).start > newInterval.end) {
                ans.add(newInterval);
                for (int j = i; j < intervals.size(); j++) {
                    ans.add(intervals.get(j));
                }
                return ans;
            } else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }
        ans.add(newInterval);
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Interval newIntervalA = new Interval();
        newIntervalA.start = 1;
        newIntervalA.end = 3;
        Interval newIntervalB = new Interval();
        newIntervalB.start = 6;
        newIntervalB.end = 9;
        ArrayList<Interval> A = new ArrayList<>();
        A.add(newIntervalA);
        A.add(newIntervalB);
        Interval newInterval = new Interval();
        newInterval.start = 2;
        newInterval.end = 6;
        Interval B = newInterval;
        ArrayList<Interval> ans = mergeInterval(A, B);
        for (Interval a : ans) {
            System.out.println("Start Interval:- " + a.start);
            System.out.println("End Interval:- " + a.end);
            System.out.println("-------------------");
        }
    }
}
