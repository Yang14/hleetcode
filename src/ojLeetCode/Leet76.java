package ojLeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet76 {
    public static void main(String[] args) {
        String s = "bbaa";
        String t = "aba";
        String r = minWindow(s, t);
        System.out.print("min window :" + r);
    }

    public static String minWindow(String s, String t) {
        String r = "";

        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        for (char e : ct)
            if (hm.get(e) == null) hm.put(e, 1);
            else hm.put(e, hm.get(e) + 1);

        int beg = 0, end = 0, max = -1, sum = ct.length;

        int i = 0, j = 0;
        while (j < cs.length) {
            System.out.println(j);
            if (hm.get(cs[j]) != null && hm.get(cs[j]) >= 0) {
                if (sum == 0 && (j - i) > max) {
                    max = j - i;
                    beg = i;
                    end = j;
                } else {
                    hm.put(cs[j], hm.get(cs[j]) - 1);
                    sum--;
                }
            } else {
                while (i <= j) {
                    if (hm.get(cs[i]) != null && hm.get(cs[i]) == 0) {
                        sum++;
                        hm.put(cs[j], hm.get(cs[j]) + 1);
                        j--;
                        break;
                    }
                    i++;
                }
            }
            j++;

        }


        return s.substring(beg, end + 1);
    }

}
