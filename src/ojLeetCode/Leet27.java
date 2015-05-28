package ojLeetCode;

import java.util.Arrays;

/**
 * Created by Mryang on 15-5-28.
 */
public class Leet27 {
    public static void main(String[] args) {
        int[] nums = {3};
        int r = delDuplicateNum(nums, 3);
        for (int e : nums) {
            System.out.print(e + " ");
        }
        System.out.println("   len:" + r);
    }

    public static int delDuplicateNum(int[] a, int val){
        int i=-1,j=0;
        for (j=0;j<a.length;j++){
            if(a[j] != val){
                i++;
                a[i] = a[j];
            }
        }
        return i+1;
    }
    public static int delDuplicateNum2(int[] a, int val) {
        Arrays.sort(a);
        int count = 0;
        int p1 = 0,p2;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == val) {
                count++;
                p1 = i;
            }
        }
        p2 = p1+1;
        p1 = p1 - count + 1;
        while (p2 < a.length){
            a[p1] = a[p2];
            p1++; p2++;
        }
        return a.length - count;
    }
}
