package ojLeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet76 {
    public static void main(String[] args) {
        String s = "bdab";
        String t = "ab";
        String r = minWindow(s, t);
        System.out.println("min window: " + r);
    }

    public static String minWindow(String s, String t) {
        String r = "";

        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        for (char e : ct)
            if (hm.get(e) == null) hm.put(e, 1);
            else hm.put(e, hm.get(e) + 1);

        int beg = 0, end = -1, min = cs.length + 1, sum = ct.length, count = 0;

        int i = 0, j = 0;
        while (j < cs.length) {
            System.out.println(j);
            if (hm.get(cs[j]) != null && hm.get(cs[j]) > 0) {
                hm.put(cs[j], hm.get(cs[j]) - 1);
                if (count == 0) i = j;
                count++;
                if (sum == count && (j - i) < min) {
                    System.out.println(i + " " + j);
                    min = j - i;
                    beg = i;
                    end = j;
                    count = 0;
                }
            } else if (hm.get(cs[j]) != null) {
                while ((i <= j && hm.get(cs[j]) <= 0) || hm.get(cs[i]) == null) {
                    if (hm.get(cs[i]) != null && hm.get(cs[i]) <= 0) {
                        hm.put(cs[j], hm.get(cs[j]) + 1);
                    }
                    i++;
                }
                System.out.println("i " + i);
                j--;
            }
            j++;
        }

        return s.substring(beg, end + 1);
    }
}
