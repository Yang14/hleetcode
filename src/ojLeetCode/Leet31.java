package ojLeetCode;

import java.util.Arrays;

/**
 * Created by Mryang on 15-5-27.
 */
public class Leet31 {

    public static void main(String[] args) {
        int[] nums = {3,2,1};

//        System.out.println(partitionOneDirect(nums, 0, 2));
//
        nextPermutation(nums);
        for (int e : nums) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void nextPermutation(int[] a) {

        boolean flag = false;

        int s=0,e=a.length-1;
        for (int i = a.length - 1; i >= 0 ; i--) {

            int j;
            for (j = i - 1; j >= 0; j--) {
                if (a[i] > a[j] ) {
                    if (j > s || (j == s && a[i] < a[e])){
                        s = j;
                        e = i;
                    }
                    flag = true;
                }
            }


        }

        if (flag) {
//            System.out.println(s+"--- " + e);
            for (int k = e; k > s; k--) {
                int temp = a[k];
                a[k] = a[k - 1];
                a[k - 1] = temp;
            }
            Arrays.sort(a,s+1,a.length);
        }

         if (!flag){
             int i = 0, j = a.length - 1;
             while (i < j) {
                 int temp = a[j];
                 a[j] = a[i];
                 a[i] = temp;
                 i++;
                 j--;
             }
         }


    }

}
