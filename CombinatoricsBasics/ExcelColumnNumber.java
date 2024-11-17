package scaler.Adv.CombinatoricsBasics;

/*Problem Description
        Given a column title as appears in an Excel sheet, return its corresponding column number.

        Problem Constraints
        1 <= length of the column title <= 5

        Input Format
        The only argument is a string that represents the column title in the excel sheet.

        Output Format
        Return a single integer that represents the corresponding column number.

        Example Input
        Input 1:        AB
        Input 2:        BB

        Example Output
        Output 1:        28
        Output 2:        54

        Example Explanation
        Explanation 1:
        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28
        Explanation 2:
        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28
        ...
        AZ -> 52
        BA -> 53
        BB -> 54*/
public class ExcelColumnNumber {
    public static int titleToNumber(String A) {
        char[] c = A.toCharArray();
        int N = c.length - 1;
        int col = 0;
        for (int i = 0; i <= N; i++) {
            int charVal = ((int) (c[i] - 'A')) + 1; // calculate value of the character at the position
            int digVal = (int) Math.pow(26, N - i); // calculate power of the base(26) for that position
            col = col + (charVal * digVal); // Multiply the values to get value for that char in that digit and add it to the total(column no)
        }
        return col;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(titleToNumber("AB"));
    }
}
