import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mryang on 15-5-15.
 */
public class Leet15 {

    public static void main(String[] args) {

//        int[] n = {-1, 0, 1, 2, -1, -4};
//        int[] n ={3,0,-2,-1,1,2} ;
//        int[] n = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
        int[] n = {1,1,1,1};
//        new Leet15().threeSum(n);
        new Leet15().threeSumClosest(n,0);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int realNum = 0;
        for (int i = 0; i < nums.length; ++i) {
            int a = nums[i] - target;
            int j=i+1;
            int k = nums.length-1;
            while (j<k){
                int b_c = nums[j] + nums[k];

                int sum = a + b_c;
                if(Math.abs(sum) < min){
                    min = Math.abs(sum);
                    realNum = sum;
                }
                if(sum == 0) j++;
                else if(sum > 0 ) k--;
                else j++;
            }
        }

        System.out.println("min sum:" + (realNum+target));
        return realNum+target;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rList = new ArrayList<List<Integer>>();
        if (nums.length < 3) return rList;
        List<Integer> tList;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1, k = nums.length - 1; nums[i] <= 0 && j < k; ) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }


                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    tList = new ArrayList<Integer>();
                    tList.add(nums[i]);
                    tList.add(nums[j]);
                    tList.add(nums[k]);
                    rList.add(tList);
                    j++;
                   /* for (int elem : tList)
                        System.out.print(elem + " ");*/
                    System.out.println();
                } else if (sum > 0) {
                    k--;
                } else j++;

            }

        }
        return rList;
    }
}
