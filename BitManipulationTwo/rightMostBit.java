package scaler.Adv.BitManipulationTwo;

public class rightMostBit {
    public static int solve(int N) {
        return N & -N;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Integer.toBinaryString(solve(10)));
    }


}
