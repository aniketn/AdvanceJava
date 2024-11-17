package scaler.Adv.BitManipulationTwo;

/*Problem Description
        Given an integer A.
        Two numbers, X and Y, are defined as follows:

        X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
        Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
        Find and return the XOR of X and Y.

        NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
        NOTE 2: Your code will be run against a maximum of 100000 Test Cases.

        Problem Constraints
        1 <= A <= 109

        Input Format
        First and only argument is an integer A.

        Output Format
        Return an integer denoting the XOR of X and Y.

        Example Input
        A = 5
        Example Output
        10

        Example Explanation
        The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.*/
public class StrangeEquality {
    /*if A is lets say 4 i.e, 100 in binary, then the final answer
    in binary will be 1011, how? lets see
    a|b = a^b + a&b this is one of the properties which you can easily check,
    a+b = a|b + a&b  also one of the properties of bitwise addition.
    a+b = a^b + 2(a&b)  by substitution
    since a+b=a^b we get a&b=0 which means that all the bits are diff for a & b!
    similary a&c==0, but keep in mind c is greater than a which is only possible if there's an extra msb(most significant bit) in c when compared with a.*/
    public static int solve(int A) {
        int msb = 0;
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            if ((A & 1 << i) != 0)             //if the bit is set then we will unset that bit in ans
                msb = Math.max(msb, i);
            else if (msb != 0)  //make sure we have found  msb in A only then add set bits in our ans in place of unset bits of A
                ans += 1 << i;
        }
        ans += 1 << (msb + 1);  //incrementing our ans MSB by one
        return ans;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solve(5));
    }
}
