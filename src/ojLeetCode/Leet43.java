package ojLeetCode;

import java.util.*;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet43 {
    public static void main(String[] args) {
        String r = multiply("0","9133");
        System.out.println("mul : " + r);
    }

    public static String multiply(String num1, String num2) {
        char[] cs = num2.toCharArray();
        String temp = "";
        String result = "0";
        int n = cs.length;
        for (int i = n-1; i >=0 ; --i){
            temp = mul(num1,cs[i]-'0',n-i-1);
            result = add(temp,result);
        }
        return result;
    }

    public static String mul(String m1, int m2,int zeroNums) {
        if (m1.length() < 1) return "";
        char[] cm = m1.toCharArray();
        List<Integer> r = new LinkedList<Integer>();
        for (int i=0;i<zeroNums;++i)
            r.add(0,0);
        int over = 0;
        int t;
        for (int i = cm.length - 1; i >= 0; --i) {
            t = (cm[i] - '0') * m2 + over;
            if (t > 9) {
                r.add(0, t % 10);
                over = t / 10;
            } else {
                r.add(0, t);
                over = 0;
            }
        }
        if (over != 0)
            r.add(0, over);

        if (r.get(0) == 0)
            return "0";

        StringBuilder result = new StringBuilder("");
        for (int e : r) {
            result.append(e);
        }
        return result.toString();
    }

    public static String add(String m1, String m2) {
        char[] cm1 = m1.toCharArray();
        char[] cm2 = m2.toCharArray();
        List<Integer> r = new LinkedList<Integer>();
        int over = 0;
        int t;
        int i = cm1.length - 1, j = cm2.length - 1;
        while (i >= 0 || j >= 0) {
            t = over;
            if (i >= 0) t += (cm1[i] - '0');
            if (j >= 0) t += (cm2[j] - '0');
            if (t > 9) {
                r.add(0, t - 10);
                over = 1;
            } else {
                r.add(0, t);
                over = 0;
            }
            i--;
            j--;
        }
        if (over != 0)
            r.add(0, over);
        StringBuilder result = new StringBuilder("");
        for (int e : r) {
            result.append(e);
        }
        return result.toString();
    }
}
