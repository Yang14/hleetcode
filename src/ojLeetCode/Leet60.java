package ojLeetCode;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
=======
import java.util.*;
>>>>>>> d76c5311cfd65c2b66d8e76032ce56d9bf20ef95

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet60 {
    public static void main(String[] args) {
<<<<<<< HEAD

        String r = getPermutation(3, 6);

        System.out.println("% th per is : " + r);
    }

    public static String getPermutation(int n, int k) {
          return kThPermutationWithMath(n,k);
    }

    public static String kThPermutationWithMath(int n, int k) {
        int divide = fac(n-1);

        int[] num = new int[n];
        for (int i = 1; i <= n; ++i) num[i - 1] = i;

        String r = "";
        int k1 = k;
        while (n > 0 ){
            int count = fac(n-1);
            int a = (k1-1) / count;
            r+=num[a];
            n--;
            k1 = k1 % count;
=======
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
>>>>>>> d76c5311cfd65c2b66d8e76032ce56d9bf20ef95
        }
        return r;
    }

<<<<<<< HEAD
    public static int fac(int n){
        return n<=1? 1 : n* fac(n-1);
    }

    public static String permutation2(StringBuilder sofa, StringBuilder remain, int k, Map<String, Integer> hm) {
        if (remain.length() == 0) {
            if (hm.get("count") == k)
                return sofa.toString();
            hm.put("count", hm.get("count") + 1);
            return null;
        }
        for (int i = 0; i < remain.length(); ++i) {
            StringBuilder sofa2 = new StringBuilder(sofa).append(remain.charAt(i));
            StringBuilder remain2 = new StringBuilder(remain);
            remain2.deleteCharAt(i);
            String result = permutation2(sofa2, remain2, k, hm);
            if (result != null)
                return result;
        }
        return null;
=======
    public static int fac(int n) {
        return n <= 1 ? 1 : n * fac(n - 1);
>>>>>>> d76c5311cfd65c2b66d8e76032ce56d9bf20ef95
    }

}
