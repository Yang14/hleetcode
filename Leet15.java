package ojLeetCode;

import java.util.*;
import java.util.List;

/**
 * Created by Mryang on 15-5-15.
 */
public class Leet15 {

    public static void main(String[] args) {
        int[] nums = {7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6};
//        int[] nums = {3, 0, -2, -1, 1, 2};
        long s = System.currentTimeMillis();
        new Leet15().threeSum2(nums);
        long e = System.currentTimeMillis();
        System.out.println("hm used time is : " + (e - s));

        s = System.currentTimeMillis();
        new Leet15().threeSum(nums);
        e = System.currentTimeMillis();
        System.out.println("hm used time is : " + (e - s));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if (nums.length < 3) return rList;
        List<Integer> tList;
        Arrays.sort(nums);

        int b = 0, e = nums.length - 1;
        while (b < e) {
            for (int i = b + 1; i < e; ++i)
                if (nums[b] + nums[e] + nums[i] == 0) {
                    tList = new ArrayList<Integer>();
                    tList.add(nums[b]);
                    tList.add(nums[i]);
                    tList.add(nums[e]);
                    if (!rList.contains(tList)) {
//                        for (int elem : tList)
//                            System.out.print(elem + " ");
//                        System.out.println();
                        rList.add(tList);
                    }
                }
            if(Math.abs(nums[b]) > Math.abs(nums[e]) )
                b++;
            else e--;
        }
        return rList;
    }

    public static List<Integer> findNumIndex(int[] nums, int b, int e) {
        for (int i = b + 1; i < e; ++i)
            if (nums[b] + nums[e] == -nums[i]) {
                List<Integer> rList = new ArrayList<Integer>();
                rList.add(nums[b]);
                rList.add(nums[i]);
                rList.add(nums[e]);
//                Collections.sort(rList);
                return rList;
            }
        return null;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if (nums.length < 3) return rList;
        Map<Integer, Integer> numHm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            numHm.put(-nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums.length; ++j) {
                if (i == j) continue;
                int sub = -nums[i] - nums[j];
                if ((sub != nums[j]) && (sub != nums[i]) && numHm.get(sub) != null) {
                    List<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(nums[i]);
                    numHm.put(nums[i], null);
                    tempList.add(nums[j]);
                    numHm.put(nums[j], null);
                    tempList.add(sub);
                    numHm.put(sub, null);
                    Collections.sort(tempList);
                    rList.add(tempList);
                    for (int e : tempList)
                        System.out.print(e + " ");
                    System.out.println();
                    break;
                }
            }
        }
        return rList;
    }

}
