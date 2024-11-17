package scaler.Adv.BinarySearchTwo;

/*Problem Description
        Given a sorted array of integers A where every element appears twice except for one element which appears once,
         find and return this single element that appears only once.

        NOTE: Users are expected to solve this in O(log(N)) time.

        Problem Constraints
        1 <= |A| <= 100000
        1 <= A[i] <= 10^9

        Input Format
        The only argument given is the integer array A.

        Output Format
        Return the single element that appears only once.

        Example Input
        Input 1:        A = [1, 1, 7]
        Input 2:        A = [2, 3, 3]

        Example Output
        Output 1:        7
        Output 2:        2

        Example Explanation
        Explanation 1:        7 appears once
        Explanation 2:        2 appears once*/
public class SingleElementInSortedArray {
    public static void search(int[] arr, int low, int high) {
        if (low > high)
            return;
        if (low == high) {
            System.out.println("The required element is " + arr[low]);
            return;
        }

        // Find the middle point
        int mid = (low + high) / 2;

        // If mid is even and element next to mid is
        // same as mid, then output element lies on
        // right side, else on left side
        if (mid % 2 == 0) {
            if (arr[mid] == arr[mid + 1])
                search(arr, mid + 2, high);
            else
                search(arr, low, mid);
        }
        // If mid is odd
        else if (mid % 2 == 1) {
            if (arr[mid] == arr[mid - 1])
                search(arr, mid + 1, high);
            else
                search(arr, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{1, 1, 7};

        search(A, 0, A.length - 1);
    }
}
