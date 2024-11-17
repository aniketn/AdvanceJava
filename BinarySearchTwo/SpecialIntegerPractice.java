package scaler.Adv.BinarySearchTwo;

public class SpecialIntegerPractice {
    public static int findSpecial(int[] A, int B) {
        int n = A.length;
        int windoStart = 0, windowEnd = 0;
        int sum = 0, ans = n;

        while (windowEnd < n) {
            sum += A[windowEnd++];
            if (sum > B && windoStart < windowEnd) {
                sum -= A[windoStart++];
                ans = Math.min(ans, windowEnd - windoStart);
            }
        }
        return ans;
    }
}
