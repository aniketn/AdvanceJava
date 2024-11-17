package scaler.Adv.GraphShortestPathAlgo;
/*
Problem Description
        Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B,
        we need to find whether Knight can move to the destination or not.

        The above figure details the movements for a knight ( 8 possibilities ).

        If yes, then what would be the minimum number of steps for the knight to move
        to the said point. If knight can not move from the source point to the
        destination point, then return -1.

        NOTE: A knight cannot go out of the board.

        Problem Constraints
        1 <= A, B <= 500

        Input Format
        The first argument of input contains an integer A.
        The second argument of input contains an integer B.
        The third argument of input contains an integer C.
        The fourth argument of input contains an integer D.
        The fifth argument of input contains an integer E.
        The sixth argument of input contains an integer F.

        Output Format
        If it is possible to reach the destination point, return the minimum number of moves.
        Else return -1.

        Example Input
        Input 1:
        A = 8
        B = 8
        C = 1
        D = 1
        E = 8
        F = 8
        Input 2:
        A = 2
        B = 4
        C = 2
        D = 1
        E = 4
        F = 4

        Example Output
        Output 1:
        6
        Output 2:
        -1

        Example Explanation
        Explanation 1:
        The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight
        wants to reach position (8, 8).
        The minimum number of moves required for this is 6.
        Explanation 2:
        It is not possible to move knight to position (4, 4) from (2, 1)
*/

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {
    static class Node {
        int i, j, steps;

        Node(int i, int j, int steps) {
            this.i = i;
            this.j = j;
            this.steps = steps;
        }
    }

    public static int knight(int A, int B, int C, int D, int E, int F) {
        /*Source point= C,D Destination point=E,F Chess Board Size=A*B*/
        //Declare visited boolean value to check chess board visited or not
        boolean[][] visited = new boolean[A + 1][B + 1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(C, D, 0));
        visited[C][D] = true;

        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1 };

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.i;
            int y = node.j;
            int steps = node.steps;

            if (x == E && y == F) {
                return steps;
            }

            for (int k = 0; k < 8; k++) {
                int xx = x + dx[k];
                int yy = y + dy[k];

                if (xx >= 1 && xx <= A && yy >= 1 && yy <= B && !visited[xx][yy]) {
                    visited[xx][yy] = true;
                    q.add(new Node(xx, yy, steps + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int A = 8;
        int B = 8;
        int C = 1;
        int D = 1;
        int E = 8;
        int F = 8;
        System.out.println(knight(A, B, C, D, E, F));
    }
}



