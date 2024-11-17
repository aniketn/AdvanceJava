package scaler.Adv.GCD;

/*Problem Description
        Scooby has 3 three integers A, B, and C.
        Scooby calls a positive integer special if it is divisible by B and it is divisible by C.
        You need to tell the number of special integers less than or equal to A.

        Problem Constraints
        1 <= A, B, C <= 109

        Input Format
        First argument is a positive integer A
        Second argument is a positive integer B
        Third argument is a positive integer C

        Output Format
        One integer corresponding to the number of special integers less than or equal to A.

        Example Input
        Input 1:
        A = 12
        B = 3
        C = 2
        Input 2:
        A = 6
        B = 1
        C = 4

        Example Output
        Output 1:        2
        Output 2:        1

        Example Explanation
        Explanation 1:
        The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.
        Explanation 2:
        Only 4 is a positive integer less than equal to 6 which is divisible by 1 and 4.*/
public class DivisorGame {
    public static int solve(int A, int B, int C) {
        //LCM(B,C) = B*C/GCD(B,C);
        int GCD = B > C ? EuclidianGCD(B, C) : EuclidianGCD(C, B);
        int LCM = B * C / GCD;
        return A / LCM;
    }

    public static int EuclidianGCD(int A, int B) {
        return B == 0 ? A : EuclidianGCD(B, A % B);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve(12, 3, 2));

    }

}
