package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet55 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
//        int[] nums = {3,2,1,0,4};
        boolean result = canJump(nums);
        System.out.println(result);
    }

    public static void printMaxActivities(int[] start, int[] finish) {
        int i, j;
        i = 0;
        System.out.print(i + " ");

        for (j = 1; j < finish.length; ++j) {
            if (start[j] >= finish[i]){
                System.out.print(j + " ");
                i = j;
            }
        }
    }

    public static boolean canJump(int[] nums) {
        //贪心法
        //we can make a choice that looks best at the moment,
        // and we get the optimal solution of the complete problem.

        //第一步是从0开始，这是由题目指定
        //第二步选择的起跳点是，第一步能跳到的范围内能跳最远的
        //。。。
        //选择下一步起跳点的依据是：
        //选择上一步能跳的范围内能跳的最远作为起点

        //计算每一步能跳的最远距离，就是 当前下标 + 步长
        for (int i=0;i<nums.length;++i)
            nums[i] = nums[i] + i;

        //从0开始，如果下标已经超过 len - 1表示能够
        //若获取不到最大值==-1了就不能到
        int j = 0;
        while ( j < nums.length){
            if (nums[j] >= nums.length-1)
                return true;
            j = getRangeMax(nums,j+1,nums[j]);
            if (j == -1)
                break;
        }
        return false;
    }

    public static int getRangeMax(int[] nums ,int s,int e){
        int max = -1,index = -1;
        for (int i=s;i<=e && i < nums.length;i++)
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        return index;
    }

}
