package scaler.Adv.BinarySearchThree;

/*Problem Description
        Given an array of integers A of size N and an integer B.
        The College library has N books. The ith book has A[i] number of pages.
        You have to allocate books to B number of students so that the maximum number of pages allocated to a
        student is minimum.

        A book will be allocated to exactly one student.
        Each student has to be allocated at least one book.
        Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3,
        skipping book 2.
        Calculate and return that minimum possible number.

        NOTE: Return -1 if a valid assignment is not possible.

        Problem Constraints
        1 <= N <= 105
        1 <= A[i], B <= 105

        Input Format
        The first argument given is the integer array A.
        The second argument given is the integer B.

        Output Format
        Return that minimum possible number.

        Example Input
        A = [12, 34, 67, 90]
        B = 2
        Example Output
        113

        Example Explanation
        There are two students. Books can be distributed in following fashion :
        1)  [12] and [34, 67, 90]
        Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
        2)  [12, 34] and [67, 90]
        Max number of pages is allocated to student 2 with 67 + 90 = 157 pages
        3)  [12, 34, 67] and [90]
        Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
        Of the 3 cases, Option 3 has the minimum pages = 113.*/
public class AllocateBooks {
    public static int books(int[] A, int B) {
        int start = A[0], end = 0, ans = -1;
        if (A.length < B)
            return ans;
        for (int i = 0; i < A.length; i++) {
            end += A[i];
            start = Math.max(start, A[i]);
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (ifallocation(A, B, mid)) {
                ans = mid;
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return ans;
    }

    public static boolean ifallocation(int[] A, int B, int m) {
        int totalpages = 0, count = 1;
        for (int i = 0; i < A.length; i++) {
            totalpages += A[i];
            if (totalpages > m) {
                count++;
                totalpages = A[i];
            }
            if (count > B)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] C = new int[]{12, 34, 67, 90};
        System.out.println(books(C, 2));
    }
}
