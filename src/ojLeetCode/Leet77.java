package ojLeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet77 {
    public static void main(String[] args) {
        List<List<Integer>> r = combine(10, 2);
        for (List<Integer> list : r) {
            for (int e : list)
                System.out.print(e);
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        List<Integer> sofa = new ArrayList<Integer>();
        List<Integer> remain = new ArrayList<Integer>();
        for (int i = 1; i <= n; ++i)
            remain.add(i);

        subSet(sofa, remain, k, r);
        return r;
    }

    public static void subSet(List<Integer> sofa, List<Integer> remain, int k, List<List<Integer>> r) {
        if (remain.size() == 0) {
            if (sofa.size() == k) {
                List<Integer> kNum = new ArrayList<Integer>(sofa);
                r.add(kNum);
            }
            return;
        }

        int rnum = remain.get(0);
        remain.remove(0);
        List<Integer> remain2 = new ArrayList<Integer>(remain);
        subSet(sofa, remain, k, r);

        List<Integer> sofa2 = new ArrayList<Integer>(sofa);
        sofa2.add(rnum);

        subSet(sofa2, remain2, k, r);
    }

}
