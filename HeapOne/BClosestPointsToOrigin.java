package scaler.Adv.HeapOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Problem Description
        We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
        Here, the distance between two points on a plane is the Euclidean distance.
        You may return the answer in any order. The answer is guaranteed to be unique
        (except for the order that it is in.)

        NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).

        Problem Constraints
        1 <= B <= length of the list A <= 105
        -105 <= A[i][0] <= 105
        -105 <= A[i][1] <= 105

        Input Format
        The argument given is list A and an integer B.

        Output Format
        Return the B closest points to the origin (0, 0) in any order.

        Example Input
        Input 1:
        A = [
        [1, 3],
        [-2, 2]
        ]
        B = 1
        Input 2:
        A = [
        [1, -1],
        [2, -1]
        ]
        B = 1

        Example Output
        Output 1:
        [ [-2, 2] ]
        Output 2:
        [ [1, -1] ]

        Example Explanation
        Explanation 1:
        The Euclidean distance will be sqrt(10) for point [1,3] and sqrt(8) for point [-2,2].
        So one closest point will be [-2,2].
        Explanation 2:
        The Euclidean distance will be sqrt(2) for point [1,-1] and sqrt(5) for point [2,-1].
        So one closest point will be [1,-1].*/
public class BClosestPointsToOrigin {
    static class Pair {
        int x;
        int y;

        Pair(int xval, int yval) {
            x = xval;
            y = yval;
        }
    }

    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            // Distance is from (0,0), so didn’t mention 0 here.
            int distanceOfP1 = (p1.x * p1.x) + (p1.y * p1.y);
            int distanceOfP2 = (p2.x * p2.x) + (p2.y * p2.y);

            return Integer.compare(distanceOfP1, distanceOfP2);
        }
    }

    public static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new PairComparator());

        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> pair = A.get(i);
            Pair pairToAdd = new Pair(pair.get(0), pair.get(1));
            minHeap.add(pairToAdd);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int k = 0;
        while (k < B) {
            Pair minPair = minHeap.remove();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(minPair.x);
            temp.add(minPair.y);
            result.add(temp);
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, -1)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, -1)));
        System.out.println(solve(A, 1));
    }
}
