package ojLeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Mryang on 15-5-14.
 */
public class Leet12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
        romanToInt("MMCDXXV");
    }

    public static String intToRoman(int num) {
        String[][] roNum = {
                {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"M", "MM", "MMM"}
        };

        int x = 0;
        int count = 0;
        LinkedList<String> rmList = new LinkedList<String>();
        while (num != 0) {
            x = num % 10;
            num = num / 10;
            if (x != 0)
                rmList.add(0, roNum[count][x - 1]);
            count++;
        }
        String result = "";
        for (String s : rmList)
            result += s;
        return result;
    }

    public static int romanToInt2(String s) {
        String[][] roNum = {
                {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"M", "MM", "MMM"}
        };

        Map<String, Integer> roNumHm = new HashMap<String, Integer>();
        for (int i = 0; i < roNum.length; ++i)
            for (int j = 0; j < roNum[i].length; ++j)
                roNumHm.put(roNum[i][j], (j + 1) * (int) (Math.pow(10, i)));

        int bg = 0;
        int max = -1;
        int tempMax = 0;
        String r = "";
        for (int i = 1; i < s.length() + 1; ++i) {
            String tmpStr = s.substring(bg, i);
            System.out.println(tmpStr);
            if (roNumHm.get(tmpStr) != null) {
                int tmp = roNumHm.get(tmpStr);
                System.out.println(tmp);
                if (tmp > max) {
                    max = tmp;
                }
            } else {
                bg = --i;
                tempMax += max;
                max = -1;
            }
        }
        if (max != -1)
            tempMax += max;
        System.out.println(tempMax);

        return 0;
    }

    public static int romanToInt(String s) {
        String[][] roNum = {
                {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"M", "MM", "MMM"}
        };

        Map<String, Integer> roNumHm = new HashMap<String, Integer>();
        for (int i = 0; i < roNum.length; ++i)
            for (int j = 0; j < roNum[i].length; ++j)
                roNumHm.put(roNum[i][j], (j + 1) * (int) (Math.pow(10, i)));

        int[] idx = new int[4];
        String[] idxStr = {"I", "V", "X", "L", "C", "D", "M", "M"};
        for (int i = 0, k = 0; i < 4 && k < 8; i++, k += 2) {
            int one = s.indexOf(idxStr[k]);
            int two = s.indexOf(idxStr[k + 1]);
            if (one != -1 && two != -1) idx[i] = one > two ? two : one;
            else idx[i] = one == -1 ? two : one;
            if (i > 0 && idx[i - 1] != -1 && idx[i] > idx[i - 1]) {
                idx[i] = -1;
            }
        }
        System.out.println(s);
        for (int e : idx)
            System.out.println(e + " ");

        int ed = s.length();
        int retMax = 0;
        for (int i = 0; i < 4; ++i) {
            if (idx[i] == -1)
                continue;
            String tmp = s.substring(idx[i], ed);
            retMax += roNumHm.get(tmp);
            ed = idx[i];
            System.out.println(tmp + " " + retMax);

        }
//MCMXCVI
        return retMax;
    }

}
