package ojLeetCode;

/**
 * Created by Mryang on 15-5-27.
 */
public class Leet26 {

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,3};
        int r = removeDuplicates(nums);
        for (int e : nums) {
            System.out.print(e + " ");
        }
        System.out.println("   len:" + r);
    }

    public static int removeDuplicates(int[] a) {
        if (a == null || a.length < 1) return 0;
        int result = 0;
        int na = a[0] - 1;
        int x = a[0];
        for (int i = 1; i < a.length; ++i) {
            if (a[i] != x) {
                x = a[i];
            } else{
                a[i] = na;
                result++;
            }
        }
        int p1 = 0, p2 = 1;
        while (p1 < a.length && p2 < a.length) {
            if (a[p1] != na) {
                p1++;
            } else {
                p2 = p2 > p1 ? p2 : p1+1;
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
