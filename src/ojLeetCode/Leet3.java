package ojLeetCode;

/**
 * Created by Mryang on 15-3-27.
 */
public class Leet3 {
    public static int lengthOfLongestSubstring(String s) {
        char[] a = s.toCharArray();
        int count = 0, n = a.length,i,j,max=0;
        int [] h = new int[256];
        for(i=0;i<h.length;i++)
            h[i] = 0;
        i = j = -1;
        while (j<n-1){
            j++;
            h[a[j]]++;
            count++;
            while (i<=j && h[a[j]] > 1){
                i++;
                h[a[i]]--;
                count--;
            }
            if(count > max)
                max = count;
        }

        return max;
    }

    public static void main(String[] args){
        String str = "";
        int r = lengthOfLongestSubstring(str);
        System.out.println(r);
    }
}
