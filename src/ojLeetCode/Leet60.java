package ojLeetCode;

import java.util.*;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet60 {
    public static void main(String[] args) {
        String r;
        for (int i = 1; i < 7; ++i) {
            r = getPermutation(4, i);
            System.out.println("per: " + r);
        }
    }

    public static String getPermutation(int n, int k) {
        //数学方法做的这道题
        //采用全排列的方法计算会超时（TLE）

        //思路：计算第k步后，每个数应该在的位置
        /*
        *规律：
         * k = k - 1;
         * a1 = num[k/(n-1)!]
         * a1计算好，a2=走完a1的k步后还剩下的步骤
         * k = k % (n-1)!
         * 计算a2只有在剩下的n-2个数中映射了，a1所表示的值要被弹出！
         * a2 = num[k / (n-2)!]
         * 当最新的k==0时，再计算会一直取[0]上的值
         * 此时需要特殊处理，因为后面的没有进行交换，
         * 直接将num中剩下的元素按顺序添加到结果集中。
        * */
        String r = "";
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i)
            nums.add(i + 1);
        k--;
        int div = fac(n - 1);
        while (n > 0) {
            int idx = k / div;
            r += nums.get(idx);
            nums.remove(idx);
            k = k % div;
            if (k == 0) {   //后面的数据没有交换过，直接加入结果集
                for (int e : nums)
                    r += e;
                break;
            }
            n--;
            div = div / n;  //技巧：直接利用n!的性质，(n-1)! = n!/(n-1),避免了重复计算fac.
        }
        return r;
    }

    public static int fac(int n) {
        return n <= 1 ? 1 : n * fac(n - 1);
    }

}
