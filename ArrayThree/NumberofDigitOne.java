package scaler.Adv.ArrayThree;

/*Problem Description
        Given an integer A, find and return the total number of digit 1 appearing in all non-negative integers
         less than or equal to A.

        Problem Constraints
        0 <= A <= 109

        Input Format
        The only argument given is the integer A.

        Output Format
        Return the total number of digit 1 appearing in all non-negative integers less than or equal to A.

        Example Input
        Input 1:        A = 10
        Input 2:        A = 11

        Example Output
        Output 1:        2
        Output 2:        4

        Example Explanation
        Explanation 1:        Digit 1 appears in 1 and 10 only and appears one time in each. So the answer is 2.
        Explanation 2:        Digit 1 appears in 1(1 time) , 10(1 time) and 11(2 times) only. So the answer is 4.*/
public class NumberofDigitOne {
   /* Theory:
            1. Find the contribution of 1 for each places eg. for unit,tenth,hundredth ... places.
2. Add all the contributions
    eg:
    Unit place:
            0-9, 10-19, 20-29,30-39 => 1 after every 10 digit

    Tenth Place:
            00-99(10-19)  , 100-199, 200-299, 300-399 => 10 after every 100 digits

    eg: 235
    Unit place:
    ans += (235/10)*1 + (235%10)>1? 1 : (235%10)>0? 1:0

    Tenth Place:
    ans += (235/100)*10+ (235%100)>19? 10 : (235%100)>9? 35-9:0

    Hundred Place:
    ans += (235/1000)*100+ (235%1000)>199? 100 : (235%1000)>99? 235-99:0*/

    public static int solve(int A) {
        int n = A, factors = 1, count = 0, remainder = 0;
        while (n > 0) {
            int temp = factors;
            // check for remainders three cases mentioned in
            // the approach
            if (n % 10 == 0) {
                remainder = 0;
            } else if (n % 10 > 1) {
                remainder = temp;
            } else if (n % 10 == 1) {
                remainder = (A % temp) + 1;
            }
            factors *= 10; // increamneting factors for checking
            // different locations such as ones,
            // tens,hundreds places ones
            count += (A / factors) * temp + remainder;
            n = n / 10;
        }
        return count;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int A = 235;
        System.out.println(solve(A));
    }
}
