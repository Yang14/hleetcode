package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet70 {
    public static void main(String[] args) {
        int r = climbStairs(1);
        System.out.println("using dp: " + r);
    }

    public static int climbStairs(int n) {
        if( n <= 1) return 1;
        int[] f = new int[n+1];
        f[1] = 1;
        f[2] = 2;
        for (int i=3;i<=n;++i)
            f[i] = f[i-1] + f[i-2];
        return f[n];
    }

}
