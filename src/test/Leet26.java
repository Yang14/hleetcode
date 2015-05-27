package test;

/**
 * Created by Mryang on 15-5-27.
 */
public class Leet26 {

    public static void main(String[] args) {
        int[] nums = {1,1,1, 2,3,3,4,4,5};
        int r = removeDuplicates(nums);
        for (int e : nums) {
            System.out.print(e + " ");
        }
        System.out.println("   len:" + r);
    }

    public static int removeDuplicates(int[] a) {
        if (a.length <= 1) return a.length;
        int p1, p2=0;
        for (p1 = 1; p1 < a.length; ++p1) {
            if (a[0] == a[p1])
                break;
        }
        if(a[0] == a[1]) p1 = 1;
        else p1 = 2;
        p2 = p1;
        System.out.println("p1" + p1);
        while (p1 < a.length && p2 < a.length) {
            if (a[p1] != a[p2]) {
                a[p1] = a[p2];
                p1++;
                p2++;
            } else
                p2++;
        }
        return p1;
    }
}
