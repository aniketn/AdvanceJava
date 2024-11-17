package scaler.Adv.GraphTopologicalOrder;

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {
    static class Triplet {
        int row, col, steps;

        Triplet(int x, int y, int s) {
            row = y;
            col = x;
            steps = s;
        }
    }

    public static int knight(int A, int B, int C, int D, int E, int F) {

        //EIGHT DIRECTIONAL MOVEMENT OF KNIGHT
        int x[] = new int[]{1, 1, 2, 2, -1, -1, -2, -2};
        int y[] = new int[]{-2, 2, 1, -1, -2, 2, -1, 1};
        boolean visited[][] = new boolean[B + 1][A + 1];
        Queue<Triplet> queue = new LinkedList<>();

        //PUSHING THE SOURCE
        queue.add(new Triplet(C, D, 0));
        visited[D][C] = true;

        //INSERING THE SOURCE AND PULLING THE ELEMENT OUT ONE BY ONE.
        //FOR A PARTICULAR EXTRACTION GO 8 DIRECTIONAL CHECK.
        //REINSERT THE NEB WITH UPDATED STEP,UNTILL DESTINATION IS REACHED
        while (!queue.isEmpty()) {
            Triplet poll = queue.poll();
            if (poll.row == F && poll.col == E) return poll.steps;
            for (int i = 0; i < 8; i++) {
                int row = poll.row + y[i], col = poll.col + x[i];
                if (checkValidity(row, col, A, B, visited)) {
                    queue.add(new Triplet(col, row, poll.steps + 1));
                    visited[row][col] = true;
                }
            }
        }
        return -1;
    }

    //VALIDITY CHECK
    private static boolean checkValidity(int row, int col, int A, int B, boolean[][] visited) {
        if (row < 1 || col < 1 || row > B || col > A || visited[row][col]) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.print(knight(8, 8, 1, 1, 8, 8));
    }
}

