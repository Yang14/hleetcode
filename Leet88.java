package ojLeetCode;

/**
 * Created by Mryang on 15-6-4.
 */
public class Leet88 {
    public static void main(String[] args) {
        int[] n1 = new int[64];
        n1[0] = 0;
        n1[1] = 3;
        int[] n2 = {-2, -1, 1, 1, 3, 4, 4, 7, 7, 7, 9, 10, 11, 12, 14, 16, 17, 18, 21, 21, 24, 31, 33, 34, 35, 36, 41, 41, 46, 48, 48};
        merge(n1, 2, n2, n2.length);
        for (int e : n1)
            System.out.print(e + " ");
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        if (m != 0) {
            while (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    nums1[k] = nums1[i];
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    j--;
                }
                k--;
            }
        }
        if (m == 0 || j >= 0) {
            while (j >= 0) {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
    }

}
