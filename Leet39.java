package ojLeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by Mryang on 15-5-12.
 */
public class Leet39 {

    public static void main(String[] args) {
        int[] a = {1,2};
        List<List<Integer>> r = combinationSum(a, 3);
        for (List<Integer> l : r) {
            for (int e : l)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] a, int target) {
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        if (a.length < 1) return null;
        List<Integer> closet = new Stack<Integer>();
        calSet(a,closet,target,r,0);
        return r;
    }


    public static void calSet(int[] nums, List<Integer> closet,int target,List<List<Integer>> r,int start) {

        for (int i=start;i<nums.length;++i){
            int e = nums[i];
            if(e == target){
               closet.add(0,e);
               List<Integer> result = new ArrayList<Integer>(closet);
               Collections.sort(result);
               r.add(result);
               closet.remove(0);
            }
            else if( e < target){
                closet.add(0,e);
                calSet(nums, closet, target - e, r,i);
                closet.remove(0);
            }
        }
    }

    public static int getListSum(List<Integer> list) {
        int sum = 0;
        for (int e : list){
            sum += e;
        }
        return sum;
    }

    public static List<List<Integer>> combinationSum2(int[] a, int target) {
        //只能完成有序数组中和等于target的数字集合
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        if (a.length < 1) return null;

        int beg = 0, end = 0;
        int sum = a[0];

        while (beg <= end && end < a.length) {
            if (sum == target) {
                List<Integer> cl = new ArrayList<Integer>();
                for (int i = beg; i <= end; ++i)
                    cl.add(a[i]);
                r.add(cl);
            }
            if (sum < target) {
                end++;
                sum += a[end];
            } else {
                sum -= a[beg];
                beg++;
            }
        }
        return r;
    }
}
