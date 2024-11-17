package scaler.Adv.BitManipulationOne;

/*Problem Description
        Divide two integers without using multiplication, division and mod operator.
        Return the floor of the result of the division.
        Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
        NOTE: INT_MAX = 2^31 - 1

        Problem Constraints
        -231 <= A, B <= 231-1
        B != 0
        Input Format
        The first argument is an integer A denoting the dividend.
        The second argument is an integer B denoting the divisor.

        Output Format
        Return an integer denoting the floor value of the division.

        Example Input
        Input 1:
        A = 5
        B = 2
        Input 2:
        A = 7
        B = 1

        Example Output
        Output 1:        2
        Output 2:        7

        Example Explanation
        Explanation 1:
        floor(5/2) = 2*/
public class DivideIntegers {
    public static int divide(int A, int B) {
        //method
        // A/B => 125/5 ==>
        // 125 = 5*25 ==> 5 * ( 2^4 * (1) + 2^3 * (1) + 2^2* (0) + 2^1 * (0)+ 2^0 * (1) );
        boolean sign = (A < 0) ^ (B < 0);
        long answer = 0L;
        long tempA = Math.abs(A * 1L);
        long tempB = Math.abs(B * 1L);

        for (int i = 31; i >= 0; i--) {
            long power = (long) tempB << i;
            while (power <= tempA) {
                tempA -= power;
                answer += (1L << i);
            }
        }
        if (answer >= Integer.MAX_VALUE)
            return (sign ? -Integer.MIN_VALUE : Integer.MAX_VALUE);
        if (sign)
            return (int) answer * -1;
        return (int) answer;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println(divide(5,2));
    }
}
