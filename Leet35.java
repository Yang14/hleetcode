package ojLeetCode;

/**
 * Created by Mryang on 15-5-12.
 */
public class Leet35 {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6,9,11};
        int r = searchInsert(a, 0);
        System.out.println(r);
    }

    public static int searchInsert(int[] nums, int target) {
        int r = -2;
        int beg = 0, end = nums.length - 1, mid;
        while (beg <= end) {
//            System.out.println(beg + " " + end);
            //在二分法的基础上再加上这层判断目的在于，
            //如果t值比beg值大的话，至少t的位置比beg大一
            //如果小，将t插入后最多就在beg的位置上
            //如果相等，那就是后面的mid位置了
            //每一次循环都更新t的最终位置
            if (nums[beg] < target)
                r = beg + 1;
            else
                r = beg;
            mid = (beg + end) / 2;
            if (nums[mid] == target) {
                r = mid;
                break;
            } else if (nums[mid] < target)
                beg = mid + 1;
            else end = mid - 1;
        }
        return r;
    }
}
