package scaler.Adv.GCD;
/*The time complexity of the above function assuming n>m is O(log(n)).
        The time complexity of an algorithm is a measure of how long it takes the algorithm to run as a function
        of the size of the input.In this case,the size of the input is represented by the values of n and m.

        The time complexity of the above function is O(log(n)),which means that the running time increases
        logarithmically with the value of n.This is because the function uses an iterative algorithm called
        the Euclidean algorithm to compute the GCD,which has a time complexity of O(log(n)).*/

public class TCofGCD {
    int gcd(int n, int m) {
        if (n % m == 0) return m;
        if (n < m) swap(n, m);
        while (m > 0) {
            n = n % m;
            swap(n, m);
        }
        return n;
    }

    public void swap(int a, int b) {

    }
}
