package ojLeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet60 {
    public static void main(String[] args) {

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
        }
        return r;
    }

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
    }

}
