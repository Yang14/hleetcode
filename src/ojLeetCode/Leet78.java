package ojLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet78 {
    public static void main(String[] args) {
        int[] nums = {4,1,0};
        List<List<Integer>> r = subsets(nums);
        for (List<Integer> list : r) {
            for (int e : list)
                System.out.print(e);
            System.out.println();
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> r = new ArrayList<List<Integer>>();
        List<Integer> sofa = new ArrayList<Integer>();
        List<Integer> remain = new ArrayList<Integer>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i)
            remain.add(nums[i]);

        subSet(sofa, remain, r);
        return r;
    }

    public static void subSet(List<Integer> sofa, List<Integer> remain, List<List<Integer>> r) {
        if (remain.size() == 0) {
                List<Integer> kNum = new ArrayList<Integer>(sofa);
                r.add(kNum);
            return;
        }

        int rnum = remain.get(0);
        remain.remove(0);
        List<Integer> remain2 = new ArrayList<Integer>(remain);
        subSet(sofa, remain, r);

        List<Integer> sofa2 = new ArrayList<Integer>(sofa);
        sofa2.add(rnum);

        subSet(sofa2, remain2, r);
    }

}
