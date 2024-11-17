package scaler.Adv.DPThreeknapsack;

import java.util.ArrayList;
import java.util.Collections;

/*Problem Description
        Given two integer arrays A and B of size N each which represent values and
        weights associated with N items respectively.

        Also given an integer C which represents knapsack capacity.

        Find out the maximum total value that we can fit in the knapsack.
        If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).

        NOTE:
        You can break an item for maximizing the total value of the knapsack

        Problem Constraints
        1 <= N <= 105
        1 <= A[i], B[i] <= 103
        1 <= C <= 103

        Input Format
        First argument is an integer array A of size N denoting the values on N items.
        Second argument is an integer array B of size N denoting the weights on N items.
        Third argument is an integer C denoting the knapsack capacity.

        Output Format
        Return a single integer denoting the maximum total value of A such that
        sum of the weights of this subset is smaller than or equal to C.

        Example Input
        Input 1:
        A = [60, 100, 120]
        B = [10, 20, 30]
        C = 50
        Input 2:
        A = [10, 20, 30, 40]
        B = [12, 13, 15, 19]
        C = 10

        Example Output
        Output 1:
        24000
        Output 2:
        2105

        Example Explanation
        Explanation 1:
        Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
        the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
        Explanation 2:
        Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.*/
public class FractionalKnapsack {
    static class Item {
        int value;
        int weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Item> arr = new ArrayList<Item>();

        for (int i = 0; i < A.size(); i++) {
            arr.add(new Item(A.get(i), B.get(i)));
        }

        Collections.sort(arr, (Item u, Item v) -> {
            double r1 = (double) u.value / (double) u.weight;
            double r2 = (double) v.value / (double) v.weight;

            if (r1 <= r2) return 1;
            else if (r1 > r2) return -1;
            else return 0;
        });

        int currentWeight = 0;
        double finalValue = 0.0;

        for (int i = 0; i < arr.size(); i++) {
            if (currentWeight + arr.get(i).weight <= C) {
                currentWeight += arr.get(i).weight;
                finalValue += (double) arr.get(i).value;
            } else {
                int remain = C - currentWeight;
                finalValue += ((double) arr.get(i).value / arr.get(i).weight) * ((double) remain);
                break;
            }
        }
        return (int) ((finalValue * 1000) / 10);
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(60);
        A.add(100);
        A.add(120);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(10);
        B.add(20);
        B.add(30);
        System.out.println(solve(A, B, 50));
    }
}