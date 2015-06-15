package ojLeetCode;

/**
 * Created by Mryang on 15-5-12.
 */
public class Leet34 {

    public static void main(String[] args) {
        int[] a = {1};
        int[] r = searchRange(a, 1);
        System.out.println(r[0] + " " + r[1]);

    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length < 1) return result;

        int beg = 0, end = nums.length - 1, mid;
        while (beg <= end) {
            mid = (beg + end) / 2;
            if (nums[mid] == target) {
                if (mid == 0 || (mid > 0 && nums[mid] != nums[mid - 1])) {
                    result[0] = mid;
                    break;
                } else
                    end = mid - 1;
            } else if (nums[mid] < target) {
                beg = mid + 1;
            } else
                end = mid - 1;
        }
        beg = 0;
        end = nums.length - 1;
        while (beg <= end) {
            mid = (beg + end) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1 || (mid < nums.length - 1 && nums[mid] != nums[mid + 1])) {
                    result[1] = mid;
                    break;
                } else
                    beg = mid + 1;
            } else if (nums[mid] < target) {
                beg = mid + 1;
            } else
                end = mid - 1;
        }
        return result;
    }
}
