package ojLeetCode;

/**
 * Created by Mryang on 15-5-12.
 */
public class Leet33 {

    public static void main(String[] args) {
        int[] a = {1};
        int r = search(a, 0);
        System.out.println(r);
    }
    public static int binSearch(int[] nums,int beg,int end, int target) {
        int mid;
        while (beg <= end) {
            mid = (beg + end) / 2;
            if (nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                beg = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int divide = -1;
        int r = -1;
        int beg = 0, end = nums.length - 1, mid;
        if (nums[beg] <= nums[end])
            divide = 0;
        else
            while (nums[beg] > nums[end]) {
                if (beg == end - 1){
                    divide = end;
                    break;
                }
                mid = (beg + end) / 2;
                if (nums[mid] > nums[nums.length - 1])
                    beg = mid;
                else end = mid;
            }

        r = binSearch(nums,0,divide-1,target);
        if(r == -1)
            r = binSearch(nums,divide,nums.length-1,target);
        return r;
    }
}
