package ojLeetCode;

/**
 * Created by Mryang on 15-5-27.
 */
public class Leet26 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int r = removeDuplicates(nums);
        for (int e : nums) {
            System.out.print(e + " ");
        }
        System.out.println("   len:" + r);
    }

    public static int removeDuplicates(int[] a) {
        if (a == null || a.length < 1) return 0;
//运用快排的partition思路，前面的指针i指向已经替换完成的数，
//i+1指向的数可以被任何数替换掉，j找到的满足的数才替换，i和j之间的数都是不满足的可以被替换
//后指针j指向正在判断是否能去替换i+1的数，
//若[j] != [i]    就可以替换，否则j继续寻找。
//比较不好理解，不过通过几个实际例子走一遍就差不多了
        int i = 0, x = a[0];
        for (int j = 0; j < a.length; ++j) {
            if (a[j] != x) {
                i++;
                a[i] = a[j];
                x = a[j];
            }
        }
        return i + 1;
    }

    public static int removeDuplicates2(int[] a) {
        if (a == null || a.length < 1) return 0;
        int result = 0;
        int na = a[0] - 1;
        int x = a[0];
        for (int i = 1; i < a.length; ++i) {
            if (a[i] != x) {
                x = a[i];
            } else {
                a[i] = na;
                result++;
            }
        }
        int p1 = 0, p2 = 1;
        while (p1 < a.length && p2 < a.length) {
            if (a[p1] != na) {
                p1++;
            } else {
                p2 = p2 > p1 ? p2 : p1 + 1;
                while (p2 < a.length && a[p2] == na) p2++;
//                System.out.println("p1:" + p1 +" p2: " + p2);
                if (p2 < a.length) {
                    a[p1] = a[p2];
                    a[p2] = na;
                    p1++;
                }
            }
        }
        return a.length - result;
    }
}
