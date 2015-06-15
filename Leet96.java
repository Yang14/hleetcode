package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet96 {
    public static void main(String[] args) {
        int r = numTrees(5);
        System.out.println("trees num : " + r);
    }

    public static int numTrees(int n) {

        /*
        *1...n从小到大排好序，依次选1，2,3,...n做二叉搜索树的根节点
        *选1为根节点，则这棵树没有左子树，剩下的n-1个数构成搜索树的又子树
        *依次递归下去，可以写出下面的递归公式：
         * h[2] = h[0]*h[1] + h[1]*h[0]
          * ...
          * h[n] = h[0]h[n-1] + h[1]h[n-2] + ... + h[n-1]h[0]
          *初始条件：h[0] = h[1] = 1;0个或者1个结点的二叉搜索树只有一种形态
        * */

         int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; ++i)
            dp[i] = 0;

        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; ++j)
                dp[i] += dp[j] * dp[i - 1 - j];
        }

        return dp[n];
    }


}
