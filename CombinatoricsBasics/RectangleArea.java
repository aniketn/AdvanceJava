package scaler.Adv.CombinatoricsBasics;
/*Problem Description
        Given eight integers A, B, C, D, E, F, G, and H, which represent two rectangles in a 2D plane.
        For the first rectangle, its bottom left corner is (A, B), and the top right corner is (C, D), and
        for the second rectangle, its bottom left corner is (E, F), and the top right corner is (G, H).
        Find and return the overlapping area of the two rectangles.

        Problem Constraints
        -104 <= A <= C <= 104
        -104 <= B <= D <= 104
        -104 <= E <= G <= 104
        -104 <= F <= H <= 104

        Input Format
        The eight arguments given are the integers A, B, C, D, E, F, G and H.

        Output Format
        Return the overlapping area of the two rectangles.

        Example Input
        Input 1:
        A = 0   B = 0
        C = 4   D = 4
        E = 2   F = 2
        G = 6   H = 6
        Input 2:
        A = 0   B = 0
        C = 4   D = 4
        E = 2   F = 2
        G = 3   H = 3

        Example Output
        Output 1:        4
        Output 2:        1

        Example Explanation*/
public class RectangleArea {
    public static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(C<=E || G<=A || D<=F || H<=B){
            return 0;
        }else{
            int width = Math.min(C,G)-Math.max(A,E);
            int height = Math.min(H,D)-Math.max(B,F);

            return width*height;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve(0,0,4,4,2,2,6,6));
    }
}
