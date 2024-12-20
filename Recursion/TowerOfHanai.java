package scaler.Adv.Recursion;

/*Problem Description
       In the classic problem of the Towers of Hanoi, you have 3 towers numbered from 1 to 3 (left to right)
       and A disks numbered from 1 to A (top to bottom) of different sizes which can slide onto any tower.
       The puzzle starts with disks sorted in ascending order of size from top to bottom (i.e., each disk
       sits on top of an even larger one).

       You have the following constraints:
       Only one disk can be moved at a time.
       A disk is slid off the top of one tower onto another tower.
       A disk cannot be placed on top of a smaller disk.
       You have to find the solution to the Tower of Hanoi problem.
       You have to return a 2D array of dimensions M x 3, where M is the minimum number of moves needed to solve
        the problem.
       In each row, there should be 3 integers (disk, start, end), where:

       disk - number of disk being moved
       start - number of the tower from which the disk is being moved
       stop - number of the tower to which the disk is being moved

       Problem Constraints
       1 <= A <= 18

       Input Format
       The first argument is the integer A.

       Output Format
       Return a 2D array with dimensions M x 3 as mentioned above in the description.

       Example Input
       Input 1:        A = 2
       Input 2:        A = 3

       Example Output
       Output 1:        [1 1 2 ] [2 1 3 ] [1 2 3 ]
       Output 2:        [1 1 3 ] [2 1 2 ] [1 3 2 ] [3 1 3 ] [1 2 1 ] [2 2 3 ] [1 1 3 ]

       Example Explanation
       Explanation 1:
       We shift the first disk to the middle tower.
       We shift the second disk to the last tower.
       We, finally, shift the first disk from the middle tower to the last tower.
       Explanation 2:

       We can see that this the only unique path with minimal moves to move all disks from the first to the
        third tower.*/
public class TowerOfHanai {
    static int curr;
    static int[][] Ans;

    public static void rec(int disk, int source, int dest) {
        if (disk == 1) {
            Ans[curr++] = new int[]{disk, source, dest};
            return;
        }
        // move top (disk - 1) disks from source to temp, using dest as a temp
        rec(disk - 1, source, 6 - source - dest);
        // move top from source to dest
        Ans[curr++] = new int[]{disk, source, dest};
        // move top (disk - 1) disks from temp to dest, using source as a temp
        rec(disk - 1, 6 - source - dest, dest);
    }

    public static int[][] towerOfHanoi(int A) {
        curr = 0;
        int source = 1, dest = 3;
        // total number of moves will be 2^A -1 to move A disks from Tower 1 to Tower 3;
        int m = ((1 << A) - 1);// where 1<<A == 2^A;
        // now make Ans 2 D array of size [m][3] to store the moves as we have three towers;
        Ans = new int[m][3];
        rec(A, source, dest);
        return Ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] ans = towerOfHanoi(2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.println(ans[i][j] + "");
            }
        }
    }
}

