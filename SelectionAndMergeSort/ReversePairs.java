package scaler.Adv.SelectionAndMergeSort;

/*Problem Description
        Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
        Return the number of important reverse pairs in the given array A.

        Problem Constraints
        1 <= length of the array <= 105
        -2 * 109 <= A[i] <= 2 * 109

        Input Format
        The only argument given is the integer array A.

        Output Format
        Return the number of important reverse pairs in the given array A.

        Example Input
        Input 1:        A = [1, 3, 2, 3, 1]
        Input 2:        A = [4, 1, 2]

        Example Output
        Output 1:        2
        Output 2:        1

        Example Explanation
        Explanation 1:
        There are two pairs which are important reverse i.e (3, 1) and (3, 1).
        Explanation 2:
        There is only one pair i.e (4, 1).*/
public class ReversePairs {
    static int reversePair = 0;

    public static int solve(int[] A) {
        int n = A.length;
        mergeSort(A, 0, n - 1);
        return reversePair;
    }

    //merge sort function to split the array into individual elements
    public static void mergeSort(int[] A, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);
        merge(A, start, mid, end);
    }

    //main merge function
    public static void merge(int[] A, int start, int mid, int end) {
        int n1 = mid - start + 1; //number of elements in array1
        int n2 = end - mid;//number of elements in array2
        int A1[] = new int[n1];
        int A2[] = new int[n2];
        int index = 0;

        //filling A1 and A2
        for (int i = start; i <= mid; i++)
            A1[index++] = A[i];

        index = 0;
        for (int i = mid + 1; i <= end; i++)
            A2[index++] = A[i];

        int i = 0, j = 0; // i and j referncing A1 and A2 array respectively

        //checking A[i] > 2*A[j] remember merge did not happened yet
        while (i < n1 && j < n2) {
            if ((long) A1[i] > 2 * (long) A2[j]) { //handle overflow
                reversePair += n1 - i;
                j++;
            } else
                i++;
        }

        //merging A1 and A2 in sorted manner

        i = 0;
        j = 0; // i and j referncing A1 and A2 array respectively
        index = start; // important because using the original input array

        while (i < n1 && j < n2) {
            if (A1[i] < A2[j]) { // equals to condition for equal elements
                A[index++] = A1[i++];
            } else {
                A[index++] = A2[j++];
            }
        }
        //if some elements still remaining after traversal
        if (i < n1) {
            while (i < n1) {
                A[index++] = A1[i++];
            }
        } else {
            while (j < n2) {
                A[index++] = A2[j++];
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{1, 3, 2, 3, 1};
        System.out.println(solve(A));
    }
}
