package scaler.Adv.Greedy;

public class MathFunctiono {
    public static void main(String args[])
    {
        double a = 47.0;
        double b = 1.0 / 0;
        double c = 0, d = 145.256;

        // negative integer as argument, output NAN
        System.out.println(Math.log(a));

        // positive infinity as argument, output Infinity
        System.out.println(Math.log(5.0));

        // positive zero as argument, output -Infinity
        System.out.println(Math.floor(2.40));

        // positive double as argument
        System.out.println(Math.log(d));
    }


}
