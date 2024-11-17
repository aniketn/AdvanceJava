package scaler.Adv.ArrayThree;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FirstMissingIntegerSCOne {
    public static ArrayList<Integer> swap(ArrayList<Integer> A, int i, int idx) {
        int temp = A.get(i);
        A.set(i, A.get(idx));
        A.set(idx, temp);

        return A;
    }

    public static int firstMissingPositiveTCOne(ArrayList<Integer> A) {
        /*
            The idea is to sort the in range natural numbers [1,n] to their correct position in 0 based indexing.
            Then check the array/arraylist which does not match the position. The natural number which does not
            match the position is the answer. If all the elements are in correct position then the max + 1 is The
            answer.
        */

        int i = 0;
        while (i < A.size()) {
            //if the value is out of range or already in the correct place then move forward
            if (A.get(i) < 1 || A.get(i) > i || A.get(i) == i + 1) {
                i++;
            } else {
                //find the actual index of the value in 0 based indexing.
                int idx = A.get(i) - 1;

                //for duplicate scenarios. If the already one instance of the value is not present then swap else move forward
                if (A.get(idx) != A.get(i))
                    A = swap(A, i, idx);
                else
                    i++;
            }
        }

        for (i = 0; i < A.size(); i++) {
            if (A.get(i) != i + 1) {
                return i + 1;
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(0);
        System.out.println(firstMissingPositiveTCOne(A));
    }
}
