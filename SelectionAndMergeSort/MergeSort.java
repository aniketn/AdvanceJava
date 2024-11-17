package scaler.Adv.SelectionAndMergeSort;

public class MergeSort {
    public static int[] solve(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return A;
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k += 1;
                i += 1;
            } else {
                temp[k] = arr[j];
                k += 1;
                j += 1;
            }
        }

        while (i <= mid) {
            temp[k] = arr[i];
            k += 1;
            i += 1;
        }

        while (j <= end) {
            temp[k] = arr[j];
            k += 1;
            j += 1;
        }

        for (i = start; i <= end; i += 1) {
            arr[i] = temp[i - start];
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final int[] A = new int[]{1, 4, 10, 2, 1, 5};
        int[] ans = solve(A);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i] + "");
        }
    }
}
