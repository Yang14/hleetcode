package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet81 {
    public static void main(String[] args) {
        int[] a = {1, 0, 1, 1, 1};
        boolean r = search(a, 1);
        System.out.println("search result: " + r);
    }

    public static int binSearch(int[] nums, int beg, int end, int target) {
        int mid;
        while (beg <= end) {
            mid = (beg + end) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                beg = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static boolean search(int[] nums, int target) {
        int divide = -1;
        int r = -1;
        int beg = 0, end = nums.length - 1, mid;
        if (nums[beg] < nums[end])
            divide = 0;
        else
            while (nums[beg] >= nums[end]) {
                if (beg == end - 1) {
                    divide = end;
                    break;
                }
                mid = (beg + end) / 2;
                if (nums[beg] == nums[mid] && nums[end] == nums[mid])
                    return normalSearch(nums, target);

                if (nums[mid] > nums[end])
                    beg = mid;
                else end = mid;
            }
        r = binSearch(nums, 0, divide - 1, target);
        if (r == -1)
            r = binSearch(nums, divide, nums.length - 1, target);
        return r == -1 ? false : true;
    }

    public static boolean normalSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] == target)
                return true;
        return false;
    }

}
