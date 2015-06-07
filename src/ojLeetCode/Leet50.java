package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet50 {
    public static void main(String[] args) {
        double r = myPow(2, 0);
        System.out.println("pow: " + r);
    }

    public static double myPow(double x, int n) {
        if (x == 0) return 0;
        int flag = n > 0 ? 1 : -1;
        n = n > 0 ? n : -n;

        double r = rescPow(x, n);
        return flag > 0 ? r : 1 / r;

    }

    public static double rescPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double r = rescPow(x, n / 2);
        r *= r;
        if (n % 2 != 0)
            r *= x;
        return r;
    }

    public static double myAbsPow(double x, int n) {
        double result = 1;
        for (int i = 0; i < n; i++)
            result *= x;
        return result;
    }

}
