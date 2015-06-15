package ojLeetCode;

/**
 * Created by Mryang on 15-5-12.
 */
public class Leet41 {

    public static void main(String[] args) {
        int[] a = {1,2,3,6,8};
        int r = firstMissingPositive(a);
        System.out.println(r);
    }

    public static int firstMissingPositive(int[] nums) {

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;
        for (int e : nums) {
            if (e > 0 && e < min)
                min = e;
            if (e > max)
                max = e;
            if (e > 0)
                sum += e;
        }
        if (min == Integer.MAX_VALUE || min > 1) return 1;

        int calSum = (int) ((1 + max) * (max) * 1.0 / 2);
        System.out.println(min +" "+max +" "+sum +" " + calSum);
        return ((calSum - sum) == 0) ? max + 1 : (calSum - sum);
    }


}
