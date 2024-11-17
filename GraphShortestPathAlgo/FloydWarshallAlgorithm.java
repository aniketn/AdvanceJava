package scaler.Adv.GraphShortestPathAlgo;

public class FloydWarshallAlgorithm {
    static int[][] solve(int[][] A) {
        int n = A.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (A[i][k] != -1 && A[k][j] != -1) {
                        int newDistance = A[i][k] + A[k][j];
                        if (A[i][j] == -1 || A[i][j] > newDistance) {
                            A[i][j] = newDistance;
                        }
                    }
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] A = new int[][]{{0, 50, 39}, {-1, 0, 1}, {-1, 10, 0}};
        int[][] ans = solve(A);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.println(A[i][j]);
            }
        }
    }
}
