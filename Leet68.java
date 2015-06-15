package ojLeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mryang on 15-6-10.
 */
public class Leet68 {
    public static void main(String[] args) {
        String[] str = {"My","momma","always","said,","\"Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."};
        List<String> r = fullJustify(str, 20);
        for (String e : r)
            System.out.println(e);

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> r = new ArrayList<String>();
        int sumLen = 0, count = 0;
        Map<Integer, List<String>> hm = new HashMap<Integer, List<String>>();
        List<String> list1 = new ArrayList<String>();
        hm.put(count, list1);
        for (String e : words) {
            sumLen += e.length();
            if (sumLen > maxWidth) {
                sumLen = e.length() + 1;
                count++;
                List<String> list2 = new ArrayList<String>();
                list2.add(e);
                hm.put(count, list2);
            } else {
                sumLen++;
                hm.get(count).add(e);
            }
        }
        for (int i = 0; i <= count; ++i) {
            List<String> list = hm.get(i);
            int len = maxWidth - listStringLen(list);
            int listCount = list.size() - 1;
            int j = 0;
            String rStr = "";
            System.out.println(i+" " +count);
            if ((i == count) ) {
                for (String e : list) {
                    rStr += e + " ";
                }
                rStr = rStr.substring(0, rStr.length() - 1);
                int coe = maxWidth - rStr.length();
                for (int k = 0; k < coe; k++)
                    rStr += " ";
            } else
            {
                for (String e : list) {
                    if (j == 0) {
                        rStr += e;
                        if (list.size() == 1) {
                            for (int k = 0; k < maxWidth - e.length(); k++)
                                rStr += " ";
                        }
                    } else {
                        int em = fixEmptyNum(len, listCount, j);
                        //System.out.println(em +" " + len +" " + listCount +" " + j);
                        for (int k = 0; k < em; k++)
                            rStr += " ";
                        rStr += e;
                    }
                    j++;
                }
            }
            r.add(rStr);
        }
        return r;
    }

    public static int listStringLen(List<String> list) {
        int len = 0;
        for (String e : list)
            len += e.length();
        return len;
    }

    public static int fixEmptyNum(int em, int c, int i) {
        int t;
        do {
            t = em / c;
            if (c == i)
                break;
            em -= t;
            c--;
        } while (c > 0);

        return t;
    }
}
