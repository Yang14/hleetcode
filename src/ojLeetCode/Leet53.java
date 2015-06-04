package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet53 {
    public static void main(String[] args) {
//        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        int[] a = {-2,-1};
        int r = maxSubArray(a);
        System.out.println("max sub array : " + r);
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        for (int i = 1; i < n; ++i){
//            if (dp[i-1] < 0)
//                continue;
//            dp[i] = nums[i] + dp[i-1];
            dp[i] = Math.max(0,dp[i-1]) + nums[i];
            //System.out.println(dp[i] + " " + i);
        }

        int max =  Integer.MIN_VALUE;
        for (int e:dp)
            if (e > max)
                max = e;
        return max;
    }
}
