package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet198 {
    public static void main(String[] args) {
        int[] b = {10,20,9,30,50};
        int r = dpRobber(b);
        System.out.println("max money: " + r);
    }



    public static int dpRobber(int[] a) {
        int n = a.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; ++i)
            dp[i] = a[i];

        /*
        *dp(i) = { a[i] + max(dp(j)) , j < i-1 ;}
         * result = max(dp(i)), 0 <= i < n;
           *
           * init condition is : dp[i] = a[i];
        * */
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i - 1; ++j) {
                if (dp[j] + a[i] > dp[i]) {
                    dp[i] = dp[j] + a[i];
                }
            }
        }

        int max = 0;
        for (int e : dp)
            if(e > max)
                max = e;

        return max;
    }
}
