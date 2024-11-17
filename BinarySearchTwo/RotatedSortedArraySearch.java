package scaler.Adv.BinarySearchTwo;

/*Problem Description
        Given a sorted array of integers A of size N and an integer B.
        array A is rotated at some pivot unknown to you beforehand.
        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
        You are given a target value B to search. If found in the array, return its index otherwise, return -1.
        You may assume no duplicate exists in the array.
        NOTE: Users are expected to solve this in O(log(N)) time.

        Problem Constraints
        1 <= N <= 1000000
        1 <= A[i] <= 109
        all elements in A are distinct.

        Input Format
        The first argument given is the integer array A.
        The second argument given is the integer B.

        Output Format
        Return index of B in array A, otherwise return -1

        Example Input
        Input 1:
        A = [4, 5, 6, 7, 0, 1, 2, 3]
        B = 4
        Input 2:
        A : [ 9, 10, 3, 5, 6, 8 ]
        B : 5

        Example Output
        Output 1:
        0
        Output 2:
        3

        Example Explanation
        Explanation 1:
        Target 4 is found at index 0 in A.
        Explanation 2:
        Target 5 is found at index 3 in A.*/
public class RotatedSortedArraySearch {
    public static int search(int[] A, int B) {
        int start = 0, end = A.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (B == A[mid]) {
                return mid;
            }
            if (A[start] <= A[mid]) {
                if (A[start] <= B && A[mid] >= B) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (A[end] >= B && A[mid] <= B) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] A = new int[]{9, 10, 3, 5, 6, 8 };
        System.out.println(search(A,5));
    }
}
