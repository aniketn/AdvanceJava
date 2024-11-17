package scaler.Adv.HashingOne;

import java.util.HashMap;

public class SubArrayWithZeroSum {
    public static int solve(int[] A) {
        Long[] prefixsum = new Long[A.length];
        HashMap<Long, Integer> hm = new HashMap<>();
        prefixsum[0] = (long) A[0];
        for (int i = 1; i < A.length; i++)
            prefixsum[i] = prefixsum[i - 1] + A[i];
        for (int i = 0; i < A.length; i++) {
            if (hm.containsKey(prefixsum[i]) || prefixsum[i] == 0)
                return 1;
            else hm.put(prefixsum[i], 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = {7, 1, 3, 4, 1, 7};
        System.out.println(solve(A));
    }
}
