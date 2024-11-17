package scaler.Adv.BitManipulationOne;

/*Problem Description
        Write a function that takes an integer and returns the number of 1 bits it has.
        Problem Constraints
        1 <= A <= 109
        Input Format
        First and only argument contains integer A
        Output Format
        Return an integer as the answer
        Example Input
        Input 1:        11
        Input 2:        6

        Example Output
        Output 1:        3
        Output 2:        2

        Example Explanation
        Explaination 1:        11 is represented as 1011 in binary.
        Explaination 2:        6 is represented as 110 in binary.*/
public class NumberOfOneBits {
    public static int numSetBits(int A) {
        int countSetBit = 0;
        for (int i = 0; i < 32; i++) {
            if (((A >> i) & 1) == 1)
                countSetBit++;
        }
        return countSetBit;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int A = 21;
        System.out.println(numSetBits(A));
    }
}
