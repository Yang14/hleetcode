package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet75 {
    public static void main(String[] args) {
//        int[] colors = {2, 0, 2, 2, 0, 1, 1, 1};
        int[] colors = {1,2,0,0,2};
        sortColors(colors);
        for (int e : colors)
            System.out.print(e + " ");
    }

    public static void sortColors(int[] nums) {
        //0在最前面，扫描到就直接往最前交换,并更新下一次交换0的位置
        //2在最后面，扫描到就直接往最后交换
        //遇到2还需要注意：2向后交换过来的数据可能是1，也可能是0
        //如果是1到没关系，但如果是0，0有可能还要往前调整位置
        //所以遇到0，遍历指针原地不动，i--；
        //另外，遇到2能调整的条件还有 i < end
        //如果 > 说明2已经全部在正确的位置上

        int beg, end,i, temp;
        beg=0;
        end = nums.length-1;
        for (i=0;i<nums.length;++i){
            if (nums[i] == 0){
                temp = nums[beg];
                nums[beg] = nums[i];
                nums[i] = temp;
                beg++;
            }else if (nums[i] == 2 && i < end){
                temp = nums[end];
                nums[end] = nums[i];
                nums[i] = temp;
                i--;    //交换的是0或是1，遍历指针i都保持不变
                end--;
            }
        }
    }

}
