package ojLeetCode;

import java.util.*;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet67 {
    public static void main(String[] args) {
        String r = add("11","11");
        System.out.println("add binary: " + r);
    }

    public static String add(String a, String b) {
        char[] cm1 = a.toCharArray();
        char[] cm2 = b.toCharArray();
        List<Integer> r = new LinkedList<Integer>();
        int over = 0;
        int t;
        int i = cm1.length - 1, j = cm2.length - 1;
        while (i >= 0 || j >= 0) {
            t = over;
            if (i >= 0) t += (cm1[i] - '0');
            if (j >= 0) t += (cm2[j] - '0');
            if (t > 1) {
                r.add(0, t%2);
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
