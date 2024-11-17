package scaler.Adv.BackTrackingTwo;

import java.util.ArrayList;

/*Problem Description
        Write a program to solve a Sudoku puzzle by filling the empty cells.
        Empty cells are indicated by the character '.'
        You may assume that there will be only one unique solution.

        A sudoku puzzle,
        the puzeel is not printed here, because it was image...

        and its solution numbers marked in red.

        Problem Constraints
        N = 9
        Input Format
        First argument is an array of array of characters representing the Sudoku puzzle.

        Output Format
        Modify the given input to the required answer.

        Example Input
        Input 1:
        A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]

        Example Output
        Output 1:
        [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]

        Example Explanation
        Explanation 1:
        Look at the diagrams given in the question.*/
public class Sudoku {
    public static boolean isSafe(char[][] board, int row, int col, int number) {
        //column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }
        }

        //row
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == (char) (number + '0')) {
                return false;
            }
        }

        //grid
        int sr = 3 * (row / 3);
        int sc = 3 * (col / 3);

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == (char) (number + '0')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean helper(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }

        int nrow = 0;
        int ncol = 0;

        if (col == board.length - 1) {
            nrow = row + 1;
            ncol = 0;
        } else {
            nrow = row;
            ncol = col + 1;
        }

        if (board[row][col] != '.') {
            if (helper(board, nrow, ncol)) {
                return true;
            }
        } else {

            //fill the place
            for (int i = 1; i <= 9; i++) {
                if (isSafe(board, row, col, i)) {
                    board[row][col] = (char) (i + '0');
                    if (helper(board, nrow, ncol))
                        return true;
                    else
                        board[row][col] = '.';
                }
            }
        }

        return false;
    }

    public static void solveSudoku(char[][] A) {
        helper(A, 0, 0);
    }

    public static void main(String[] args) {
        char[][] A = new char[][]{{(char) 53, '.', '.', (char) 7, '.', '.', '.', '.',}, {(char) 6, '.', '.', (char) 195, '.', '.', '.',}, {'.', (char) 98, '.', '.', '.', '.', (char) 6, '.',}, {(char) 8, '.', '.', '.', (char) 6, '.', '.', '.', 3}, {(char) 4, '.', '.', (char) 8, '.', (char) 3, '.', '.', (char) 1}, {(char) 7, '.', '.', '.', (char) 2, '.', '.', '.', (char) 6}, {'.', (char) 6, '.', '.', '.', '.', (char) 28, '.',}, {'.', '.', '.', (char) 419, '.', '.', (char) 5}, {'.', '.', '.', '.', (char) 8, '.', '.', (char) 79}};
        solveSudoku(A);
    }
}
