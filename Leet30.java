package ojLeetCode;

import java.util.*;

/**
 * Created by Mryang on 15-5-27.
 */
public class Leet30 {

    public static void main(String[] args) {
        String tar = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
//        String tar = "aaaaaa";
        String[] m = {"dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "cila", "tfty", "modg", "ztjg", "ybty", "heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw", "bxcb"};
//        String[] m = {"aa"};
        List<Integer> r = findSubstring(tar, m);
        for (int e : r)
            System.out.print(e + " ");
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<Integer>();
        Map<String, Integer> hm = new HashMap<String, Integer>();
        Map<String, Integer> tempHm;
        for (String e : words) {
            if (hm.get(e) == null)
                hm.put(e, 1);
            else hm.put(e, hm.get(e) + 1);
        }

        int wLen = words[0].length();
        int n = words.length;
        int wLens = n * wLen;
        int iLen = s.length() - wLens;
        int jLen = wLens - wLen;

        for (int i = 0; i <= iLen; i++) {

            tempHm = new HashMap<String, Integer>(hm);

            for (int j = i; j <= i + jLen; j += wLen) {
                String tmp = s.substring(j, j + wLen);
                if (tempHm.get(tmp) == null || tempHm.get(tmp) <= 0)
                    break;

                if (tempHm.get(tmp) > 0)
                    tempHm.put(tmp, tempHm.get(tmp) - 1);

                if (j == i + jLen) {
                    result.add(i);
                }
            }

        }

        return result;
    }

    public static List<Integer> findSubstring4(String s, String[] words) {
        List<Integer> result = new LinkedList<Integer>();
        Map<String, Integer> hm = new HashMap<String, Integer>();
        Map<String, Integer> tempHm;
        for (String e : words) {
            if (hm.get(e) == null)
                hm.put(e, 1);
            else hm.put(e, hm.get(e) + 1);
        }
//        for (String e : words) {
//            System.out.print(e + " " + hm.get(e) + " " + hm.size() + " ");
//        }        System.out.println();

        int wLen = words[0].length();
        int count = 0;
        tempHm = new HashMap<String, Integer>(hm);

        for (int i = 0; i <= wLen + 1; i++)
            for (int j = i; ((words.length - count) * wLen <= (s.length() - j)); j += wLen) {
                String tmp = s.substring(j, j + wLen);
                System.out.println("tmp: " + tmp + " " + j + " " + i);
                if (tempHm.get(tmp) != null && tempHm.get(tmp) > 0) {
                    count++;
                    tempHm.put(tmp, tempHm.get(tmp) - 1);
                    if (count == words.length) {
                        System.out.println("idx: " + j + " " + i + " ");
                        result.add(j - (words.length - 1) * wLen);
                        tempHm = new HashMap<String, Integer>(hm);
                        count = 0;
                    }
                } else {
                    tempHm = new HashMap<String, Integer>(hm);
                    count = 0;
                }
            }
        return result;
    }

    public static List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> result = new LinkedList<Integer>();
        Map<String, ArrayList<Integer>> sn = new HashMap<String, ArrayList<Integer>>();
        Map<Integer, String> ns = new HashMap<Integer, String>();
        int idx;
        String temp = s;
        for (String e : words) {
            sn.put(e, new ArrayList<Integer>());
            idx = 0;
            do {
                idx = s.indexOf(e, idx);
                if (idx == -1)
                    break;
                ns.put(idx, e);
                sn.get(e).add(idx + e.length());
                idx++;
            } while (true);
        }

        for (String e : words) {
            for (int i : sn.get(e))
                System.out.print(i + " " + e);
            System.out.println();
        }
        for (int i = 0; i < s.length(); ++i) {
            if (ns.get(i) != null)
                System.out.println(i + " " + ns.get(i++));
        }

        for (String e : words) {
//            System.out.println(e);
            for (int i : sn.get(e)) {
                if (recure(words.length - 1, i, sn, ns)) {
                    result.add(i - e.length());
//                    System.out.println("---" +( i-e.length()));
                }
            }
        }
        return result;
    }

    public static boolean recure(int count, int num, Map<String, ArrayList<Integer>> sn, Map<Integer, String> ns) {
//        System.out.println("recu parms : " + num + " " + count);
        if (count == 0)
            return true;
        if (count != 0 && ns.get(num) == null) return false;

        String str = ns.get(num);
//        System.out.println("recu: " + str +" " + num);
        for (int num2 : sn.get(str)) {
            return recure(count - 1, num2, sn, ns);
        }
        return false;
    }

    public static List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> sofar = new LinkedList<Integer>();
        List<Integer> remain = new LinkedList<Integer>();
        List<Integer> result = new LinkedList<Integer>();
        List<List<Integer>> reset = new LinkedList<List<Integer>>();
        for (int i = 0; i < words.length; ++i) {
//全排列之前将单个单词就不匹配的字符串剔除，然后进行全排列，从结果上看效果不好，只去掉了一个
//十几个数的全排列时间太长，提交就是TLE错误
            if (s.indexOf(words[i]) != -1)
                remain.add(i);
        }

        permutation(sofar, remain, reset);

        for (List<Integer> e : reset) {
            String cbmStr = "";
            for (int elem : e)
                cbmStr += words[elem];
            System.out.println(cbmStr);
            result.add(s.indexOf(cbmStr));
        }
        return result;
    }

    public static void permutation(List<Integer> sofar, List<Integer> remain, List<List<Integer>> result) {
        if (remain.size() == 0) {
            for (int e : sofar) {
                System.out.print(e + " ");
            }
            System.out.println();
            result.add(sofar);
            return;
        }

        for (int i = 0; i < remain.size(); ++i) {
            List<Integer> sofar2 = new LinkedList<Integer>();
            List<Integer> remain2 = new LinkedList<Integer>();
            for (int e : sofar) {
                sofar2.add(e);
            }
            sofar2.add(remain.get(i));
            for (int e : remain) {
                remain2.add(e);
            }
            remain2.remove(i);
            permutation(sofar2, remain2, result);
        }

    }
}
