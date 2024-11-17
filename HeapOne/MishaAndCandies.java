package scaler.Adv.HeapOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*Problem Description
        Misha loves eating candies. She has been given N boxes of Candies.

        She decides that every time she will choose a box having the
        minimum number of candies, eat half of the candies and put the remaining candies in the other box
        that has the minimum number of candies.
        Misha does not like a box if it has the number of candies greater than B so
        she won't eat from that box. Can you find how many candies she will eat?

        NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).
        NOTE 2: The same box will not be chosen again.

        Problem Constraints
        1 <= N <= 105
        1 <= A[i] <= 105
        1 <= B <= 106

        Input Format
        The first argument is A an Array of Integers, where A[i] is the number of candies in the ith box.
        The second argument is B, the maximum number of candies Misha like in a box.

        Output Format
        Return an integer denoting the number of candies Misha will eat.

        Example Input
        Input 1:
        A = [3, 2, 3]
        B = 4
        Input 2:
        A = [1, 2, 1]
        B = 2

        Example Output
        Output 1:
        2
        Output 2:
        1

        Example Explanation
        Explanation 1:
        1st time Misha will eat from 2nd box, i.e 1 candy she'll eat and will put the remaining 1 candy in the 1st box.
        2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 2 candies in the 1st box.
        She will not eat from the 3rd box as now it has candies greater than B.
        So the number of candies Misha eat is 2.
        Explanation 2:
        1st time Misha will eat from 1st box, i.e she can't eat any and will put the remaining 1 candy in the 3rd box.
        2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 1 candies in the 2nd box.
        She will not eat from the 2nd box as now it has candies greater than B.
        So the number of candies Misha eat is 1.*/
public class MishaAndCandies {
    public static int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Comparator.naturalOrder());
        int totalCandiesEat = 0;

        // Add all elments to minHeap
        for (int i = 0; i < A.size(); i++) {
            minHeap.add(A.get(i));
        }

        while (!minHeap.isEmpty() && minHeap.peek() <= B) {
            int currentCandie = minHeap.remove();
            totalCandiesEat += Math.floor(currentCandie / 2);

            if (!minHeap.isEmpty()) {
                int candieToAdd = minHeap.remove();
                candieToAdd += currentCandie - Math.floor(currentCandie / 2);
                minHeap.add(candieToAdd);
            }
        }
        return totalCandiesEat;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(2);
        A.add(3);
        System.out.println(solve(A, 4));
    }
}
