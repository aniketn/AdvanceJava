package scaler.Adv.BackTrackingTwo;
/*Problem Description
        The n-queens puzzle is the problem of placing n queens on an n×n
        chessboard such that no two queens attack each other.

        Given an integer A, return all distinct solutions to the n-queens puzzle.

        Each solution contains a distinct board configuration of the n-queens'
        placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
        The final list should be generated in such a way that the indices of
        the queens in each list should be in reverse lexicographical order.

        Problem Constraints
        1 <= A <= 10

        Input Format
        First argument is an integer n denoting the size of chessboard

        Output Format
        Return an array consisting of all distinct solutions in which each element
        is a 2d char array representing a unique solution.

        Example Input
        Input 1:
        A = 4
        Input 2:
        A = 1

        Example Output
        Output 1:
        [
        [".Q..",  // Solution 1
        "...Q",
        "Q...",
        "..Q."],

        ["..Q.",  // Solution 2
        "Q...",
        "...Q",
        ".Q.."]
        ]
        Output 1:
        [
        [Q]
        ]

        Example Explanation
        Explanation 1:
        There exist only two distinct solutions to the 4-queens puzzle:
        Explanation 1:
        There exist only one distinct solutions to the 1-queens puzzle:*/

import java.util.ArrayList;

public class NQueens {
    public static boolean isSafe(int row, int col, char[][] board) {
        //horizonal
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        //Vertical
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //upper left
        int r = row;
        for (int c = col; c >= 0 && r >= 0; c--, r--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //upper right
        r = row;
        for (int c = col; c < board.length && r >= 0; r--, c++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //lower left
        r = row;
        for (int c = col; c >= 0 && r < board.length; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        //lower right
        for (int c = col; c < board.length && r < board.length; c++, r++) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void saveBoard(char[][] board, ArrayList<ArrayList<String>> allBoards) {
        String row = "";
        ArrayList<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q')
                    row += 'Q';
                else
                    row += '.';
            }
            newBoard.add(row);
        }

        allBoards.add(newBoard);
    }


    public static void helper(char[][] board, ArrayList<ArrayList<String>> allBoards, int col) {
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, allBoards, col + 1);
                board[row][col] = '.';
            }
        }
    }

    public static ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<ArrayList<String>> allBoards = new ArrayList<>();
        char[][] board = new char[A][A];
        helper(board, allBoards, 0);
        return allBoards;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> ans = solveNQueens(4);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
