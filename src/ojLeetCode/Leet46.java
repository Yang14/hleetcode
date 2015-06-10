package ojLeetCode;

import java.util.*;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet46 {
    public static void main(String[] args) {
        int[] a = {-1, -1,2};
        List<List<Integer>> r = permute(a);
        for (List<Integer> list : r) {
            for (int e : list) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        ArrayList<Integer> elem2 = new ArrayList<Integer>();
        permutation(nums, 0, r, elem2);
        return r;
    }

    public static void permutation(int[] nums, int begin, List<List<Integer>> r, List<Integer> elem) {
        if (begin == nums.length) {
            ArrayList<Integer> elem2 = (ArrayList<Integer>) ((ArrayList<Integer>) elem).clone();
            elem2.clear();
            for (int e : nums) {
                elem2.add(e);
            }
            r.add(elem2);
            return;
        }
        for (int i = begin; i < nums.length; ++i) {
            if (i > begin && nums[i] == nums[begin])
                continue;
            System.out.println("one"+"  " + i + " " + begin);
            swap(nums, i, begin);
            permutation(nums, begin + 1, r, elem);
            swap(nums, i, begin);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}
