package ojLeetCode;

import java.util.*;

/**
 * Created by Mryang on 15-5-27.
 */
public class Leet30 {

    public static void main(String[] args) {
        String tar = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String[] m = {"dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "cila", "tfty", "modg", "ztjg", "ybty", "heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw", "bxcb"};
        List<Integer> r = findSubstring(tar, m);
        for (int e : r)
            System.out.print(e + " ");
    }

    public static List<Integer> findSubstring(String s, String[] words) {
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
